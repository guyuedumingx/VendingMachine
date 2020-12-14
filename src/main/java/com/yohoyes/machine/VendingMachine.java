package com.yohoyes.machine;
import com.yohoyes.beverages.Drinks;
import com.yohoyes.exception.NoEnoughMoneyException;
import com.yohoyes.exception.NoSuchDrinksException;
import com.yohoyes.factory.DrinkFactory;

/**
 * 售卖机
 * @author yohoyes
 */
public class VendingMachine {
    public static final int CAPACITY = 16;
    Shelf[] shelves = new Shelf[CAPACITY];

    public VendingMachine() {
        for(int i=0; i<CAPACITY; i++) {
            shelves[i] = new Shelf();
        }
    }

    /**
     *现有金钱
     */
    private int money = 0;

    public Drinks buy(String name) throws NoSuchDrinksException, NoEnoughMoneyException {
        Drinks drink = null;
        for (Shelf shelf : shelves) {
            String firstDrinkName = shelf.getFirstDrinkName();
            if (firstDrinkName.equals(name)) {
                if (shelf.getFirstDrinkPrice() > money) {
                    throw new NoEnoughMoneyException();
                }
                drink = shelf.out();
                money -= drink.getPrice();
                return drink;
            }
        }
        throw new NoSuchDrinksException();
    }

    /**
     * 充值
     */
    public void topUp(int money) {
        if(money <= 0) {
            System.out.println("充值失败");
        }else {
            this.money += money;
            System.out.println("充值成功");
        }
    }

    /**
     * 填充货架
     */
    public void fillShelf() {
        for(Shelf shelf : shelves) {
            while (!shelf.isFull()) {
                shelf.add(DrinkFactory.buildByRandom());
            }
        }
    }

    public void show() {
        System.out.print("编号：\t");
        for(int i=1; i<=CAPACITY; i++) {
            System.out.print(i+"\t\t");
        }
        System.out.println();
        System.out.print("名称：\t");
        for(Shelf shelf : shelves) {
            System.out.print(shelf.getFirstDrinkName()+"\t");
        }
        System.out.println();
        System.out.print("价格：\t");
        for(Shelf shelf : shelves) {
            System.out.print(shelf.getFirstDrinkPrice()+"\t\t");
        }
        System.out.println();
        System.out.print("容量：\t");
        for(Shelf shelf : shelves) {
            System.out.print(shelf.peek().getCapacity()+"\t");
        }
        System.out.println();
        System.out.print("数量：\t");
        for(Shelf shelf : shelves) {
            System.out.print(shelf.getDrinksNumber() + "\t\t");
        }
        System.out.println();
        System.out.println("当前余额为：\t" + money + "￥");
    }
}
