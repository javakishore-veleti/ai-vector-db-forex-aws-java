package com.jk.apps.forex_trading.service.repository;

import com.jk.apps.forex_trading.service.entity.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends JpaRepository<Trader, String> {
    // Custom queries if needed
}