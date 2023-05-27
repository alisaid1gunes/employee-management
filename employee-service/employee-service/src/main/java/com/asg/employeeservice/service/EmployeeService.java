package com.asg.employeeservice.service;

import com.asg.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
