package com.example.test_springboot_app.controller;

import com.example.test_springboot_app.dto.UserRequestDto;
import com.example.test_springboot_app.dto.UserResponseDto;
import com.example.test_springboot_app.dto.mapper.UserMapper;
import com.example.test_springboot_app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        return userMapper.toResponseDto(userService.findUserInfo(userId));
    }

    @PostMapping("/create")
    public void createUser(@Valid @RequestBody UserRequestDto user) {
        System.out.println(user.getDateOfBirth());
        userService.save(userMapper.toModel(user));
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAllUsers(){
        System.out.println(userService.getAllUsers());
        return userService.getAllUsers()
                .stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
