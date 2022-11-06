package com.example.test_springboot_app.dto.mapper;

import com.example.test_springboot_app.dto.UserRequestDto;
import com.example.test_springboot_app.dto.UserResponseDto;
import com.example.test_springboot_app.model.User;
import com.example.test_springboot_app.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final UserService userService;

    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto toResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setId(user.getId());
        userResponseDto.setAge(user.getAge());
        return userResponseDto;
    }

    public User toModel(UserRequestDto userRequestDto) {
        User user = new User();
        int age = userService.calculateAge(userRequestDto.getDateOfBirth());
        user.setAge(age);
        user.setName(userRequestDto.getName());
        System.out.println(userRequestDto.getDateOfBirth());
        return user;
    }

}
