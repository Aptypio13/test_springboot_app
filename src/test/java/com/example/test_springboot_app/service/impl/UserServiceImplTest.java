package com.example.test_springboot_app.service.impl;

import com.example.test_springboot_app.model.User;
import com.example.test_springboot_app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private static final int AGE_CONST = 22;
    private static final int ID_CONST = 1;
    private static final String DATE_CONST = "2000-01-01";
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void calculateEmptyDate_NotOk() {
        Assertions.assertThrows(NullPointerException.class,
                () -> userService.calculateAge(null));
    }

    @Test
    void calculateAge_Ok() {
        LocalDate testDateBirth = LocalDate.parse(DATE_CONST);
        int actual = userService.calculateAge(testDateBirth);
        Assertions.assertEquals(AGE_CONST, actual);
    }

    @Test
    void findUserBiId_Ok() {
        User expected = new User();
        expected.setId(ID_CONST);
        expected.setDateOfBirth(LocalDate.parse(DATE_CONST));
        expected.setName("Pique");
        Mockito.when(userRepository.findById((long) ID_CONST)).thenReturn(Optional.of(expected));

        User actual = userService.findUserById(ID_CONST);
        Assertions.assertEquals(actual, expected);
    }

}