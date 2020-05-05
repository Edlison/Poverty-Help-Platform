package com.edlison.marketing.service;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.OrderDTO;
import com.edlison.marketing.appoint.OrderAppoint;
import com.edlison.marketing.mapper.OrderMapper;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderAppoint orderAppoint;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserService userService;

    public SystemResult checkOrder(OrderDTO orderDTO) {
        SystemResult checkUserBalanceRes = orderAppoint.checkUserBalance(orderDTO.getOpenid(), orderDTO.getOrder_payment());
        if (!ResultTrans.isOK(checkUserBalanceRes)) return checkUserBalanceRes;

        SystemResult insertOrderRes = insertOrder(orderDTO);
        if (!ResultTrans.isOK(insertOrderRes)) return insertOrderRes;

        return SystemResult.ORDER_SUBMIT_SUCCESS;
    }

    public SystemResult insertOrder(OrderDTO orderDTO) {
        // 生成OrderId
        Long orderId = SnowFlake.generateOrderId();
        orderDTO.setOrder_id(orderId);
        Long orderRes = orderMapper.insertOrder(orderDTO);
        // order_id 订单编号 需要提前生成 !
        Long orderDetailRes = orderMapper.insertOrderDetail(orderId, orderDTO.getOrder_detail());

        if (orderRes > 0 && orderDetailRes > 0) return SystemResult.ORDER_SUBMIT_SUCCESS;
        else return SystemResult.ORDER_INSERT_DB_ERROR;
    }

    public SystemResult getOrder(String openid, String token) {

        SystemResult checkSessionRes = userService.checkSession(openid, token);

        if (!ResultTrans.isOK(checkSessionRes)) {
            return checkSessionRes;
        } else {
            JSONObject data = new JSONObject();
            List<OrderDTO> orderDTOList = orderMapper.getOrder(openid);
            data.put("orders", orderDTOList);
            SystemResult orderGetInfoRes = SystemResult.ORDER_GET_INFO_SUCCESS;
            orderGetInfoRes.setData(data);

            return orderGetInfoRes;
        }
    }
}
