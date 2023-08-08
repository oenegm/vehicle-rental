package com.project.vehiclerental;

import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.entity.Role;
import com.project.vehiclerental.entity.User;
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
import org.springframework.security.crypto.password.PasswordEncoder;

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
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            Brand brand = Brand.builder()
                    .name("BMW")
                    .country("Germany")
                    .imageURL("https://upload.wikimedia.org/wikipedia/commons/f/f4/BMW_logo_%28gray%29.svg")
                    .build();
            brandRepository.save(brand);


            roleRepository.save(
                    Role.builder()
                            .name("ADMIN")
                            .build()
            );
            roleRepository.save(
                    Role.builder()
                            .name("USER")
                            .build()
            );

            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("123456"))
                    .role(
                            roleRepository.findByName("ADMIN")
                                    .orElseThrow(() -> new RuntimeException("Role not found"))
                    )
                    .build();
            User user = User.builder()
                    .username("oenegm")
                    .password(passwordEncoder.encode("123456"))
                    .role(
                            roleRepository.findByName("USER")
                                    .orElseThrow(() -> new RuntimeException("Role not found"))
                    )
                    .build();
            userRepository.saveAll(List.of(admin, user));
        };
    }
}
