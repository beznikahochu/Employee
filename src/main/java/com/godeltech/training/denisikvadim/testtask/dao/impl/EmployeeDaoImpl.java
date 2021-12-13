package com.godeltech.training.denisikvadim.testtask.dao.impl;

import com.godeltech.training.denisikvadim.testtask.dao.EmployeeDao;
import com.godeltech.training.denisikvadim.testtask.dao.rowmapper.EmployeeRowMapper;
import com.godeltech.training.denisikvadim.testtask.model.Employee;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public void create(Employee employee) {
    String sql =
        "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)\n"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(
        sql,
        employee.getFirstName(),
        employee.getLastName(),
        employee.getDepartmentId(),
        employee.getJobTitle(),
        employee.getGender().toString(),
        employee.getDateOfBirth()
    );
  }

  @Override
  public void update(Employee employee) {
    String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birth = ? WHERE employee_id = ?";
    jdbcTemplate.update(
        sql,
        employee.getFirstName(),
        employee.getLastName(),
        employee.getDepartmentId(),
        employee.getJobTitle(),
        employee.getGender().toString(),
        employee.getDateOfBirth(),
        employee.getId()
    );
  }

  @Override
  public void deleteById(Long id) {
    jdbcTemplate.update("DELETE FROM employee WHERE employee_id = " + id);
  }

  @Override
  public Optional<Employee> findById(Long id) {
    return jdbcTemplate.query("SELECT * FROM employee WHERE employee_id = " + id,
            new EmployeeRowMapper())
        .stream().findFirst();
  }

  @Override
  public List<Employee> findAll() {
    return jdbcTemplate.query("SELECT * FROM employee", new EmployeeRowMapper());
  }
}
