package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.entity.TraderBook;
import com.jk.apps.forex_trading.service.repository.TraderBookRepository;
import com.jk.apps.forex_trading.service.services.TraderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderBookServiceImpl implements TraderBookService {

    @Autowired
    private TraderBookRepository traderBookRepository;

    @Override
    public TraderBook getTraderBookById(String traderBookId) {
        return traderBookRepository.findById(traderBookId).orElse(null);
    }

    @Override
    public List<TraderBook> getAllTraderBooks() {
        return traderBookRepository.findAll();
    }

    @Override
    public TraderBook saveTraderBook(TraderBook traderBook) {
        return traderBookRepository.save(traderBook);
    }

    @Override
    public void deleteTraderBook(String traderBookId) {
        traderBookRepository.deleteById(traderBookId);
    }
}
