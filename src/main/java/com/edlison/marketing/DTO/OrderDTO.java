package com.edlison.marketing.DTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    private Long order_id;
    private String openid;
    private String token;
    private String express_name;
    private String express_address;
    private BigDecimal order_payment;
    private BigDecimal order_shipping_money;
    private Long order_point;
    private List<OrderDetailDTO> order_detail;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpress_name() {
        return express_name;
    }

    public void setExpress_name(String express_name) {
        this.express_name = express_name;
    }

    public String getExpress_address() {
        return express_address;
    }

    public void setExpress_address(String express_address) {
        this.express_address = express_address;
    }

    public BigDecimal getOrder_payment() {
        return order_payment;
    }

    public void setOrder_payment(BigDecimal order_payment) {
        this.order_payment = order_payment;
    }

    public BigDecimal getOrder_shipping_money() {
        return order_shipping_money;
    }

    public void setOrder_shipping_money(BigDecimal order_shipping_money) {
        this.order_shipping_money = order_shipping_money;
    }

    public Long getOrder_point() {
        return order_point;
    }

    public void setOrder_point(Long order_point) {
        this.order_point = order_point;
    }

    public List<OrderDetailDTO> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetailDTO> order_detail) {
        this.order_detail = order_detail;
    }
}
