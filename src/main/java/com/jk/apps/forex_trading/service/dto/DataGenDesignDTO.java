package com.jk.apps.forex_trading.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
@Setter
@Getter
public class DataGenDesignDTO {
    private List<String> customersList;
    private Map<String, Map<String, String>> customersCeosList;
    private Map<String, List<String>> companiesCountriesList;

    public List<String> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<String> customersList) {
        this.customersList = customersList;
    }

    public Map<String, Map<String, String>> getCustomersCeosList() {
        return customersCeosList;
    }

    public void setCustomersCeosList(Map<String, Map<String, String>> customersCeosList) {
        this.customersCeosList = customersCeosList;
    }

    public Map<String, List<String>> getCompaniesCountriesList() {
        return companiesCountriesList;
    }

    public void setCompaniesCountriesList(Map<String, List<String>> companiesCountriesList) {
        this.companiesCountriesList = companiesCountriesList;
    }
}
