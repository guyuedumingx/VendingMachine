package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinks;

/**
 * @author Florence
 */
public class CommonConsumer extends User {
    CommonConsumer(String name, String identify) {
        super(name, identify);
    }

    @Override
    public Drinks buy() {
        return null;
    }
}
