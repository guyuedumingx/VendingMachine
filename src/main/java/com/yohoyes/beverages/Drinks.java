package com.yohoyes.beverages;

/**
 * 饮料的实现类
 * @author yohoyes
 */
public class Drinks implements Drinkable {
    protected int price;
    protected int capacity;
    protected String unit;
    protected String name;

    public Drinks(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void drinks() {
    }

    @Override
    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
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

class Builder {

    protected Drinks drinks = null;
    protected String unit = 'ml';
    protected int capacity = 300;

    public Builder(String name, int price) {
        drinks.setName(name);
        drinks.setPrice(price);
        drinks.setUnit(unit);
        drinks.setCapacity(capacity);
    }

    public Drinks build() {
        return drinks;
    }

    public void unit(String unit) {
        drinks.setUnit(unit);
    }

    public void capacity(int capacity) {
        drinks.setCapacity(capacity);
    }

}

