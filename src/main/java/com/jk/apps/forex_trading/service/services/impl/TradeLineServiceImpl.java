package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.entity.TradeLine;
import com.jk.apps.forex_trading.service.repository.TradeLineRepository;
import com.jk.apps.forex_trading.service.services.TradeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeLineServiceImpl implements TradeLineService {

    @Autowired
    private TradeLineRepository tradeLineRepository;

    @Override
    public TradeLine getTradeLineById(String tradeLineId) {
        return tradeLineRepository.findById(tradeLineId).orElse(null);
    }

    @Override
    public List<TradeLine> getAllTradeLines() {
        return tradeLineRepository.findAll();
    }

    @Override
    public TradeLine saveTradeLine(TradeLine tradeLine) {
        return tradeLineRepository.save(tradeLine);
    }

    @Override
    public void deleteTradeLine(String tradeLineId) {
        tradeLineRepository.deleteById(tradeLineId);
    }
}
