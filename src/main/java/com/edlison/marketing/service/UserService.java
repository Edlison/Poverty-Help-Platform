package com.edlison.marketing.service;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.appoint.UserAppoint;
import com.edlison.marketing.mapper.UserMapper;
import com.edlison.marketing.model.User;
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

    public SystemResult WXLogin(String code) throws Exception {
        String res = userAppoint.doGet(code);
        JSONObject jsonObject = JSONObject.parseObject(res);

        String openid = jsonObject.get("openid").toString();
        String session_key = jsonObject.get("session_key").toString();

        String token = userAppoint.generateToken(openid, session_key);

        SystemResult loginWXRes = SystemResult.LOGIN_WX_SUCCESS;
        JSONObject data = new JSONObject();
        data.put("openid", openid);
        data.put("token", token);
        loginWXRes.setData(data);

        // 插入用户或更新用户
        insertOrUpdate(openid, session_key);

        return loginWXRes;
    }

    public SystemResult checkSession(String openid, String token) {
        if (openid == null || token == null) return SystemResult.LOGIN_SESSION_MISSING_PARAM;
        String user_session = userMapper.checkSession(openid);

        SystemResult res = userAppoint.checkSessionHelper(openid, user_session, token);

        return res;
    }

    public SystemResult insertOrUpdate(String openid, String session_key) {

        User user = userMapper.getUser(openid);

        if (user == null) {
            userMapper.insertUser(openid, session_key);
        } else {
            userMapper.updateUser(openid, session_key);
        }

        return SystemResult.LOGIN_WX_SUCCESS;
    }

    public SystemResult getUserInfo(String openid, String token) {

        SystemResult checkSessionRes = checkSession(openid, token);

        if (!ResultTrans.isOK(checkSessionRes)) {
            return checkSessionRes;
        } else {
            User user = userMapper.getUser(openid);
            JSONObject data = new JSONObject();
            data.put("user_balance", user.getUser_balance());
            data.put("user_point", user.getUser_point());

            SystemResult userGetInfoRes = SystemResult.USER_GET_INFO_SUCCESS;
            userGetInfoRes.setData(data);

            return userGetInfoRes;
        }
    }
}
