package com.jk.apps.forex_trading.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trader_book")
public class TraderBook {

    @Id
    @Column(name = "trader_book_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "trader_id")
    private Trader trader;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_type")
    private String bookType; // "Risk", "Hedge", "Liquidity"
}
