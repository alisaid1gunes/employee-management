package com.asg.employeeservice.mapper;

import com.asg.employeeservice.dto.EmployeeDto;
import com.asg.employeeservice.entity.Employee;

public class EmployeeMapper implements AutoEmployeeMapper{
    @Override
    public EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    @Override
    public Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
