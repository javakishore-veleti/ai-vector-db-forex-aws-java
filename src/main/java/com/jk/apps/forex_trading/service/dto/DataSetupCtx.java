package com.jk.apps.forex_trading.service.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
public class DataSetupCtx {

    private List<String> customerIds;
    private List<String> traderIds;
    private List<String> traderBookIds;
    private List<String> tradeIds;

    public DataSetupCtx() {
    }

    public DataSetupCtx(List<String> customerIds, List<String> traderIds, List<String> traderBookIds, List<String> tradeIds) {
        this.customerIds = customerIds;
        this.traderIds = traderIds;
        this.traderBookIds = traderBookIds;
        this.tradeIds = tradeIds;
    }

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public List<String> getTraderIds() {
        return traderIds;
    }

    public void setTraderIds(List<String> traderIds) {
        this.traderIds = traderIds;
    }

    public List<String> getTraderBookIds() {
        return traderBookIds;
    }

    public void setTraderBookIds(List<String> traderBookIds) {
        this.traderBookIds = traderBookIds;
    }

    public List<String> getTradeIds() {
        return tradeIds;
    }

    public void setTradeIds(List<String> tradeIds) {
        this.tradeIds = tradeIds;
    }
}

