package com.godeltech.training.denisikvadim.testtask.service;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void create(EmployeeCreationDto employeeCreationDto);
    void update(EmployeeDto employeeDto);
    void delete(Long id);
    EmployeeDto getById(Long id);
    List<EmployeeDto> getAll();
}
