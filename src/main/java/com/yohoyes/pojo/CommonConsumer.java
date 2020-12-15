package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinks;

/**
 * @author Florence
 */
public class CommonConsumer extends User {
    public CommonConsumer(String name) {
        super(name, "common");
    }

    @Override
    public String prefer() {
        return "Coco";
    }

    @Override
    public double getDiscount() {
        return 0.98;
    }
}
