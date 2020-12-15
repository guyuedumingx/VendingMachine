package com.yohoyes.beverages.impl;

import com.yohoyes.beverages.Drinks;

/**
 * 百事可乐
 *
 * 学习目标： 多态
 * @author yohoyes
 */
public class Pepsi extends Drinks {

    public Pepsi() {
        super("Pepsi",3.5);
        this.setCapacity(200);
    }

    @Override
    public void ad() {
        System.out.println("百事可乐，打败可口！");
    }
}
