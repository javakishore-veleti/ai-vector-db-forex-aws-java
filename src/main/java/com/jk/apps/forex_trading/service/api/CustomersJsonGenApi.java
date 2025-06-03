package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.services.CustomersJsonGenWF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers-json")
public class CustomersJsonGenApi {

    private final CustomersJsonGenWF customersJsonGenWF;

    @Autowired
    public CustomersJsonGenApi(CustomersJsonGenWF customersJsonGenWF) {
        this.customersJsonGenWF = customersJsonGenWF;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateCustomersJson(@RequestParam String customerType) {
        try {
            String timestampedFilename = customersJsonGenWF.generateCustomersJson(customerType);
            return ResponseEntity.ok("JSON generated successfully: " + timestampedFilename);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating JSON: " + e.getMessage());
        }
    }
}
