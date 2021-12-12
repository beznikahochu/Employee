package com.godeltech.training.denisikvadim.testtask.service.impl;

import com.godeltech.training.denisikvadim.testtask.dao.EmployeeDao;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.model.Employee;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;
  private final ModelMapper modelMapper;

  @Override
  public void create(EmployeeCreationDto employeeCreationDto) {
    Employee employee = modelMapper.map(employeeCreationDto, Employee.class);
    employeeDao.create(employee);
  }

  @Override
  public void update(EmployeeDto employeeDto) {
    Employee employee = modelMapper.map(employeeDto, Employee.class);
    employeeDao.update(employee);
  }

  @Override
  public void delete(Long id) {
    employeeDao.deleteById(id);
  }

  @Override
  public Optional<EmployeeDto> getById(Long id) {
    Optional<Employee> employeeOptional = employeeDao.findById(id);
    return employeeOptional.map(employee -> modelMapper.map(employee, EmployeeDto.class));
  }

  @Override
  public List<EmployeeDto> getAll() {
    List<Employee> employees = employeeDao.findAll();
    List<EmployeeDto> employeeDtoList = new ArrayList<>();
    employees.forEach(
        employee -> employeeDtoList.add(modelMapper.map(employee, EmployeeDto.class)));
    return employeeDtoList;
  }
}
