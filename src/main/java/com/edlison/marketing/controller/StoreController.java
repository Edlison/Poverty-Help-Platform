package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(String email, String password) {

        return null;
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public String changePassword() {

        return null;
    }

    @PostMapping("/confirmPassword")
    @ResponseBody
    public String confirmPassword() {

        return null;
    }

    @PostMapping("/order/getProducts")
    @ResponseBody
    public String getProducts() {

        return null;
    }

    @PostMapping("/order/onCancel")
    @ResponseBody
    public String onCancel() {

        return null;
    }

    @PostMapping("/order/onPay")
    @ResponseBody
    public String onPay() {

        return null;
    }

    @PostMapping("/order/onSend")
    @ResponseBody
    public String onSend() {

        return null;
    }

    @PostMapping("/order/onReceive")
    @ResponseBody
    public String onReceive() {

        return null;
    }
}
