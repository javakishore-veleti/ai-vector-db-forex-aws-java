package com.jk.apps.forex_trading.service.services;

import java.util.Map;

public interface VectorSearchService {
    Map<String, Object> findSimilarTrades(Map<String, Object> tradeData);
}
