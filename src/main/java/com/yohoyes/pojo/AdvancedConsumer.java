package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinks;

/**
 * @author Florence
 */
public class AdvancedConsumer extends User {
    public AdvancedConsumer(String name) {
        super(name, "advanced");
    }

    @Override
    public String prefer() {
        return "Pepsi";
    }

    @Override
    public double getDiscount() {
        return 0.6;
    }
}
