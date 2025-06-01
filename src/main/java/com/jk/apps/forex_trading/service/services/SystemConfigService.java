package com.jk.apps.forex_trading.service.services;

import java.util.Map;

public interface SystemConfigService {
    Map<String, Object> getVectorDBSettings();
    Map<String, Object> getAWSServiceStatus();
    Map<String, Object> getSystemLogs();
}
