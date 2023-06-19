package com.asg.organizationservice.controller;

import com.asg.organizationservice.dto.OrganizationDto;
import com.asg.organizationservice.entity.Organization;
import com.asg.organizationservice.mapper.OrganizationMapper;
import com.asg.organizationservice.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> save(@Valid @RequestBody Organization organization) {
        OrganizationDto organizationDto = OrganizationMapper.MAPPER.toDto(organization);

        OrganizationDto savedOrganization = organizationService.save(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

}
