package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinkable;

/**
 * 用户的公有类
 *
 * 学习目标： 多态 抽象类 修饰符作用域(public protected private default)
 * @author Florence
 */
public abstract class User {
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户身份
     */
    private String identify;
    /**
     * 用户喜欢喝的饮料
     */
    protected String preferDrinks;
    /**
     * 用户拥有的金钱
     */
    private double money = 0;

    public User(String name,String identify){
        this.name=name;
        this.identify=identify;
    }

    /**
     * 这个用户想买什么饮料
     */
    public String getPreferDrinks() {
        return preferDrinks;
    }

    /**
     * 设置用户喜欢的饮料品种
     */
    public void setPreferDrinks(String name) {
        preferDrinks = name;
    }

    /**
     * 获取用户名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名字
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
     * @param money 钱数
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
        }else if(money > 100){
            System.out.println("数额太大，充值失败");
        }else {
            this.money += money;
            System.out.println("充值成功");
        }
    }

    /**
     * 不同的用户有不同的折扣
     * @return 折扣
     */
    public abstract double getDiscount();

    /**
     * 用户可以喝饮料
     * @param drink 饮料对象
     */
    public void drinks(Drinkable drink) {
        System.out.print("广告语：");
        drink.ad();
    }
}
