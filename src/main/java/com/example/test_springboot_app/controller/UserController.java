package com.example.test_springboot_app.controller;

import com.example.test_springboot_app.dto.UserResponseDto;
import com.example.test_springboot_app.dto.mapper.UserMapper;
import com.example.test_springboot_app.model.User;
import com.example.test_springboot_app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{userId}")
    public UserResponseDto findUserById(@PathVariable long userId){
        User userById = userService.findUserById(userId);
        return userMapper.toResponseDto(userById);
    }
}
