package com.asg.departmentservice.controller;

import com.asg.departmentservice.dto.DepartmentDto;
import com.asg.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.save(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

}
