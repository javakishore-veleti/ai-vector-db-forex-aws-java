package com.jk.apps.forex_trading.service.repository;

import com.jk.apps.forex_trading.service.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {
    // Custom queries if needed
}