package com.yohoyes.exception;

/**
 * 没有这种饮料异常
 * @author yohoyes
 */
public class NoSuchDrinksException extends Exception{

    public NoSuchDrinksException() {
        super("没有这种饮料");
    }
}
