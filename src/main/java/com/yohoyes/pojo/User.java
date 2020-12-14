package com.yohoyes.pojo;

import com.yohoyes.beverages.Drinks;

import javax.jws.soap.SOAPBinding;

/**
 * @author Florence
 */
public abstract class User {
    String name;
    String identify;
    User(String name,String identify){
        this.name=name;
        this.identify=identify;
    }
    public abstract Drinks buy();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}
