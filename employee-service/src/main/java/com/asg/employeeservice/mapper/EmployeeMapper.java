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
                employee.getEmail(),
                employee.getDepartmentCode()
        );

    }

    @Override
    public Employee mapToEmployee(EmployeeDto employeeDto) {
        System.out.println( "employeeDto in mapper"+ employeeDto);
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }
}
