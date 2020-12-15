package com.yohoyes.beverages.impl;

import com.yohoyes.beverages.Drinks;

/**
 * 啤酒
 * @author yohoyes
 */
public class Bear extends Drinks {

    public Bear() {
        super("Bear",5);
        this.setCapacity(250);
    }

    @Override
    public void ad() {
        System.out.printf("我有故事，你有酒吗？");
    }
}
