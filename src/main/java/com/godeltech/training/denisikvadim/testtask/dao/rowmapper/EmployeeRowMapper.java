package com.godeltech.training.denisikvadim.testtask.dao.rowmapper;


import com.godeltech.training.denisikvadim.testtask.model.Employee;
import com.godeltech.training.denisikvadim.testtask.model.enumeration.Gender;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
    Employee employee = new Employee();
    employee.setId(rs.getLong("employee_id"));
    employee.setFirstName(rs.getString("first_name"));
    employee.setLastName(rs.getString("last_name"));
    employee.setDepartmentId(rs.getLong("department_id"));
    employee.setJobTitle(rs.getString("job_title"));
    employee.setGender(Gender.valueOf(rs.getString("gender")));
    employee.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
    return employee;
  }
}
