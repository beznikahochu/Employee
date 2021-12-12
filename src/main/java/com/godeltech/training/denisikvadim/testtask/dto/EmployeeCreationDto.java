package com.godeltech.training.denisikvadim.testtask.dto;

import com.godeltech.training.denisikvadim.testtask.model.enumeration.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeCreationDto {
    private String firstName;
    private String lastName;
    private Long departmentId;
    private String jobTitle;
    private Gender gender;
    private LocalDate dateOfBirth;
}
