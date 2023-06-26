package com.asg.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "APIResponseDto", description = "API Response Data Transfer Object")
public class APIResponseDto {
    @Schema(description = "Employee object")
    private EmployeeDto employee;
    @Schema(description = "Department object")
    private DepartmentDto department;
    @Schema(description = "Organization object")
    private OrganizationDto organization;
}
