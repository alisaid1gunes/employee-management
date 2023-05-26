package com.asg.departmentservice.service.impl;

import com.asg.departmentservice.dto.DepartmentDto;
import com.asg.departmentservice.entity.Department;
import com.asg.departmentservice.repository.DepartmentRepository;
import com.asg.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription(),
                departmentDto.getCode()
        );
       Department savedDepartment =  departmentRepository.save(department);

        return new DepartmentDto(
               savedDepartment.getId(),
               savedDepartment.getName(),
               savedDepartment.getDescription(),
               savedDepartment.getCode()
        );
    }
}
