package com.jk.apps.forex_trading.service.repository;

import com.jk.apps.forex_trading.service.entity.TradeLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeLineRepository extends JpaRepository<TradeLine, String> {
    // Custom queries if needed
}