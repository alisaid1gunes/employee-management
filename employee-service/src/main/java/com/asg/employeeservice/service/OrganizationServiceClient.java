package com.asg.employeeservice.service;

import com.asg.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationServiceClient {

        @GetMapping("/api/organizations/{code}")
        OrganizationDto getOrganizationByCode(@PathVariable String code);
}
