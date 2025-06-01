package com.jk.apps.forex_trading.service.services;

import com.jk.apps.forex_trading.service.entity.Trade;

import java.util.List;

public interface TradeService {
    Trade getTradeById(String tradeId);
    List<Trade> getAllTrades();
    Trade saveTrade(Trade trade);
    void deleteTrade(String tradeId);
}