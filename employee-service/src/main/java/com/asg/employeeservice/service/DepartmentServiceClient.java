package com.asg.employeeservice.service;

import com.asg.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentServiceClient {


    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
