package com.edlison.marketing.DTO;

import java.math.BigDecimal;

/**
 * OrderViewDTO
 *
 * @Author Edlison
 * @Date 12/24/20 23:08
 */
public class OrderViewDTO {
    private Long order_id;
    private String openid_fk;
    private String express_name;
    private String express_address;
    private BigDecimal order_payment;
    private BigDecimal order_shipping_money;
    private Long order_point;
    private Long order_status;
    private Long order_create_time;
    private Long order_detail_id;
    private Long order_id_fk;
    private Long product_id;
    private String product_name;
    private BigDecimal product_price;
    private Long product_num;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOpenid_fk() {
        return openid_fk;
    }

    public void setOpenid_fk(String openid_fk) {
        this.openid_fk = openid_fk;
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

    public Long getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Long order_status) {
        this.order_status = order_status;
    }

    public Long getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Long order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Long getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Long order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public Long getOrder_id_fk() {
        return order_id_fk;
    }

    public void setOrder_id_fk(Long order_id_fk) {
        this.order_id_fk = order_id_fk;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_price;
    }

    public Long getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Long product_num) {
        this.product_num = product_num;
    }
}
