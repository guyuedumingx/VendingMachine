package com.yohoyes.pojo;


/**
 * 普通用户
 * 享受98折购买优惠
 * 喜欢Coco
 *
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
