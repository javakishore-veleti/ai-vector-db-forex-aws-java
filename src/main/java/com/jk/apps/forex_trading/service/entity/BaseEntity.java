package com.jk.apps.forex_trading.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_dt")
    private Timestamp createdAt;

    @Column(name = "updated_dt")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
}
