package com.asg.employeeservice.service;

import com.asg.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
