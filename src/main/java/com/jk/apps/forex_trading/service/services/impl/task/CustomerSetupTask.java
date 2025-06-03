package com.jk.apps.forex_trading.service.services.impl.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.apps.forex_trading.service.dto.CustomersJsonWrapper;
import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.entity.Customer;
import com.jk.apps.forex_trading.service.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerSetupTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSetupTask.class);

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public CustomerSetupTask(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.objectMapper = new ObjectMapper();
    }

    public void createCustomers(DataSetupCtx ctx, String customerType) throws IOException {
        if (!ctx.getCustomerIds().isEmpty()) return;

        String fileName = "data/customers_corporates.json";
        if("Corporates".equals(customerType)) {
            fileName = "data/customers_corporates.json";
        } else {
            fileName = "data/customers_retail.json";
        }

        ClassPathResource resource = new ClassPathResource("data/customers_corporates.json");
        CustomersJsonWrapper customersWrapper = objectMapper.readValue(resource.getInputStream(), CustomersJsonWrapper.class);
        List<Customer> customers = customersWrapper.getCustomers();

        // Filter out customers whose IDs already exist in the database
        List<Customer> newCustomers = customers.stream()
                .filter(customer -> !customerRepository.existsById(customer.getId()))
                .collect(Collectors.toList());

        if (!newCustomers.isEmpty()) {
            customerRepository.saveAll(newCustomers);
            LOGGER.info("Saved " + newCustomers.size() + " new customers.");
        } else {
            LOGGER.info("No new customers to save.");
        }

        customerRepository.saveAll(customers);
    }

}
