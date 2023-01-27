package com.eil.imsbackend.exception;

public enum ErrorCodes {
    //still have to be completed
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CUSTOMER_NOT_FOUND(3000),
    CUSTOMER_ORDER_NOT_FOUND(4000),
    PROVIDER_ORDER_NOT_FOUND(5000),
    COMPANY_NOT_FOUND(6000),
    PROVIDER_NOT_FOUND(7000),
    CUSTOMER_ORDER_LINE_NOT_FOUND(8000),
    PROVIDER_ORDER_LINE_NOT_FOUND(9000),
    PURCHASE_LINE_NOT_FOUND(10000),
    STK_MVT_NOT_FOUND(11000),
    USER_NOT_FOUND(11000),
    PURCHASE_NOT_FOUND(11000),
    CATEGORY_NOT_VALID(2001);

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
