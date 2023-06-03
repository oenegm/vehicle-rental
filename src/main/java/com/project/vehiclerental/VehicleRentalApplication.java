package com.project.vehiclerental;

import com.project.vehiclerental.entity.Authority;
import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.entity.Role;
import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.repository.AuthorityRepository;
import com.project.vehiclerental.repository.BrandRepository;
import com.project.vehiclerental.repository.RoleRepository;
import com.project.vehiclerental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@RequiredArgsConstructor
public class VehicleRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleRentalApplication.class, args);
    }


    @Bean
    public ApplicationRunner applicationRunner(
            UserRepository userRepository,
            BrandRepository brandRepository,
            RoleRepository roleRepository,
            AuthorityRepository authorityRepository
    ) {
        return args -> {
            Brand brand = Brand.builder()
                    .name("BMW")
                    .country("Germany")
                    .imageURL("https://upload.wikimedia.org/wikipedia/commons/f/f4/BMW_logo_%28gray%29.svg")
                    .build();
            brandRepository.save(brand);

            authorityRepository.save(
                    Authority.builder()
                            .name("READ")
                            .build()
            );
            authorityRepository.save(
                    Authority.builder()
                            .name("WRITE")
                            .build()
            );

            roleRepository.save(
                    Role.builder()
                            .name("ROLE_ADMIN")
                            .authorities(authorityRepository.findAll())
                            .build()
            );
            roleRepository.save(
                    Role.builder()
                            .name("ROLE_USER")
                            .authorities(
                                    List.of(
                                            authorityRepository.findByName("READ")
                                                    .orElseThrow(() -> new RuntimeException("Authority not found"))
                                    )
                            )
                            .build()
            );

            User admin = User.builder()
                    .username("admin")
                    .password("123456")
                    .role(
                            roleRepository.findByName("ROLE_ADMIN")
                                    .orElseThrow(() -> new RuntimeException("Role not found"))
                    )
                    .build();
            User user = User.builder()
                    .username("oenegm")
                    .password("123456")
                    .role(
                            roleRepository.findByName("ROLE_USER")
                                    .orElseThrow(() -> new RuntimeException("Role not found"))
                    )
                    .build();
            userRepository.saveAll(List.of(admin, user));
        };
    }
}
