package com.asg.departmentservice.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Name is required.")
    private String name;
    private String description;
    @NotEmpty(message = "Code is required.")
    private String code;
}
