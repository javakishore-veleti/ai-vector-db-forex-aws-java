package com.jk.apps.forex_trading.service.services;

import java.util.Map;

public interface TradeAIService {
    Map<String, Object> generateMarketInsight(Map<String, Object> tradeData);
    Map<String, Object> predictLiquidityForecast();
    Map<String, Object> detectTradeAnomalies(Map<String, Object> tradeData);
    Map<String, Object> analyzeNewsImpact(Map<String, Object> newsData);
}
