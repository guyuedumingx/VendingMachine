package com.yohoyes.factory;

import com.yohoyes.pojo.AdvancedConsumer;
import com.yohoyes.pojo.CommonConsumer;
import com.yohoyes.pojo.User;

/**
 * 用户工厂类
 *
 * 学习目标： 工厂类是干嘛用的 没有行不行 有的话有什么好处
 * @author yohoyes
 */
public class UserFactory {

    /**
     * 生成用户
     */
    public static User buildUser(String name,String identify) {
        if("advanced".equals(identify)) {
            return new AdvancedConsumer(name);
        } else if("common".equals(identify)) {
            return new CommonConsumer(name);
        }
        return null;
    }
}
