package com.jk.apps.forex_trading.service.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "trade_line")
public class TradeLine extends BaseEntity {

    @Id
    @Column(name = "trade_line_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "trade_id", nullable = false)
    private Trade trade;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "from_amount")
    private Double fromAmount;

    @Column(name = "to_amount")
    private Double toAmount;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "trade_discount_total")
    private Double tradeDiscountTotal;

    @Column(name = "trade_discount_percent")
    private Double tradeDiscountPercent;

    @ManyToOne
    @JoinColumn(name = "trader_book_id")
    private TraderBook traderBook;

    @ManyToOne
    @JoinColumn(name = "trader_id")
    private Trader trader;

    @Column(name = "original_trade_req")
    private Boolean isOriginalTradeReq;

    @Column(name = "trade_line_status")
    private String tradeLineStatus; // "Pending", "Processed", "Completed"

    @Column(name = "trade_line_type")
    private String tradeLineType; // "Buy", "Sell", "Swap"

}
