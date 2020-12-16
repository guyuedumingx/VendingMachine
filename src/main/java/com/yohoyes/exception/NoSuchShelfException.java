package com.yohoyes.exception;

/**
 * 没有该货架异常
 * @author yohoyes
 */
public class NoSuchShelfException extends Exception{

    public NoSuchShelfException() {
        super("没有这个货架");
    }
}
