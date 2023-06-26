package com.asg.departmentservice.controller;

import com.asg.departmentservice.dto.DepartmentDto;
import com.asg.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Department Service - Department Controller", description = "Department Controller exposes endpoints for Department Service")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @Operation(summary = "Save Department", description = "Save Department with given DepartmentDto object and return saved DepartmentDto object ")
    @ApiResponse(responseCode = "201", description = "Department is saved successfully")
    @PostMapping
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.save(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Department By Id", description = "Get Department By Id with given id and return DepartmentDto object ")
    @ApiResponse(responseCode = "200", description = "Department is fetched successfully")
    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
