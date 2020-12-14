package com.yohoyes.machine;

import com.yohoyes.beverages.Drinks;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 货架
 * 每一个货架都有CAPACITY个放饮料的位置
 * @author yohoyes
 */
public class Shelf {
    public static final int CAPACITY = 10;
    private final Queue<Drinks> shelf = new LinkedList<>();

    /**
     * 获取货架中现有的饮料数
     */
    public int getDrinksNumber() {
        return shelf.size();
    }

    /**
     * 查看货架是不是满的
     */
    public boolean isFull() {
        return shelf.size() == CAPACITY;
    }

    public boolean isEmpty() {
        return shelf.size() == 0;
    }

    /**
     * 填充货架
     * @param drink 填充的饮料
     */
    public void add(Drinks drink) {
        if(shelf.size() >= CAPACITY) {
            throw new RuntimeException("货架已满");
        }
        shelf.add(drink);
    }

    /**
     * 取出货架中的第一件饮料
     */
    public Drinks out() {
       if(shelf.size() <= 0) {
           throw new RuntimeException("货架是空的");
       }
       return shelf.poll();
    }

    /**
     * 获取货架中第一件饮料的名字
     * @return 名字
     */
    public String getFirstDrinkName(){
        if(shelf.size() <= 0) {
            return "";
        }
        return shelf.peek().getName();
    }

    /**
     * 获取货架中第一件饮料的价格
     * @return 价格
     */
    public double getFirstDrinkPrice(){
        if(shelf.size() <= 0) {
            return 0;
        }
        return shelf.peek().getPrice();
    }

    public Drinks peek() {
        return shelf.peek();
    }
}
