package com.asg.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;


/**
 * DTO for {@link com.asg.organizationservice.entity.Organization}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Schema(name = "OrganizationDto", description = "Organization Data Transfer Object")
public class OrganizationDto implements Serializable {
    Long id;
    @NotNull
    @Size(max = 100)
    @NotEmpty
    @NotBlank
    @Schema(description = "Name of Organization", example = "IT")
    String name;
    @Schema(description = "Description of Organization", example = "IT Department")
    String description;
    @NotNull
    @Size(max = 50)
    @NotEmpty
    @NotBlank
    @Schema(description = "Code of Organization", example = "IT")
    String code;
    @Schema(description = "Created date of Organization", example = "2021-08-01T00:00:00")
    LocalDateTime createdDate;
}