package com.godeltech.training.denisikvadim.testtask.controller;

import com.godeltech.training.denisikvadim.testtask.dto.EmployeeCreationDto;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
    Optional<EmployeeDto> employeeDtoOptional = employeeService.getById(id);
    return employeeDtoOptional.map(employeeDto -> new ResponseEntity(employeeDto, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
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
