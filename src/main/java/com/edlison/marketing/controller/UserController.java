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

        String token = userService.WXLogin(code);
        SystemResult res;

        if (token == null || token == "") { // need to update
            res = SystemResult.LOGIN_WX_FAILED;
        } else {
            res = SystemResult.LOGIN_WX_SUCCESS;
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", res.getStatus());
        jsonObject.put("msg", res.getMsg());
        jsonObject.put("token", token);

        return jsonObject;
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("get ok!");

        return "{\"session_key\":\"i7QvaVmChtiVm9hbADBnWg==\",\"openid\":\"owGrn5ULjCuTfIE5Z1re2XqRgvrU\"}";
    }
}
