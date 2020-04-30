package com.edlison.marketing.model;

import java.math.BigDecimal;

public class User {
    private Long user_id;
    private String openid;
    private String user_session;
    private String user_nickname;
    private Long user_sex;
    private String user_province;
    private String user_city;
    private String user_country;
    private String user_headimgurl;
    private String user_privilege;
    private BigDecimal user_balance;
    private Long user_point;
    private String user_create_time;
    private String user_last_login_time;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUser_session() {
        return user_session;
    }

    public void setUser_session(String user_session) {
        this.user_session = user_session;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public Long getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Long user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_province() {
        return user_province;
    }

    public void setUser_province(String user_province) {
        this.user_province = user_province;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_headimgurl() {
        return user_headimgurl;
    }

    public void setUser_headimgurl(String user_headimgurl) {
        this.user_headimgurl = user_headimgurl;
    }

    public String getUser_privilege() {
        return user_privilege;
    }

    public void setUser_privilege(String user_privilege) {
        this.user_privilege = user_privilege;
    }

    public BigDecimal getUser_balance() {
        return user_balance;
    }

    public void setUser_balance(BigDecimal user_balance) {
        this.user_balance = user_balance;
    }

    public Long getUser_point() {
        return user_point;
    }

    public void setUser_point(Long user_point) {
        this.user_point = user_point;
    }

    public String getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(String user_create_time) {
        this.user_create_time = user_create_time;
    }

    public String getUser_last_login_time() {
        return user_last_login_time;
    }

    public void setUser_last_login_time(String user_last_login_time) {
        this.user_last_login_time = user_last_login_time;
    }
}
