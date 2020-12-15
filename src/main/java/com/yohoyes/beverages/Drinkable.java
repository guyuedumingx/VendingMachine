package com.yohoyes.beverages;

/**
 * 饮料的公有接口
 *
 * 学习目标： 接口 接口的作用
 * @author yohoyes
 */
public interface Drinkable {

    /**
     * 广告语
     */
    public void ad();

    /**
     * 获取饮料的价格
     * @return price
     */
    public double getPrice();

}
