package com.godeltech.training.denisikvadim.testtask.service.impl;

import com.godeltech.training.denisikvadim.testtask.dao.EmployeeDao;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeModificationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.exception.NotFoundException;
import com.godeltech.training.denisikvadim.testtask.model.Employee;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final ModelMapper modelMapper;

    @Override
    public void create(EmployeeModificationDto employeeModificationDto) {
        Employee employee = modelMapper.map(employeeModificationDto, Employee.class);
        employeeDao.create(employee);
    }

    @Override
    public void update(Long id, EmployeeModificationDto employeeModificationDto) {
        Employee employee = modelMapper.map(employeeModificationDto, Employee.class);
        employee.setId(id);
        employeeDao.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee employee = employeeDao.findById(id).orElseThrow(NotFoundException::new);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employees.forEach(employee -> employeeDtoList.add(modelMapper.map(employee, EmployeeDto.class)));
        return employeeDtoList;
    }
}
