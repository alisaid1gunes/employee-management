package com.asg.employeeservice.service.impl;

import com.asg.employeeservice.Dto.EmployeeDto;
import com.asg.employeeservice.entity.Employee;
import com.asg.employeeservice.exception.EmailAlreadyExistException;
import com.asg.employeeservice.exception.ResourceNotFoundException;
import com.asg.employeeservice.mapper.AutoEmployeeMapper;
import com.asg.employeeservice.repository.EmployeeRepository;
import com.asg.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository ;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employeeDto.getEmail());
        if (employeeOptional.isPresent()) {
            throw new EmailAlreadyExistException("Email already exists");
        }
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
