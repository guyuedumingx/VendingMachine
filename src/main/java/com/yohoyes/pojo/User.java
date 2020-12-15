package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinkable;

/**
 * @author Florence
 */
public abstract class User {
    String name;
    String identify;
    double money = 0;

    public User(String name,String identify){
        this.name=name;
        this.identify=identify;
    }

    public abstract String prefer();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void topUp(double money) {
        this.money += money;
    }

    public abstract double getDiscount();

    public void drinks(Drinkable drink) {
        drink.ad();
    }

}
