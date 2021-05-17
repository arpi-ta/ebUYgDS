package com.buy.eBuyGds.model;

import lombok.Data;

@Data
public class Bill {

    private Integer price;
    private Integer days;

    public Bill() {
    }

    public Bill(Integer price, Integer days) {
        this.price = price;
        this.days = days;
    }
}
