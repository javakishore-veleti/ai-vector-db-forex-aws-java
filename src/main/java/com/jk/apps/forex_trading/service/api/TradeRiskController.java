package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.services.TradeRiskService;
import com.jk.apps.forex_trading.service.services.VectorSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TradeRiskController {

    private final TradeRiskService tradeRiskService;
    private final VectorSearchService vectorSearchService;

    public TradeRiskController(TradeRiskService tradeRiskService, VectorSearchService vectorSearchService) {
        this.tradeRiskService = tradeRiskService;
        this.vectorSearchService = vectorSearchService;
    }

    // Find similar trades using vector database search
    @PostMapping("/trades/similar")
    public ResponseEntity<Map<String, Object>> findSimilarTrades(@RequestBody Map<String, Object> tradeData) {
        Map<String, Object> similarTrades = vectorSearchService.findSimilarTrades(tradeData);
        return ResponseEntity.ok(similarTrades);
    }

    // Perform risk analysis on a trading book
    @PostMapping("/risk/analyze")
    public ResponseEntity<Map<String, Object>> analyzeRisk(@RequestBody Map<String, Object> tradeBookData) {
        Map<String, Object> riskAnalysis = tradeRiskService.analyzeRisk(tradeBookData);
        return ResponseEntity.ok(riskAnalysis);
    }

    // Retrieve historical risk assessment for a trade
    @GetMapping("/risk/history/{id}")
    public ResponseEntity<Map<String, Object>> getRiskHistory(@PathVariable UUID id) {
        Map<String, Object> riskHistory = tradeRiskService.getRiskHistory(id);
        return riskHistory != null ? ResponseEntity.ok(riskHistory) : ResponseEntity.notFound().build();
    }

    // Suggest hedging strategies based on historical data
    @PostMapping("/trades/hedge-recommendation")
    public ResponseEntity<Map<String, Object>> recommendHedgingStrategies(@RequestBody Map<String, Object> historicalTradeData) {
        Map<String, Object> hedgingStrategies = tradeRiskService.recommendHedgingStrategies(historicalTradeData);
        return ResponseEntity.ok(hedgingStrategies);
    }
}
