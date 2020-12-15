package com.yohoyes.beverages.impl;

import com.yohoyes.beverages.Drinks;

/**
 * 可口可乐
 * @author yohoyes
 */
public class Coco extends Drinks {

    public Coco() {
        super("Coco",3);
    }

    @Override
    public void ad() {
        System.out.println("可口可乐，冰凉一夏！");
    }
}
