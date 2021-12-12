package com.godeltech.training.denisikvadim.testtask.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

import com.godeltech.training.denisikvadim.testtask.dao.EmployeeDao;
import com.godeltech.training.denisikvadim.testtask.dto.EmployeeDto;
import com.godeltech.training.denisikvadim.testtask.model.Employee;
import com.godeltech.training.denisikvadim.testtask.service.EmployeeService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

class EmployeeServiceImplTest {

  private static final Long EMPLOYEE_ID = 1L;
  private static ModelMapper modelMapper;
  private static EmployeeService employeeService;

  @Mock
  private static EmployeeDao employeeDaoMock = mock(EmployeeDao.class);

  @BeforeAll
  public static void init() {
    modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true)
        .setSkipNullEnabled(true)
        .setFieldAccessLevel(PRIVATE);
    employeeService = new EmployeeServiceImpl(employeeDaoMock, modelMapper);
  }

  @Test
  void getByIdNonNullTest() {
    final String employeeName = "Ihar";
    Employee employeeMock = new Employee();
    employeeMock.setId(EMPLOYEE_ID);
    employeeMock.setFirstName(employeeName);

    when(employeeDaoMock.findById(EMPLOYEE_ID)).thenReturn(Optional.of(employeeMock));

    Optional<EmployeeDto> employeeDtoOptional = employeeService.getById(EMPLOYEE_ID);

    verify(employeeDaoMock, times(1)).findById(EMPLOYEE_ID);
    assertTrue(employeeDtoOptional.isPresent(), "Returned result must be present");
    assertEquals(EMPLOYEE_ID, employeeDtoOptional.get().getId(),
        "Id must be equal to " + EMPLOYEE_ID);
    assertEquals(employeeName, employeeDtoOptional.get().getFirstName(),
        "First name must be equal to " + employeeName);
    reset(employeeDaoMock);
  }

  @Test
  void getByIdNullTest() {
    when(employeeDaoMock.findById(EMPLOYEE_ID)).thenReturn(Optional.empty());

    Optional<EmployeeDto> employeeDtoOptional = employeeService.getById(EMPLOYEE_ID);

    verify(employeeDaoMock, times(1)).findById(EMPLOYEE_ID);
    assertFalse(employeeDtoOptional.isPresent(), "Returned result must not be present");
    reset(employeeDaoMock);
  }

}