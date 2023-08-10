package com.project.vehiclerental.controller;

import com.project.vehiclerental.dto.UserDto;
import com.project.vehiclerental.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUser());
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(userDto));
    }

    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(
            @Valid @RequestBody UserDto userDto,
            @PathVariable("userId") Long userId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(userId, userDto));
    }


    @PatchMapping(value = "{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> patchUser(
            @PathVariable("userId") Long userId,
            @RequestBody UserDto userDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(userId, userDto));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
