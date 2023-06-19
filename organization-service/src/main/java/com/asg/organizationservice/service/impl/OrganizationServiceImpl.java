package com.asg.organizationservice.service.impl;

import com.asg.organizationservice.dto.OrganizationDto;
import com.asg.organizationservice.entity.Organization;
import com.asg.organizationservice.mapper.OrganizationMapper;
import com.asg.organizationservice.repository.OrganizationRepository;
import com.asg.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.MAPPER.toEntity(organizationDto);
        Organization saved = organizationRepository.save(organization);
        return OrganizationMapper.MAPPER.toDto(saved);

    }



}
