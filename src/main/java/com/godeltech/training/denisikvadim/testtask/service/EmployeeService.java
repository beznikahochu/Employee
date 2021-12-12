package com.godeltech.training.denisikvadim.testtask.service;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  void create(EmployeeCreationDto employeeCreationDto);

  void update(EmployeeDto employeeDto);

  void delete(Long id);

  Optional<EmployeeDto> getById(Long id);

  List<EmployeeDto> getAll();
}
