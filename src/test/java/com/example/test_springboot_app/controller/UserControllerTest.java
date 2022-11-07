package com.example.test_springboot_app.controller;

import com.example.test_springboot_app.model.User;
import com.example.test_springboot_app.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void shouldReturnUserById() throws Exception {
        int userId = 1;
        User expected = new User();
        expected.setId(userId);
        expected.setDateOfBirth(LocalDate.parse("2000-02-13"));
        expected.setName("Pique");
        Mockito.when(userService.findUserById(userId)).thenReturn(expected);

        MvcResult result = RestAssuredMockMvc.get("/users/{userId}", userId).getMvcResult();
        User actual = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);

        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getName(), actual.getName());
        Assertions.assertEquals(userService.calculateAge(expected.getDateOfBirth()), userService.calculateAge(actual.getDateOfBirth()));
    }
}
