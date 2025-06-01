package com.jk.apps.forex_trading.service.repository;

import com.jk.apps.forex_trading.service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // Custom queries if needed
}