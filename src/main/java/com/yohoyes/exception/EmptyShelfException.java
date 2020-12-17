package com.yohoyes.exception;

public class EmptyShelfException extends Exception{
    public EmptyShelfException() {
        super("该货架是空的,请先通知老板填充货架");
    }
}
