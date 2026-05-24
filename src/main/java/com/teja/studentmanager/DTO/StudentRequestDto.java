package com.teja.studentmanager.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    @Min(value=1,message="Id must be greater than 1")
    private int id;
    @NotBlank(message = "Name should not be empty")
    private String name;
    @Email(message = "Enter valid email")
    private String email;
    @NotBlank(message = "Department should not be empty")
    private String department;
    @Pattern(regexp = "\\d{10}", message = "Phone number must contain exactly 10 digits")
    private String phone;
}
