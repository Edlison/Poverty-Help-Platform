package com.edlison.marketing.utils;

import com.edlison.marketing.DTO.PayDTO;
import com.edlison.marketing.DTO.UnifiedOrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Sign
 *
 * @Author Edlison
 * @Date 8/14/20 00:43
 */
@Component
public class Sign {

    @Value("${PAYKEY}")
    private static String PAYKEY = "dnoiweu786eg81342g8wzlpodzdvw325";  // null

    public static String generateSign(PayDTO o) {
        String StringA;
        String sign = "";

        if (o instanceof UnifiedOrderDTO) {
            UnifiedOrderDTO order = ((UnifiedOrderDTO) o);
            StringA = order.toString() + "key=" + PAYKEY;  // 写死了
            System.out.println("PAYKEY = " + PAYKEY);
            System.out.println("StringA" + StringA);
            sign = MD5.getMD5(StringA, 32).toUpperCase();
        }

        return sign;
    }
}
