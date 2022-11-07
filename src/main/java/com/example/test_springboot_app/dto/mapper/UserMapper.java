package com.example.test_springboot_app.dto.mapper;

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
        userResponseDto.setAge(userService.calculateAge(user.getDateOfBirth()));
        return userResponseDto;
    }
}
