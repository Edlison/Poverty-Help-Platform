package com.edlison.marketing.result;

import com.alibaba.fastjson.JSONObject;

public enum SystemResult {
    LOGIN_WX_SUCCESS(100, "login success"),
    LOGIN_WX_FAILED(101, "login failed"),
    LOGIN_SESSION_SUCCESS(1000, "session check success"),
    LOGIN_SESSION_MISSING_PARAM(1001, "login missing param"),
    LOGIN_SESSION_REJECTED(1002, "session rejected"),
    USER_GET_INFO_SUCCESS(1010, "user get info success"),
    USER_GET_INFO_FAILED(1011, "user get info fail"),
    GOODS_DETAIL_SUCCESS(200, "get goods detail success"),
    GOODS_DETAIL_FAILED(201, "get goods detail fail"),
    GOODS_LIST_SUCCESS(200, "get goods list success"),
    GOODS_LIST_FAILED(201, "get goods list fail"),
    GOODS_SEARCH_SUCCESS(300, "search success"),
    GOODS_SEARCH_FAILED(301, "search fail"),
    ORDER_SUBMIT_SUCCESS(400, "order submit success"),
    ORDER_BALANCE_INSUFFICIENT(401, "be short of funds"),
    ORDER_INSERT_DB_ERROR(402, "order insert into db error"),
    ORDER_GET_INFO_SUCCESS(500, "order get info success"),
    ORDER_GET_INFO_FAILED(501, "order get info fail"),
    INDEX_SWIPER_SUCCESS(600, "get swiper success"),
    INDEX_SWIPER_FAILED(601, "get swiper failed"),
    INDEX_GOODS_SUCCESS(700, "get index goods success"),
    INDEX_GOODS_FAILED(700, "get index goods failed"),
    PAYMENT_SUCCESS(800, "payment success"),
    PAYMENT_FAILED(801, "payment failed"),
    PLACE_ORDER_SUCCESS(810, "place order success"),
    PLACE_ORDER_FAILED(811, "place order failed"),
    QUERY_ORDER_SUCCESS(820, "query order success"),
    QUERY_ORDER_FAILED(821, "query order failed"),
    POST_XML_SUCCESS(830, "post xml success"),
    POST_XML_FAILED(831, "post xml failed")
    ;

    private Integer status;
    private String msg;
    private JSONObject data;

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

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
