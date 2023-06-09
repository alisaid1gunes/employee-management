package com.asg.organizationservice.service;

import com.asg.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto save(OrganizationDto organizationDto);
    OrganizationDto getOrganizationById(Long id);

    OrganizationDto getOrganizationByCode(String code);

}
