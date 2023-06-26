package com.asg.departmentservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "DepartmentDto", description = "Department Data Transfer Object")
public class DepartmentDto {
    private Long id;
    @NotEmpty(message = "Name is required.")
    @Schema(description = "Name of Department", example = "IT")
    private String name;
    @Schema(description = "Description of Department", example = "IT Department")
    private String description;
    @Schema(description = "Code of Department", example = "IT")
    @NotEmpty(message = "Code is required.")
    private String code;
}
