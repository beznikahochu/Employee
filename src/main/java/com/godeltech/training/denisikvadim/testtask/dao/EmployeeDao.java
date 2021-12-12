package com.godeltech.training.denisikvadim.testtask.dao;

import com.godeltech.training.denisikvadim.testtask.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    void create(Employee employee);
    void update(Employee employee);
    void deleteById(Long id);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
}
