package com.jk.apps.forex_trading.service.services;

import com.jk.apps.forex_trading.service.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(String customerId);
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer trader);
    void deleteCustomer(String customerId);
}