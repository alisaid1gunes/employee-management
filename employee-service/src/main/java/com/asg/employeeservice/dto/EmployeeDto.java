package com.asg.employeeservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @NotEmpty(message = "Email is required.")
    @Email(message = "Email is invalid.")
    private String email;

    @NotEmpty(message = "Department code is required.")
    private String departmentCode;

    @NotEmpty(message = "Organization code is required.")
    private String organizationCode;

}
