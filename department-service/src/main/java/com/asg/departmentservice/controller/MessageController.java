package com.asg.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Tag(name = "Department Service - Message Controller", description = "Message Controller exposes endpoints for Department Service")
public class MessageController {
   @Value("${spring.boot.message}")
    private String message;

    @Operation(summary = "Get Message", description = "Get Message from Config Server")
    @ApiResponse(responseCode = "200", description = "Message is fetched successfully")
    @GetMapping("message")
    public String getMessage() {
        return this.message;
    }
}
