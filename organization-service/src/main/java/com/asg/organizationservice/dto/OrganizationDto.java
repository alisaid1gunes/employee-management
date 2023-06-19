package com.asg.organizationservice.dto;

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