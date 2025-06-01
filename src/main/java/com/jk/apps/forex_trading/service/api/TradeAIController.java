package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.services.TradeAIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class TradeAIController {

    private final TradeAIService tradeAIService;

    public TradeAIController(TradeAIService tradeAIService) {
        this.tradeAIService = tradeAIService;
    }

    // Generate AI-powered market insights using AWS Bedrock
    @PostMapping("/generate-insight")
    public ResponseEntity<Map<String, Object>> generateMarketInsight(@RequestBody Map<String, Object> tradeData) {
        Map<String, Object> insights = tradeAIService.generateMarketInsight(tradeData);
        return ResponseEntity.ok(insights);
    }

    // Predict future liquidity based on historical trends
    @GetMapping("/liquidity-forecast")
    public ResponseEntity<Map<String, Object>> predictLiquidityForecast() {
        Map<String, Object> forecast = tradeAIService.predictLiquidityForecast();
        return ResponseEntity.ok(forecast);
    }

    // Detect anomalies in trading activity using AI models
    @PostMapping("/anomaly-detection")
    public ResponseEntity<Map<String, Object>> detectTradeAnomalies(@RequestBody Map<String, Object> tradeData) {
        Map<String, Object> anomalies = tradeAIService.detectTradeAnomalies(tradeData);
        return ResponseEntity.ok(anomalies);
    }

    // Analyze trade impact based on financial news events
    @PostMapping("/news-impact")
    public ResponseEntity<Map<String, Object>> analyzeNewsImpact(@RequestBody Map<String, Object> newsData) {
        Map<String, Object> impactAnalysis = tradeAIService.analyzeNewsImpact(newsData);
        return ResponseEntity.ok(impactAnalysis);
    }
}

