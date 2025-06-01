package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.services.SystemConfigService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Override
    public Map<String, Object> getVectorDBSettings() {
        Map<String, Object> vectorDbConfig = new HashMap<>();
        vectorDbConfig.put("vector_db", "Pinecone");
        vectorDbConfig.put("config_status", "Active");
        return vectorDbConfig;
    }

    @Override
    public Map<String, Object> getAWSServiceStatus() {
        Map<String, Object> awsStatus = new HashMap<>();
        awsStatus.put("bedrock_status", "Running");
        awsStatus.put("sagemaker_status", "Deployed");
        awsStatus.put("forecast_status", "Processing");
        return awsStatus;
    }

    @Override
    public Map<String, Object> getSystemLogs() {
        Map<String, Object> systemLogs = new HashMap<>();
        systemLogs.put("latest_log", "Trade processed successfully at 10:30 AM.");
        systemLogs.put("error_logs", "No errors detected.");
        return systemLogs;
    }
}
