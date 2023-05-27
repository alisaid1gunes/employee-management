package com.asg.employeeservice.controller;

import com.asg.employeeservice.Dto.EmployeeDto;
import com.asg.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.save(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
