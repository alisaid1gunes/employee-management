package com.asg.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "EmployeeDto", description = "Employee Data Transfer Object")
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "First name is required.")
    @Schema(description = "First name of Employee", example = "John")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Schema(description = "Last name of Employee", example = "Doe")
    private String lastName;

    @NotEmpty(message = "Email is required.")
    @Email(message = "Email is invalid.")
    @Schema(description = "Email of Employee", example = "johndoe@gmail.com")
    private String email;

    @NotEmpty(message = "Department code is required.")
    @Schema(description = "Department code of Employee", example = "IT")
    private String departmentCode;

    @NotEmpty(message = "Organization code is required.")
    @Schema(description = "Organization code of Employee", example = "IT")
    private String organizationCode;

}
