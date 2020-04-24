package com.edlison.marketing.service;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.appoint.UserAppoint;
import com.edlison.marketing.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserAppoint userAppoint;

    public String WXLogin(String code) throws Exception {
        String res = userAppoint.doGet(code);
        JSONObject jsonObject = JSONObject.parseObject(res);

        String token = userAppoint.generateToken(jsonObject);

        return token;
    }

    public SystemResult checkSession(Integer id, String sha256) {
        
        return null;
    }
}
