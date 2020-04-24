package com.edlison.marketing.appoint;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.utils.SHA;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserAppoint {

    @Value("${APPID}")
    String APPID;

    @Value("${APPSECRET}")
    String APPSECRET;

    @Value("${JSCODE2SESSION}")
    String JSCODE2SESSION;

    public String doGet(String code) throws Exception{
        String url = JSCODE2SESSION + "?appid=" + APPID + "&secret=" + APPSECRET + "&js_code=" + code + "&grant_type=" + "authorization_code";
//        String url = "http://localhost:8080/api/user/test";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String res = EntityUtils.toString(entity);

        return res;
    }

    public String generateToken(JSONObject jsonObject) {
        String openid = jsonObject.get("openid").toString();
        String session_key = jsonObject.get("session_key").toString();

        String sha256 = SHA.SHA256(openid + session_key);

        return sha256;
    }
}
