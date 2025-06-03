package com.jk.apps.forex_trading.service.services.impl.task;

import com.github.javafaker.Faker;
import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.entity.Customer;
import com.jk.apps.forex_trading.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Component
public class CustomerSetupTask {

    @Autowired
    private CustomerRepository customerRepository;

    private final Faker faker = new Faker();

    public void createCustomers(DataSetupCtx ctx) {
        if (!ctx.getCustomerIds().isEmpty()) return;

        List<Customer> customers = IntStream.rangeClosed(1, 10).mapToObj(i -> {
            Customer customer = new Customer();
            String id = UUID.randomUUID().toString();
            customer.setId(id);
            customer.setFirstName(faker.name().firstName());
            customer.setLastName(faker.name().lastName());
            customer.setEmail(faker.internet().emailAddress());
            ctx.getCustomerIds().add(id);
            return customer;
        }).toList();

        customerRepository.saveAll(customers);
    }

}
