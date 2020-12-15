package com.yohoyes.pojo;


/**
 * 会员用户
 * 默认喜欢Pepsi
 * 享受6折优惠
 * @author Florence
 */
public class AdvancedConsumer extends User {
    public AdvancedConsumer(String name) {
        super(name, "advanced");
        preferDrinks = "Pepsi";
    }

    @Override
    public String prefer() {
        return preferDrinks;
    }

    @Override
    public double getDiscount() {
        return 0.6;
    }
}
