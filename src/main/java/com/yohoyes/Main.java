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
 * @author yohoyes
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    static VendingMachine machine = new VendingMachine();

    static Map<String, User> userMap = new HashMap<>();
    static User currentUser = null;

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
        while (i != 6) {
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
        System.out.println("[5] 切换用户");
        System.out.println("[6] 退出");
        System.out.print("请输入命令： ");
        return in.nextInt();
    }

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
                drink.ad();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else if(i == 4) {
            machine.fillShelf();
            System.out.println("货架填充完成");
        }else if(i == 5){
            currentUser = setOperator();
        }else {
            System.out.println("输入错误");

        }
    }

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
