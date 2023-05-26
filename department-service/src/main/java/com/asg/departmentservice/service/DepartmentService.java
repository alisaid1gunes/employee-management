package com.asg.departmentservice.service;

import com.asg.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
