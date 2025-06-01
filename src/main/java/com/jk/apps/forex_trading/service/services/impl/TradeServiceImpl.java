package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.entity.Trade;
import com.jk.apps.forex_trading.service.repository.TradeRepository;
import com.jk.apps.forex_trading.service.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public Trade getTradeById(String tradeId) {
        return tradeRepository.findById(tradeId).orElse(null);
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade saveTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public void deleteTrade(String tradeId) {
        tradeRepository.deleteById(tradeId);
    }
}
