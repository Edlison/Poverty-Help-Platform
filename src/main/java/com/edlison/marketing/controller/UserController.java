package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/wxLogin")
    @ResponseBody
    public JSONObject wxLogin(@RequestParam(name = "code") String code) throws Exception {

        SystemResult res = userService.WXLogin(code);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", res.getStatus());
        jsonObject.put("msg", res.getMsg());
        jsonObject.put("data", res.getData());

        return jsonObject;
    }

    @PostMapping("/getUserInfo")
    @ResponseBody
    public JSONObject getUserInfo(@RequestParam(name = "openid") String openid, @RequestParam(name = "token") String token) {

        SystemResult userInfoRes = userService.getUserInfo(openid, token);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", userInfoRes.getStatus());
        jsonObject.put("msg", userInfoRes.getMsg());
        jsonObject.put("data", userInfoRes.getData());

        return jsonObject;
    }

    @GetMapping("/test")
    @ResponseBody
    public JSONObject test() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openid", "wasd1234");
        jsonObject.put("session_key", "wasd1234");

        return jsonObject;
    }
}
