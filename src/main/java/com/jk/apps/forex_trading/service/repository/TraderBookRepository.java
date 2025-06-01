package com.jk.apps.forex_trading.service.repository;

import com.jk.apps.forex_trading.service.entity.TraderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderBookRepository extends JpaRepository<TraderBook, String> {
    // Custom queries if needed
}