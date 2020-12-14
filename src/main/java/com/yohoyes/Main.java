package com.yohoyes;

import com.yohoyes.beverages.Drinks;
import com.yohoyes.exception.NoSuchDrinksException;
import com.yohoyes.machine.VendingMachine;

import java.util.Scanner;

/**
 *程序入口
 * @author yohoyes
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    static VendingMachine machine = new VendingMachine();

    public static void main(String[] args) {
        machine.fillShelf();
        machine.show();
        int i = showOpera();
        while (i != 5) {
            opera(i);
            i = showOpera();
        }
    }

    public static int showOpera() {
        System.out.println();
        System.out.println("[1] 显示饮料机");
        System.out.println("[2] 充值");
        System.out.println("[3] 购买");
        System.out.println("[4] 通知老板填充货架");
        System.out.println("[5] 退出");
        System.out.print("请输入命令： ");
        return in.nextInt();
    }

    public static void opera(int i) {
        if(i == 1) {
            machine.show();
        }else if(i == 2) {
            System.out.print("充值金额： ");
            machine.topUp(in.nextInt());
        }else if(i == 3) {
            try {
                System.out.print("你要购买的饮料名字是： ");
                Drinks drink = machine.buy(in.next());
                drink.drinks();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else if(i == 4) {
            machine.fillShelf();
            System.out.println("货架填充完成");
        }else {
            System.out.println("输入错误");
        }
    }
}
