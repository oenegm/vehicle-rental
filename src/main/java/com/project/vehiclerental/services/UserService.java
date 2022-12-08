package com.project.vehiclerental.services;

import com.project.vehiclerental.exceptions.UserNotFoundException;
import com.project.vehiclerental.models.User;
import com.project.vehiclerental.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //TODO: Implement custom exceptions
    public User updateUser(Long id, User user){
        User oldUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        oldUser.setUsername(user.getUsername());
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setGender(user.getGender());

        return userRepository.save(oldUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }



}
