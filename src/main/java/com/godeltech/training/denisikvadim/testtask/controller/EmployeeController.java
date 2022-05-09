package com.godeltech.training.denisikvadim.testtask.controller;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeModificationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody EmployeeModificationDto employeeModificationDto) {
        employeeService.create(employeeModificationDto);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable Long id, @RequestBody EmployeeModificationDto employeeDto) {
        employeeService.update(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
