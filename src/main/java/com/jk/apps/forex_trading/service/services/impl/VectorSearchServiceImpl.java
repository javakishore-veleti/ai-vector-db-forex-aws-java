package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.services.VectorSearchService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VectorSearchServiceImpl implements VectorSearchService {

    @Override
    public Map<String, Object> findSimilarTrades(Map<String, Object> tradeData) {
        return Map.of();
    }
}
