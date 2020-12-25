package com.edlison.marketing.DTO;

/**
 * ShowOrderDTO
 *
 * @Author Edlison
 * @Date 12/25/20 10:03
 */
public class ShowOrderDTO {
    private String openid_fk;
    private Double total_fee;

    public String getOpenid_fk() {
        return openid_fk;
    }

    public void setOpenid_fk(String openid_fk) {
        this.openid_fk = openid_fk;
    }

    public Double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Double total_fee) {
        this.total_fee = total_fee;
    }
}
