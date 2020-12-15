package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinkable;

/**
 * 用户的公有类
 *
 * 学习目标： 多态 抽象类
 * @author Florence
 */
public abstract class User {
    String name;
    String identify;
    String preferDrinks;
    double money = 0;

    public User(String name,String identify){
        this.name=name;
        this.identify=identify;
    }

    /**
     * 这个用户想买什么饮料
     * @return
     */
    public abstract String prefer();

    /**
     * 设置用户喜欢的饮料品种
     * @param name
     */
    public void setPreferDrinks(String name) {
        preferDrinks = name;
    }

    /**
     * 获取用户名字
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名字
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户身份
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * 设置用户身份
     */
    public void setIdentify(String identify) {
        this.identify = identify;
    }

    /**
     * 获取用户带的钱
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置用户的钱数
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 充值
     */
    public void topUp(double money) {
        if(money <= 0) {
            System.out.println("充值失败");
        }else {
            this.money += money;
            System.out.println("充值成功");
        }
    }

    /**
     * 不同的用户有不同的折扣
     * @return
     */
    public abstract double getDiscount();

    /**
     * 用户可以喝饮料
     * @param drink 饮料对象
     */
    public void drinks(Drinkable drink) {
        drink.ad();
    }

}
