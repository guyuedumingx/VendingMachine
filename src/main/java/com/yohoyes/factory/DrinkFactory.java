package com.yohoyes.factory;

import com.yohoyes.beverages.Drinks;
import com.yohoyes.beverages.impl.Bear;
import com.yohoyes.beverages.impl.Coco;
import com.yohoyes.beverages.impl.Pepsi;

/**
 * 饮料工厂
 *
 * 学习目标： 工厂类是干嘛用的 没有行不行 有的话有什么好处
 * @author yohoyes
 */
public class DrinkFactory {

    public static Drinks build(String name) {
        if("Coco".equals(name)) {
            return new Coco();
        }else if("Bear".equals(name)) {
            return new Bear();
        }else if("Pepsi".equals(name)) {
            return new Pepsi();
        }
        return null;
    }

    public static Drinks buildByRandom() {
        int ram = (int)(Math.random() * 3);
        switch (ram) {
            case 0:
                return new Coco();
            case 1:
                return new Bear();
            case 2:
                return new Pepsi();
        }
        return null;
    }
}
