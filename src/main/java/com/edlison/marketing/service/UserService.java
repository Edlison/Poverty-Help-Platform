package com.edlison.marketing.service;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.appoint.UserAppoint;
import com.edlison.marketing.mapper.UserMapper;
import com.edlison.marketing.result.ResultTrans;
import com.edlison.marketing.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserAppoint userAppoint;

    @Autowired
    UserMapper userMapper;

    public String WXLogin(String code) throws Exception {
        String res = userAppoint.doGet(code);
        JSONObject jsonObject = JSONObject.parseObject(res);

        String openid = jsonObject.get("openid").toString();
        String session_key = jsonObject.get("session_key").toString();

        String token = userAppoint.generateToken(openid, session_key);

        Long insertUserRes = userMapper.insertUser(openid, session_key);

        return token;
    }

    public SystemResult checkSession(String openid, String token) {
        if (openid == null || token == null) return SystemResult.LOGIN_SESSION_MISSING_PARAM;
        String user_session = userMapper.checkSession(openid);

        SystemResult res = userAppoint.checkSessionHelper(openid, user_session, token);

        return res;
    }
}
