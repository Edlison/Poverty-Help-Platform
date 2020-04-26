package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.OrderDTO;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.OrderService;
import com.edlison.marketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @PostMapping("/submitOrder")
    @ResponseBody
    public JSONObject submitOrder(@RequestBody OrderDTO orderDTO) {
        JSONObject jsonObject = new JSONObject();

        SystemResult checkSessionRes = userService.checkSession(orderDTO.getOpenid(), orderDTO.getToken());    // 判断用户登陆态
        if (!ResultTrans.isOK(checkSessionRes)) {
            jsonObject.put("msg", checkSessionRes.getMsg());
            jsonObject.put("status", checkSessionRes.getStatus());
            return jsonObject;
        }

        SystemResult checkOrderRes = orderService.checkOrder(orderDTO);// 检查账户购买权限
        jsonObject.put("msg", checkOrderRes.getMsg());
        jsonObject.put("status", checkOrderRes.getStatus());

        return jsonObject;
    }
}
