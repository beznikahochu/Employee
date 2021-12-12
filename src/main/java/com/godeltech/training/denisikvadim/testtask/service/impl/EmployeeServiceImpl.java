package com.godeltech.training.denisikvadim.testtask.service.impl;

import com.godeltech.training.denisikvadim.testtask.dao.EmployeeDao;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.model.Employee;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public EmployeeDto getById(Long id) {
        return modelMapper.map(employeeDao.findById(id).get(), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employees.stream().forEach(x -> employeeDtoList.add(modelMapper.map(x, EmployeeDto.class)));
        return employeeDtoList;
    }
}
