package com.asg.employeeservice.service.impl;

import com.asg.employeeservice.dto.APIResponseDto;
import com.asg.employeeservice.dto.DepartmentDto;
import com.asg.employeeservice.dto.EmployeeDto;
import com.asg.employeeservice.dto.OrganizationDto;
import com.asg.employeeservice.entity.Employee;
import com.asg.employeeservice.exception.EmailAlreadyExistException;
import com.asg.employeeservice.exception.ResourceNotFoundException;
import com.asg.employeeservice.mapper.AutoEmployeeMapper;
import com.asg.employeeservice.repository.EmployeeRepository;
import com.asg.employeeservice.service.DepartmentServiceClient;
import com.asg.employeeservice.service.EmployeeService;
import com.asg.employeeservice.service.OrganizationServiceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository ;

    DepartmentServiceClient departmentServiceClient;

    OrganizationServiceClient organizationServiceClient;
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
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getEmployeeByIdFallback")
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        DepartmentDto departmentDto = departmentServiceClient.getDepartmentByCode(employee.getDepartmentCode());
        System.out.println("departmentDto"+departmentDto.toString());
        OrganizationDto organizationDto = organizationServiceClient.getOrganizationByCode(employee.getOrganizationCode());
        System.out.println("organizationDto"+organizationDto.toString());
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        System.out.println("apiResponseDto"+apiResponseDto.toString());
        return apiResponseDto;
    }

    public APIResponseDto getEmployeeByIdFallback(Long id, Exception exception) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        DepartmentDto departmentDto = new DepartmentDto();
        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setCode("ORG001");
        organizationDto.setName("Organization 1");
        organizationDto.setDescription("Organization 1");
        apiResponseDto.setOrganization(organizationDto);
        departmentDto.setCode("RD001");
        departmentDto.setName("R&D Department");
        departmentDto.setDescription("Research and Development Department");
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
