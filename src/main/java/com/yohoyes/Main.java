package com.yohoyes;

import com.yohoyes.beverages.Drinks;
import com.yohoyes.factory.UserFactory;
import com.yohoyes.machine.VendingMachine;
import com.yohoyes.pojo.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *程序入口
 * 默认提供两个账户
 * 会员账户： 允晴
 * 普通账户： 允晴2号
 *
 * 学习目标：static是什么 Scanner怎么用 Map是什么 静态代码块
 * @author yohoyes
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    /**
     * 饮料售货机对象
     */
    static VendingMachine machine = new VendingMachine();
    /**
     * 程序的用户列表
     */
    static Map<String, User> userMap = new HashMap<>();
    /**
     * 程序当前的操作者
     */
    static User currentUser = null;

    /**
     * 初始化生成用户并把用户添加到用户列表中
     */
    static {
        User advanced = UserFactory.buildUser("允晴","advanced");
        User common = UserFactory.buildUser("允晴2号","common");
        userMap.put(advanced.getName(),advanced);
        userMap.put(common.getName(), common);
    }

    public static void main(String[] args) {
        machine.fillShelf();
        machine.show();
        currentUser = setOperator();
        int i = showOpera();
        //操作符是7则退出
        while (i != 7) {
            opera(i);
            i = showOpera();
        }
    }

    /**
     * 显示操作帮助
     * 等待用户操作
     * 返回用户操作代码
     */
    public static int showOpera() {
        System.out.println();
        System.out.println("[1] 显示饮料机");
        System.out.println("[2] 充值");
        System.out.println("[3] 购买");
        System.out.println("[4] 通知老板填充货架");
        System.out.println("[5] 切换用户");
        System.out.println("[6] 设置用户喜欢的饮料");
        System.out.println("[7] 退出");
        System.out.print("请输入命令： ");
        return in.nextInt();
    }

    /**
     * 执行用户输入的操作
     * @param i 操作码
     */
    public static void opera(int i) {
        if(i == 1) {
            machine.show();
            System.out.println("当前余额为: \t" + currentUser.getMoney() + "￥");
        }else if(i == 2) {
            System.out.print("充值金额： ");
            currentUser.topUp(in.nextInt());
        }else if(i == 3) {
            try {
                Drinks drink = machine.sell(currentUser);
                currentUser.drinks(drink);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else if(i == 4) {
            machine.fillShelf();
            System.out.println("货架填充完成");
        }else if(i == 5){
            currentUser = setOperator();
        }else if(i == 6){
            System.out.print(currentUser.getName()+" 喜欢的饮料是: ");
            currentUser.setPreferDrinks(in.next());
        }else {
            System.out.println("输入错误");

        }
    }

    /**
     * 设置程序的用户帐号
     */
    public static User setOperator() {
        System.out.print("你想要使用的用户名是: ");
        String name = in.next();
        User get = userMap.get(name);
        if(get == null) {
            System.out.println("没有该用户!");
            return currentUser;
        }
        return get;
    }
}
