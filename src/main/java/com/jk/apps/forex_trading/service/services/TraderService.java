package com.jk.apps.forex_trading.service.services;

import com.jk.apps.forex_trading.service.entity.Trader;

import java.util.List;

public interface TraderService {
    Trader getTraderById(String traderId);
    List<Trader> getAllTraders();
    Trader saveTrader(Trader trader);
    void deleteTrader(String traderId);
}