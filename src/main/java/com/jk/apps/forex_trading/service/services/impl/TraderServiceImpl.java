package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.entity.Trader;
import com.jk.apps.forex_trading.service.repository.TraderRepository;
import com.jk.apps.forex_trading.service.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderServiceImpl implements TraderService  {

    @Autowired
    private TraderRepository traderRepository;

    @Override
    public Trader getTraderById(String traderId) {
        return traderRepository.findById(traderId).orElse(null);
    }

    @Override
    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    @Override
    public Trader saveTrader(Trader trader) {
        return traderRepository.save(trader);
    }

    @Override
    public void deleteTrader(String traderId) {
        traderRepository.deleteById(traderId);
    }
}
