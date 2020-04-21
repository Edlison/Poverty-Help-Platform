package com.edlison.marketing.DTO;

import lombok.Data;

@Data
public class GoodsDetailDTO {
    private String _id;
    private Long goods_id;
    private String goods_name;
    private Double goods_price;
    private Double goods_freight;
    private String goods_sold_num;
    private String goods_area;
    private String goods_small_logo;
    private String goods_introduce;
    private String goods_pics;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Double getGoods_freight() {
        return goods_freight;
    }

    public void setGoods_freight(Double goods_freight) {
        this.goods_freight = goods_freight;
    }

    public String getGoods_sold_num() {
        return goods_sold_num;
    }

    public void setGoods_sold_num(String goods_sold_num) {
        this.goods_sold_num = goods_sold_num;
    }

    public String getGoods_area() {
        return goods_area;
    }

    public void setGoods_area(String goods_area) {
        this.goods_area = goods_area;
    }

    public String getGoods_small_logo() {
        return goods_small_logo;
    }

    public void setGoods_small_logo(String goods_small_logo) {
        this.goods_small_logo = goods_small_logo;
    }

    public String getGoods_introduce() {
        return goods_introduce;
    }

    public void setGoods_introduce(String goods_introduce) {
        this.goods_introduce = goods_introduce;
    }

    public String getGoods_pics() {
        return goods_pics;
    }

    public void setGoods_pics(String goods_pics) {
        this.goods_pics = goods_pics;
    }
}
