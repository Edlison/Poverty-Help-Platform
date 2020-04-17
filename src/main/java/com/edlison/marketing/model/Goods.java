package com.edlison.marketing.model;

import lombok.Data;

@Data
public class Goods {
    private String _id;
    private Long goods_id;
    private String goods_name;
    private Double goods_price;
    private Double goods_freight;
    private Long goods_sold_num;
    private String goods_area;
    private String goods_introduce;
    private String goods_small_logo;
    private String goods_pics;
}
