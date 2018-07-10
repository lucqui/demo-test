package com.example.api2cart.demotest.controller;

import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO){

        userService.add(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
