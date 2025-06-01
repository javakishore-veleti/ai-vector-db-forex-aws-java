package com.jk.apps.forex_trading.service.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

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
}
