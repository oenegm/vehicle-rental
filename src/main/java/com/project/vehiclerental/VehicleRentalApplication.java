package com.project.vehiclerental;

import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.entity.Authority;
import com.project.vehiclerental.entity.Role;
import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.repository.BrandRepository;
import com.project.vehiclerental.repository.AuthorityRepository;
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
import java.util.Set;

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
        // TODO: fix the issue of the application not starting
        return args -> {
            Brand brand = Brand.builder()
                    .name("BMW")
                    .country("Germany")
                    .imageURL("https://upload.wikimedia.org/wikipedia/commons/f/f4/BMW_logo_%28gray%29.svg")
                    .build();
            brandRepository.save(brand);

            Authority readAuthority = authorityRepository.save(
                    Authority.builder()
                    .name("READ")
                    .build()
            );
            Authority writeAuthority = authorityRepository.save(
                    Authority.builder()
                    .name("WRITE")
                    .build()
            );

            Role adminRole = roleRepository.save(
                    Role.builder()
                    .name("ROLE_ADMIN")
                    .authorities(Set.of(readAuthority, writeAuthority))
                    .build()
            );
            Role  userRole = roleRepository.save(
                    Role.builder()
                    .name("ROLE_USER")
                    .authorities(Set.of(readAuthority))
                    .build()
            );

            User admin = User.builder()
                    .username("admin")
                    .password("123456")
                    .role(adminRole)
                    .build();
            User user = User.builder()
                    .username("oenegm")
                    .password("123456")
                    .role(userRole)
                    .build();
            userRepository.saveAll(List.of(admin, user));
        };
    }
}
