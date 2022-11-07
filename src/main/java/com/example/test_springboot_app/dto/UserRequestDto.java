package com.example.test_springboot_app.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class UserRequestDto {
    @NotBlank
    private String name;
    @Past
    private LocalDate dateOfBirth;
}
