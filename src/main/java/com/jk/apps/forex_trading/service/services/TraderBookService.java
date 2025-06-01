package com.jk.apps.forex_trading.service.services;

import com.jk.apps.forex_trading.service.entity.TraderBook;

import java.util.List;

public interface TraderBookService {
    TraderBook getTraderBookById(String traderBookId);
    List<TraderBook> getAllTraderBooks();
    TraderBook saveTraderBook(TraderBook traderBook);
    void deleteTraderBook(String traderBookId);
}