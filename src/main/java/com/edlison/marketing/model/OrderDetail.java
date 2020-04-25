package com.edlison.marketing.model;

import java.math.BigDecimal;

public class OrderDetail {
    private Long order_detail_id;
    private Long order_id_fk;
    private Long product_id;
    private String product_name;
    private BigDecimal product_price;
    private Long product_num;
}
