package com.edlison.marketing.DTO;

import com.edlison.marketing.utils.RandomStr;
import com.edlison.marketing.utils.Sign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * UnifiedOrderDTO
 *
 * @Author Edlison
 * @Date 8/15/20 00:49
 */
@Component
public class UnifiedOrderDTO extends PayDTO{

    @Value("${APPID}")
    private String APPID = "wx4e6d4300e7071f6f";

    @Value("${MCHID}")
    private String MCHID = "1601814764";

    String appid = APPID;  // null
    String mch_id = MCHID;  //null
    String nonce_str = RandomStr.getRandomString(16);
    String sign;
    String body;
    String out_trade_no;
    Integer total_fee;
    String spbill_create_ip;
    String notify_url;
    String trade_type;
    String openid;

    public void set(String body, String out_trade_no, Integer total_fee, String spbill_create_ip, String notify_url, String trade_type, String openid) {
        this.body = body;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
        this.openid = openid;

        System.out.println("appid = " + appid);
        System.out.println("mch_id = " + mch_id);

        this.sign = Sign.generateSign(this);
    }

    @Override
    public String toString() {
        return  "appid=" + appid + "&" +
                "body=" + body + "&" +
                "mch_id=" + mch_id + "&" +
                "nonce_str=" + nonce_str + "&" +
                "notify_url=" + notify_url + "&" +
                "openid=" + openid + "&" +
                "out_trade_no=" + out_trade_no + "&" +
                "spbill_create_ip=" + spbill_create_ip + "&" +
                "total_fee=" + total_fee + "&" +
                "trade_type=" + trade_type + "&";
    }

    public String getAppid() {
        return appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public String getBody() {
        return body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public String getOpenid() {
        return openid;
    }
}
