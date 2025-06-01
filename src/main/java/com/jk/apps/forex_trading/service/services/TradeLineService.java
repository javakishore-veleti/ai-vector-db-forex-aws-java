package com.jk.apps.forex_trading.service.services;

import com.jk.apps.forex_trading.service.entity.TradeLine;

import java.util.List;

public interface TradeLineService {
    TradeLine getTradeLineById(String tradeLineId);
    List<TradeLine> getAllTradeLines();
    TradeLine saveTradeLine(TradeLine tradeLine);
    void deleteTradeLine(String tradeLineId);
}