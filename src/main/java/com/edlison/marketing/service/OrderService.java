package com.edlison.marketing.service;

import com.edlison.marketing.DTO.OrderDTO;
import com.edlison.marketing.appoint.OrderAppoint;
import com.edlison.marketing.mapper.OrderMapper;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderAppoint orderAppoint;

    @Autowired
    OrderMapper orderMapper;

    public SystemResult checkOrder(OrderDTO orderDTO) {
        SystemResult checkUserBalanceRes = orderAppoint.checkUserBalance(orderDTO.getOpenid(), orderDTO.getOrder_payment());
        if (!ResultTrans.isOK(checkUserBalanceRes)) return checkUserBalanceRes;

        SystemResult insertOrderRes = insertOrder(orderDTO);
        if (!ResultTrans.isOK(insertOrderRes)) return insertOrderRes;

        return SystemResult.ORDER_SUBMIT_SUCCESS;
    }

    public SystemResult insertOrder(OrderDTO orderDTO) {
        Long res = orderMapper.insertOrder(orderDTO);

        if (res > 0) return SystemResult.ORDER_SUBMIT_SUCCESS;
        else return SystemResult.ORDER_INSERT_DB_ERROR;
    }
}
