package com.asg.departmentservice.service.impl;

import com.asg.departmentservice.dto.DepartmentDto;
import com.asg.departmentservice.entity.Department;
import com.asg.departmentservice.exception.CodeAlreadyExistException;
import com.asg.departmentservice.exception.ResourceNotFoundException;
import com.asg.departmentservice.mapper.AutoDepartmentMapper;
import com.asg.departmentservice.repository.DepartmentRepository;
import com.asg.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Optional<Department> employeeOptional = departmentRepository.findByCode(departmentDto.getCode());
        if (employeeOptional.isPresent()) {
            throw new CodeAlreadyExistException("Code already exists");
        }
        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Department", "code", code));
        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
