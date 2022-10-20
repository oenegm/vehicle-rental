package com.project.vehiclerental.service;

import com.project.vehiclerental.model.User;
import com.project.vehiclerental.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }


    public User update(User user){
        return userRepository.save(user);
    }

}
