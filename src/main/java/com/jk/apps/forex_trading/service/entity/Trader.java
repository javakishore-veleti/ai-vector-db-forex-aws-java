package com.jk.apps.forex_trading.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trader")
public class Trader extends BaseEntity {

    @Id
    @Column(name = "trader_id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "trader_type")
    private String traderType; // "Individual" or "Institutional"

    @Column(name = "trader_cntry")
    private String traderCountry;

    @Column(name = "trader_desk")
    private String traderDesk;


}
