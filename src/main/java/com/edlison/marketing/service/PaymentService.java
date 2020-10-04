package com.edlison.marketing.service;

import com.edlison.marketing.DTO.UnifiedOrderDTO;
import com.edlison.marketing.appoint.PaymentAppoint;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.utils.Host;
import com.edlison.marketing.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PaymentService
 *
 * @Author Edlison
 * @Date 8/14/20 00:17
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentAppoint paymentAppoint;

    public SystemResult placeOrder(String openid) throws Exception{
        String notifyUrl = "gfgf.tech/notify";
        String tradeType = "JSAPI";
        UnifiedOrderDTO order = new UnifiedOrderDTO();
        order.set("共扶共富", SnowFlake.generateOrderId().toString(), 1, Host.addr(), notifyUrl, tradeType, openid);
        SystemResult xmlRES = paymentAppoint.toXML(order);
        if (ResultTrans.isOK(xmlRES)) {
            SystemResult postRES = paymentAppoint.postXML(((String) xmlRES.getData().get("xml")));
            if (ResultTrans.isOK(postRES)) {
                SystemResult paymentSuccess = SystemResult.PAYMENT_SUCCESS;
                paymentSuccess.setData(postRES.getData());
                return paymentSuccess;
            } else {
                return SystemResult.PAYMENT_FAILED;
            }
        } else {
            return SystemResult.PAYMENT_FAILED;
        }
    }

    public SystemResult queryOrder() {

        paymentAppoint.queryOrder();

        return null;
    }
}
