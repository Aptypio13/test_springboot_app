package com.example.test_springboot_app.service;

import java.time.LocalDate;
import com.example.test_springboot_app.model.User;

public interface UserService {
    int calculateAge(LocalDate dateOfBirth);

    User findUserById(long id);
}
