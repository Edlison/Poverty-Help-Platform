package com.edlison.marketing.appoint;

import com.edlison.marketing.mapper.UserMapper;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderAppoint {

    @Autowired
    UserMapper userMapper;

    public SystemResult checkUserBalance(String openid, BigDecimal order_payment) {
        BigDecimal userBalance = userMapper.getUserBalance(openid);
        if (userBalance.compareTo(order_payment) == 1) {
            userMapper.updateUserBalance(openid, userBalance.subtract(order_payment));
            return SystemResult.ORDER_SUBMIT_SUCCESS;
        } else return SystemResult.ORDER_BALANCE_INSUFFICIENT;
    }
}
