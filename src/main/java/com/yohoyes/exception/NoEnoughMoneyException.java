package com.yohoyes.exception;

/**
 * 余额不足异常
 *
 * 学习目标： 自定义异常
 * @author yohoyes
 */
public class NoEnoughMoneyException extends Exception{

    public NoEnoughMoneyException() {
        super("金钱不足");
    }
}
