package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.entity.Trade;
import com.jk.apps.forex_trading.service.services.TradeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Trade Event Processing", description = "APIs for managing trade events")
@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    // Create a new trade event
    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
        Trade savedTrade = tradeService.saveTrade(trade);
        return ResponseEntity.ok(savedTrade);
    }

    // Retrieve trade details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable String id) {
        Trade trade = tradeService.getTradeById(id);
        return trade != null ? ResponseEntity.ok(trade) : ResponseEntity.notFound().build();
    }

    // Update an existing trade event
    @PutMapping("/update/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable String id, @RequestBody Trade trade) {
        trade.setId(id);
        Trade updatedTrade = tradeService.saveTrade(trade);
        return ResponseEntity.ok(updatedTrade);
    }

    // Remove a trade from the system
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable String id) {
        tradeService.deleteTrade(id);
        return ResponseEntity.noContent().build();
    }
}
