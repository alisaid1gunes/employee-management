package com.asg.departmentservice.mapper;

import com.asg.departmentservice.dto.DepartmentDto;
import com.asg.departmentservice.entity.Department;

public class DepartmentMapper implements AutoDepartmentMapper{
    @Override
    public DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription(),
                department.getCode()
        );
    }

    @Override
    public Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getCode()
        );
    }
}
