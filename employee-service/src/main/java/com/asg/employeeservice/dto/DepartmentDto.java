package com.asg.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Name is required.")
    private String name;
    private String description;
    @NotEmpty(message = "Code is required.")
    private String code;
}
