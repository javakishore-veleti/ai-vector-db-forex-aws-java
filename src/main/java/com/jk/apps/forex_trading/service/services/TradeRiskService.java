package com.jk.apps.forex_trading.service.services;

import java.util.Map;
import java.util.UUID;

public interface TradeRiskService {
    Map<String, Object> analyzeRisk(Map<String, Object> tradeBookData);

    Map<String, Object> getRiskHistory(UUID id);

    Map<String, Object> recommendHedgingStrategies(Map<String, Object> historicalTradeData);
}
