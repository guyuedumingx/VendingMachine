package com.yohoyes.beverages;

/**
 * 饮料的公有接口
 * @author yohoyes
 */
public interface Drinkable {

    /**
     * 喝
     */
    public void drinks();

    /**
     * 获取饮料的价格
     * @return price
     */
    public double getPrice();

}
