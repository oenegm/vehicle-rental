package com.project.vehiclerental;

import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.repository.BrandRepository;
import com.project.vehiclerental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) {
        Brand brand = Brand.builder()
                .name("BMW")
                .country("Germany")
                .imageURL("https://upload.wikimedia.org/wikipedia/commons/f/f4/BMW_logo_%28gray%29.svg")
                .build();
        User user = User.builder()
                .username("oenegm")
                .password("123456")
                .build();

        brandRepository.save(brand);
        userRepository.save(user);
    }
}

