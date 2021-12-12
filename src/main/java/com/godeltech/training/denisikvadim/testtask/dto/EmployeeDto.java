package com.godeltech.training.denisikvadim.testtask.dto;

import com.godeltech.training.denisikvadim.testtask.model.enumeration.Gender;
import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeDto {

  private Long id;
  private String firstName;
  private String lastName;
  private Long departmentId;
  private String jobTitle;
  private Gender gender;
  private LocalDate dateOfBirth;
}
