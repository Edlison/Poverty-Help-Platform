package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.OrderDTO;
import com.edlison.marketing.DTO.ShowOrderDTO;
import com.edlison.marketing.mapper.OrderMapper;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.OrderService;
import com.edlison.marketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @PostMapping("/submitOrder")
    @ResponseBody
    public JSONObject submitOrder(@RequestBody OrderDTO orderDTO) {
        JSONObject jsonObject = new JSONObject();

        SystemResult checkSessionRes = userService.checkSession(orderDTO.getOpenid(), orderDTO.getToken());// 判断用户登陆态
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

    @PostMapping("/getOrder")
    @ResponseBody
    public JSONObject getOrder(@RequestParam(name = "openid") String openid, @RequestParam(name = "token") String token) {
        JSONObject jsonObject = new JSONObject();

        SystemResult orderRes = orderService.getOrder(openid, token);

        jsonObject.put("status", orderRes.getStatus());
        jsonObject.put("msg", orderRes.getMsg());
        jsonObject.put("data", orderRes.getData());

        return jsonObject;
    }

    @PostMapping("/deleteOrder")
    @ResponseBody
    public JSONObject deleteOrder(@RequestParam(name = "openid") String openid, @RequestParam(name = "token") String token, @RequestParam(name = "id") String order_id) {
        JSONObject jsonObject = new JSONObject();

        SystemResult deleteOrderRes = orderService.deleteOrder(openid, token, order_id);

        jsonObject.put("status", deleteOrderRes.getStatus());
        jsonObject.put("msg", deleteOrderRes.getMsg());
        jsonObject.put("data", deleteOrderRes.getData());

        return jsonObject;
    }

    @PostMapping("/showView")
    @ResponseBody
    public JSONObject showView() {
        JSONObject jsonObject = new JSONObject();

        SystemResult showViewRes = orderService.showView();

        jsonObject.put("status", showViewRes.getStatus());
        jsonObject.put("msg", showViewRes.getMsg());
        jsonObject.put("data", showViewRes.getData());

        return jsonObject;
    }

    @PostMapping("/showOrderBySum")
    @ResponseBody
    public JSONObject showOrderBySum(@RequestParam(name = "limit") Long limit) {
        JSONObject jsonObject = new JSONObject();

        List<ShowOrderDTO> showOrderDTOS = orderMapper.showOrderBySum(limit);
        SystemResult systemResult;

        if (showOrderDTOS != null && showOrderDTOS.size() != 0) {
            systemResult = SystemResult.SHOW_ORDER_SUM_SUCCESS;
            jsonObject.put("status", systemResult.getStatus());
            jsonObject.put("msg", systemResult.getMsg());
            JSONObject data = new JSONObject();
            data.put("orderSum", showOrderDTOS);
            jsonObject.put("data", data);
        } else {
            systemResult = SystemResult.SHOW_ORDER_SUM_FAIL;
            jsonObject.put("status", systemResult.getStatus());
            jsonObject.put("msg", systemResult.getMsg());
        }
        return jsonObject;

    }
}
