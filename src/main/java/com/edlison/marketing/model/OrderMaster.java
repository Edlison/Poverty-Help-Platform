package com.edlison.marketing.model;

import java.math.BigDecimal;

public class OrderMaster {
    private Long order_id;
    private String openid_fk;
    private String express_name;
    private String express_address;
    private BigDecimal order_payment;
    private BigDecimal order_shipping_money;
    private Long order_point;
}
