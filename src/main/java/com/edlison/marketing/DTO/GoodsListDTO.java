package com.edlison.marketing.DTO;

import lombok.Data;

@Data
public class GoodsListDTO {
    private String _id;
    private Long goods_id;
    private String goods_name;
    private Double goods_price;
    private Double goods_freight;
    private String goods_sold_num;
    private String goods_area;
    private String goods_introduce;
    private String goods_small_logo;
    private String pics;
}
