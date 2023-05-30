package com.asg.employeeservice.service;

import com.asg.employeeservice.dto.APIResponseDto;
import com.asg.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
