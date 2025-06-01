package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.services.SystemConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/config")
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    public SystemConfigController(SystemConfigService systemConfigService) {
        this.systemConfigService = systemConfigService;
    }

    // Retrieve current vector database settings
    @GetMapping("/vector-db")
    public ResponseEntity<Map<String, Object>> getVectorDBSettings() {
        Map<String, Object> vectorDbConfig = systemConfigService.getVectorDBSettings();
        return ResponseEntity.ok(vectorDbConfig);
    }

    // Check AWS AI service integration status
    @GetMapping("/aws-services")
    public ResponseEntity<Map<String, Object>> getAWSServiceStatus() {
        Map<String, Object> awsStatus = systemConfigService.getAWSServiceStatus();
        return ResponseEntity.ok(awsStatus);
    }

    // Fetch system logs related to trade processing
    @GetMapping("/logs")
    public ResponseEntity<Map<String, Object>> getSystemLogs() {
        Map<String, Object> systemLogs = systemConfigService.getSystemLogs();
        return ResponseEntity.ok(systemLogs);
    }
}
