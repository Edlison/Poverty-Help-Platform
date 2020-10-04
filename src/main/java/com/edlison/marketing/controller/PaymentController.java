package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PaymentController
 *
 * @Author Edlison
 * @Date 8/13/20 12:54
 */
@Controller
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/placeOrder")
    @ResponseBody
    public JSONObject placeOrder(@RequestParam(name = "openid") String openid) throws Exception{
        JSONObject jsonObject = new JSONObject();
        SystemResult res = paymentService.placeOrder(openid);

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("data", res.getData());

        return jsonObject;
    }

    @PostMapping("/queryOrder")
    public JSONObject queryOrder() {

        paymentService.queryOrder();

        return null;
    }
}
