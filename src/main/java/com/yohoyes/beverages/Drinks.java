package com.yohoyes.beverages;

/**
 * 饮料的实现类
 *
 * 学习目标： 抽象类 继承
 * @author yohoyes
 */
public abstract class Drinks implements Drinkable {
    protected double price;
    protected int capacity = 300;
    protected String unit = "ml";
    protected String name;

    public Drinks(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getCapacity() {
        return capacity+getUnit();
    }

    public String getUnit() {
        return unit;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

