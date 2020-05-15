package com.edlison.marketing.DTO;

import java.math.BigDecimal;

public class OrderDetailDTO {
    private Long order_id_fk;
    private Long product_id;
    private String product_name;
    private BigDecimal product_price;
    private Long product_num;
    private String goods_small_logo;

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

    public String getGoods_small_logo() {
        return goods_small_logo;
    }

    public void setGoods_small_logo(String goods_small_logo) {
        this.goods_small_logo = goods_small_logo;
    }
}
