package com.asg.employeeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrganizationDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 100)
    @NotEmpty
    @NotBlank
    String name;
    String description;
    @NotNull
    @Size(max = 50)
    @NotEmpty
    @NotBlank
    String code;
    LocalDateTime createdDate;
}