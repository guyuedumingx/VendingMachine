package com.yohoyes.machine;

import com.yohoyes.beverages.Drinks;
import com.yohoyes.exception.EmptyShelfException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 货架对象
 * 每一个货架都有CAPACITY个放饮料的位置
 * 每一个货架中有很多瓶饮料，但饮料机的货架中我们只能操作第一瓶饮料
 *
 * 学习目标： 队列（如果没学过队列，你能用其他结构来实现同样的功能吗，比如说数组）
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

    /**
     * 查看货架是不是空的
     */
    public boolean isEmpty() {
        return shelf.size() == 0;
    }

    /**
     * 根据传入的饮料填充货架
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

    /**
     * 获取货架中第一瓶饮料
     */
    public Drinks peek() throws EmptyShelfException {
        Drinks peek = shelf.peek();
        if(peek == null) {
            throw new EmptyShelfException();
        }
        return peek;
    }
}
