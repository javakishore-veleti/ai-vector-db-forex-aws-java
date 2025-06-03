package com.jk.apps.forex_trading.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@Entity
@Table(name = "trade")
public class Trade extends BaseEntity {

    @Id
    @Column(name = "trade_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "trader_id")
    private Trader trader;

    @ManyToOne
    @JoinColumn(name = "trader_book_id")
    private TraderBook traderBook;

    @Column(name = "trade_ctg")
    private String tradeCategory; // "SPOT", "FORWARD", "WINDOW_FORWARD"

    @Column(name = "trade_req_dt")
    private Timestamp tradeReqDate;

    @Column(name = "trade_processed_dt")
    private Timestamp tradeProcessedDate;

    @Column(name = "trade_completed_dt")
    private Timestamp tradeCompletedDt;

    @Column(name = "trade_origin_cntry")
    private String tradeOriginCountry;

    @Column(name = "trade_origin_desk")
    private String tradeOriginDesk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public TraderBook getTraderBook() {
        return traderBook;
    }

    public void setTraderBook(TraderBook traderBook) {
        this.traderBook = traderBook;
    }

    public String getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(String tradeCategory) {
        this.tradeCategory = tradeCategory;
    }

    public Timestamp getTradeReqDate() {
        return tradeReqDate;
    }

    public void setTradeReqDate(Timestamp tradeReqDate) {
        this.tradeReqDate = tradeReqDate;
    }

    public Timestamp getTradeProcessedDate() {
        return tradeProcessedDate;
    }

    public void setTradeProcessedDate(Timestamp tradeProcessedDate) {
        this.tradeProcessedDate = tradeProcessedDate;
    }

    public Timestamp getTradeCompletedDt() {
        return tradeCompletedDt;
    }

    public void setTradeCompletedDt(Timestamp tradeCompletedDt) {
        this.tradeCompletedDt = tradeCompletedDt;
    }

    public String getTradeOriginCountry() {
        return tradeOriginCountry;
    }

    public void setTradeOriginCountry(String tradeOriginCountry) {
        this.tradeOriginCountry = tradeOriginCountry;
    }

    public String getTradeOriginDesk() {
        return tradeOriginDesk;
    }

    public void setTradeOriginDesk(String tradeOriginDesk) {
        this.tradeOriginDesk = tradeOriginDesk;
    }
}
