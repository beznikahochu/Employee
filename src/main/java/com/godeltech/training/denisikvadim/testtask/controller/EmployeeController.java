package com.godeltech.training.denisikvadim.testtask.controller;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void create(@RequestBody EmployeeCreationDto employeeCreationDto) {
        employeeService.create(employeeCreationDto);
    }

    @PutMapping
    private void update(@RequestBody EmployeeDto employeeDto) {
        employeeService.update(employeeDto);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

}
