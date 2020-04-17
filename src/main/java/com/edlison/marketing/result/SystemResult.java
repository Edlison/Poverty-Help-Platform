package com.edlison.marketing.result;

public enum SystemResult {
    LOGIN_SUCCESS(100, "login success"),
    LOGIN_PASSWORD_REJECTED(101, "password is rejected"),
    GOODS_DETAIL_SUCCESS(200, "get goods detail success"),
    GOODS_DETAIL_FAILED(201, "get goods detail fail"),
    GOODS_LIST_SUCCESS(200, "get goods list success"),
    GOODS_LIST_FAILED(202, "get goods list fail"),
    GOODS_SEARCH_SUCCESS(300, "search success"),
    GOODS_SEARCH_FAILED(301, "search fail"),
    ;

    private Integer status;
    private String msg;

    SystemResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
