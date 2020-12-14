package com.yohoyes.beverages;

/**
 * 饮料的公有父类
 * @author yohoyes
 */
public interface Drinkable {

    /**
     * 喝
     */
    public void drinks();

    /**
     * 获取饮料的价格
     */
    public int getPrice();

}
