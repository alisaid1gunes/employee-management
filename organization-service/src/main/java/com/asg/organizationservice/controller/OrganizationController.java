package com.asg.organizationservice.controller;

import com.asg.organizationservice.dto.OrganizationDto;
import com.asg.organizationservice.entity.Organization;
import com.asg.organizationservice.mapper.OrganizationMapper;
import com.asg.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
@Tag(name = "Organization Service - Organization Controller", description = "Organization Controller exposes endpoints for Organization Service")
public class OrganizationController {
    private OrganizationService organizationService;

    @Operation(summary = "Save Organization", description = "Save Organization with given OrganizationDto object and return saved OrganizationDto object ")
    @ApiResponse(responseCode = "201", description = "Organization is saved successfully")
    @PostMapping
    public ResponseEntity<OrganizationDto> save(@Valid @RequestBody Organization organization) {
        OrganizationDto organizationDto = OrganizationMapper.MAPPER.toDto(organization);

        OrganizationDto savedOrganization = organizationService.save(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }



    @Operation(summary = "Get Organization By Code", description = "Get Organization By Code with given code and return OrganizationDto object ")
    @ApiResponse(responseCode = "200", description = "Organization is fetched successfully")
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

}
