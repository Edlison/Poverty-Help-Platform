package com.edlison.marketing.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Mapper
@Component
public interface UserMapper {

    @Select("select user_session from user where openid = #{openid}")
    String checkSession(@Param("openid") String openid);

    @Select("select user_balance from user where openid = #{openid}")
    BigDecimal getUserBalance(String openid);

    @Update("update user set user_balance = #{newBalance} where openid = #{openid}")
    void updateUserBalance(String openid, BigDecimal newBalance);

    @Insert("insert into user (openid, user_session) values (#{openid}, #{session_key})")
    Long insertUser(String openid, String session_key);
}
