package com.example.test_springboot_app.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import com.example.test_springboot_app.model.User;
import com.example.test_springboot_app.repository.UserRepository;
import com.example.test_springboot_app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int calculateAge(LocalDate localDate) {
        System.out.println(Period.between(localDate, LocalDate.now()).getYears());
        return Period.between(localDate, LocalDate.now()).getYears();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserInfo(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("no such user with id: " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
