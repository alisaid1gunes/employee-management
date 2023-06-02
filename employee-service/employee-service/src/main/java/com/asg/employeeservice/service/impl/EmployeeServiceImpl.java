package com.asg.employeeservice.service.impl;

import com.asg.employeeservice.dto.APIResponseDto;
import com.asg.employeeservice.dto.DepartmentDto;
import com.asg.employeeservice.dto.EmployeeDto;
import com.asg.employeeservice.entity.Employee;
import com.asg.employeeservice.exception.EmailAlreadyExistException;
import com.asg.employeeservice.exception.ResourceNotFoundException;
import com.asg.employeeservice.mapper.AutoEmployeeMapper;
import com.asg.employeeservice.repository.EmployeeRepository;
import com.asg.employeeservice.service.APIClient;
import com.asg.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository ;

    APIClient apiclient;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employeeDto.getEmail());
        if (employeeOptional.isPresent()) {
            throw new EmailAlreadyExistException("Email already exists");
        }

        System.out.println(employeeDto);
        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        System.out.println(employee);


        Employee savedEmployee = employeeRepository.save(employee);

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        DepartmentDto departmentDto = apiclient.getDepartmentByCode(employee.getDepartmentCode());
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
