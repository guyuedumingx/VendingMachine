package com.yohoyes.machine;
import com.yohoyes.beverages.Drinks;
import com.yohoyes.exception.NoEnoughMoneyException;
import com.yohoyes.exception.NoSuchDrinksException;
import com.yohoyes.exception.NoSuchShelfException;
import com.yohoyes.factory.DrinkFactory;
import com.yohoyes.pojo.User;

/**
 * 售卖机对象，每一个售卖机对象都有CAPACITY个货架(Shelf)对象，货架里面包含有多个空位，
 * 每个空位可以放置一瓶饮料对象
 *
 * 学习目标： final是什么意思  构造函数  抛异常 异常是什么 \t是什么意思
 * @author yohoyes
 */
public class VendingMachine {
    public static final int CAPACITY = 16;
    private Shelf[] shelves = new Shelf[CAPACITY];

    private Shelf curShelf;
    private User user;

    /**
     * 在新建售卖机时就新建了多个货架
     */
    public VendingMachine() {
        for(int i=0; i<CAPACITY; i++) {
            shelves[i] = new Shelf();
        }
    }

    /**
     * 卖饮料
     * @param user 谁要买饮料，就把谁传进来
     * @return 返回购买成功的饮料
     * @throws NoSuchDrinksException 如果这个人想买的饮料在饮料机的第一行没有，就抛出该异常
     * @throws NoEnoughMoneyException 如果这个人带的钱不够，就抛出该异常
     */
    public Drinks sell(User user) throws NoSuchDrinksException, NoEnoughMoneyException {
        String name = user.getPreferDrinks();
        for(int i=0; i<CAPACITY; i++) {
           curShelf = shelves[i];
           String drinksName = curShelf.getFirstDrinkName();
           if(drinksName.equals(name)){
               try {
                   return sell(user, i);
               }catch (NoSuchShelfException e)  {
                   System.out.println(e.getMessage());
               }
           }
        }
        throw new NoSuchDrinksException();
    }

    public Drinks sell(User user, int shelfNumber) throws NoEnoughMoneyException, NoSuchShelfException {
        if(shelfNumber>=CAPACITY) {
            throw new NoSuchShelfException();
        }
        this.user = user;
        curShelf = shelves[shelfNumber];
        return sell();
    }

    private Drinks sell() throws NoEnoughMoneyException{
        Drinks drinks = curShelf.peek();
        double money = user.getMoney();
        double discount = user.getDiscount();
        double price = drinks.getPrice();
        String name = drinks.getName();

        if(drinks.getPrice() > money*discount) {
            throw new NoEnoughMoneyException();
        }else {
            money -= price * discount;
            System.out.println("恭喜你成功购买了："+name +
                    " 此次折扣为："+(discount*10)+"折 "+
                    " 原价："+ price +
                    " 折后价："+ price *discount);
            user.setMoney(money);
            return curShelf.out();
        }
    }



    /**
     * 填充货架,可以自动把货架用随机饮料填满
     */
    public void fillShelf() {
        for(Shelf shelf : shelves) {
            while (!shelf.isFull()) {
                shelf.add(DrinkFactory.buildByRandom());
            }
        }
    }

    /**
     * 显示售卖机
     */
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
    }
}
