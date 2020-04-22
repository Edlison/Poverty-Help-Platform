package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import io.netty.handler.codec.http.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Value("${APPID}")
    String APPID;

    @Value("${APPSECRET}")
    String APPSECRET;

    @Value("${JSCODE2SESSION}")
    String JSCODE2SESSION;

    @PostMapping("/wxLogin")
    @ResponseBody
    public JSONObject wxLogin(@RequestParam(name = "code") String code, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect(JSCODE2SESSION + "?appid=" + APPID + "&secret=" + APPSECRET + "&jscode=" + code + "&grant_type=" + UUID.randomUUID().toString());

        int status = response.getStatus();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);

        return jsonObject;
    }
}
