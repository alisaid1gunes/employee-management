package com.asg.employeeservice.controller;

import com.asg.employeeservice.dto.APIResponseDto;
import com.asg.employeeservice.dto.EmployeeDto;
import com.asg.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Tag(name = "Employee Service - Employee Controller", description = "Employee Controller exposes endpoints for Employee Service")
public class EmployeeController {
    EmployeeService employeeService;

    @Operation(summary = "Save Employee", description = "Save Employee with given EmployeeDto object and return saved EmployeeDto object ")
    @ApiResponse(responseCode = "201", description = "Employee is saved successfully")
    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.save(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Employee By Id", description = "Get Employee By Id with given id and return EmployeeDto object ")
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
