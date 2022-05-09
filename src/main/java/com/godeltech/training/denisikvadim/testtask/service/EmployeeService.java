package com.godeltech.training.denisikvadim.testtask.service;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeModificationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void create(EmployeeModificationDto employeeModificationDto);

    void update(Long id, EmployeeModificationDto employeeModificationDto);

    void delete(Long id);

    EmployeeDto getById(Long id);

    List<EmployeeDto> getAll();
}
