package com.asg.organizationservice.mapper;

import com.asg.organizationservice.dto.OrganizationDto;
import com.asg.organizationservice.entity.Organization;

public class OrganizationMapperImpl implements OrganizationMapper {
    @Override
    public Organization toEntity(OrganizationDto organizationDto) {
        return new Organization(organizationDto.getId(), organizationDto.getName(), organizationDto.getDescription(), organizationDto.getCode(), organizationDto.getCreatedDate());
    }

    @Override
    public OrganizationDto toDto(Organization organization) {
        return new OrganizationDto(organization.getId(), organization.getName(), organization.getDescription(), organization.getCode(), organization.getCreatedDate());
    }

    @Override
    public Organization partialUpdate(OrganizationDto organizationDto, Organization organization) {
        if (organizationDto.getName() != null) {
            organization.setName(organizationDto.getName());
        }
        if (organizationDto.getDescription() != null) {
            organization.setDescription(organizationDto.getDescription());
        }
        if (organizationDto.getCode() != null) {
            organization.setCode(organizationDto.getCode());
        }
        if (organizationDto.getCreatedDate() != null) {
            organization.setCreatedDate(organizationDto.getCreatedDate());
        }
        return organization;
    }
}
