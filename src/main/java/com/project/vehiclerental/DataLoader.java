/*
package com.project.vehiclerental;

import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.entity.Rental;
import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.entity.Vehicle;
import com.project.vehiclerental.repository.BrandRepository;
import com.project.vehiclerental.repository.RentalRepository;
import com.project.vehiclerental.repository.UserRepository;
import com.project.vehiclerental.repository.VehicleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final BrandRepository brandRepository;
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final PasswordEncoder encodePassword;

    public DataLoader(
            BrandRepository brandRepository,
            RentalRepository rentalRepository,
            UserRepository userRepository,
            VehicleRepository vehicleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.brandRepository = brandRepository;
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
        this.encodePassword = passwordEncoder;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Brand brand = Brand.builder()
                .name("BMW")
                .country("Germany")
                .imageURL("https://upload.wikimedia.org/wikipedia/commons/f/f4/BMW_logo_%28gray%29.svg")
                .build();
        User user = User.builder()
                .username("oenegm")
                .password(encodePassword.encode("password"))
                .build();
        Vehicle vehicle = Vehicle.builder()
                .owner(user)
                .brand(brand)
                .model("M3")
                .year(2022)
                .build();

        brandRepository.save(brand);
        userRepository.save(user);
        vehicleRepository.save(vehicle);

        Rental rental = Rental.builder()
                .renter(user)
                .vehicle(vehicle)
                .build();

        rentalRepository.save(rental);
    }
}
*/
