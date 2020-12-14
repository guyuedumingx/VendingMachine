package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinks;

/**
 * @author Florence
 */
public class AdvancedConsumer extends User {
    AdvancedConsumer(String name, String identify) {
        super(name, identify);
    }

    @Override
    public Drinks buy() {
        return null;
    }
}
