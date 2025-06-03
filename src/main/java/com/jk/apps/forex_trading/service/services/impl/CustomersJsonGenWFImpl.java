package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.dto.DataGenDesignDTO;
import com.jk.apps.forex_trading.service.services.CustomersJsonGenWF;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CustomersJsonGenWFImpl implements CustomersJsonGenWF {

    private static final String OUTPUT_DIRECTORY = "src/main/resources/data/";

    @Override
    public String generateCustomersJson(String customerType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DataGenDesignDTO designData = objectMapper.readValue(new File("src/main/resources/data_gen_design.json"), DataGenDesignDTO.class);

        Map<String, Object> customerData = new HashMap<>();
        if ("Corporate".equalsIgnoreCase(customerType)) {
            customerData.put("customers", generateCorporateCustomers(designData));
        } else if ("Retail".equalsIgnoreCase(customerType)) {
            customerData.put("customers", generateRetailCustomers(designData));
        } else {
            throw new IllegalArgumentException("Invalid customer type: " + customerType);
        }

        // Generate timestamped filename
        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
        String filename = OUTPUT_DIRECTORY + customerType.toLowerCase() + "_customers_" + timestamp + ".json";

        // Write JSON to file
        objectMapper.writeValue(new File(filename), customerData);

        return filename;
    }


    private List<Map<String, String>> generateCorporateCustomers(DataGenDesignDTO designData) {
        List<Map<String, String>> corporateCustomers = new ArrayList<>();
        List<String> domainList = Arrays.asList(".com", ".au", ".in", ".gov", ".info", ".help");

        for (String company : designData.getCustomersList()) {
            Map<String, String> ceoMapping = designData.getCustomersCeosList().get(company);

            for (String country : designData.getCompaniesCountriesList().get(company)) {
                Map<String, String> customerEntry = new HashMap<>();
                String ceoName = ceoMapping.getOrDefault(country, "Unknown CEO");

                String[] ceoParts = ceoName.split(" ");
                String emailDomain = domainList.get(new Random().nextInt(domainList.size()));

                customerEntry.put("customer_id", generateHashKey(company + country));
                customerEntry.put("first_name", company + " " + country);
                customerEntry.put("last_name", ceoName);
                customerEntry.put("email", ceoParts[0].toLowerCase() + "." + ceoParts[1].toLowerCase() + emailDomain);
                customerEntry.put("customer_type", "Corporate");

                corporateCustomers.add(customerEntry);
            }
        }

        return corporateCustomers;
    }

    private List<Map<String, String>> generateRetailCustomers(DataGenDesignDTO designData) {
        List<Map<String, String>> retailCustomers = new ArrayList<>();

        // Placeholder data for retail customers (to be expanded later)
        List<String> sampleRetailNames = Arrays.asList("Emily Johnson", "Raj Patel", "Oliver Brown", "Yuki Takahashi", "Chen Wang");

        for (String retailName : sampleRetailNames) {
            Map<String, String> customerEntry = new HashMap<>();
            String[] nameParts = retailName.split(" ");

            customerEntry.put("customer_id", generateHashKey(retailName));
            customerEntry.put("first_name", nameParts[0]);
            customerEntry.put("last_name", nameParts[1]);
            customerEntry.put("email", nameParts[0].toLowerCase() + "." + nameParts[1].toLowerCase() + "@random.com");
            customerEntry.put("customer_type", "Retail");

            retailCustomers.add(customerEntry);
        }

        return retailCustomers;
    }


    private String generateHashKey(String input) {
        return UUID.nameUUIDFromBytes(input.getBytes()).toString();
    }
}
