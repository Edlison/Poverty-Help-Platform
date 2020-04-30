package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.OrderDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {

    @Insert("insert into order_master (openid_fk, express_name, express_address, order_payment, order_shipping_money, order_point) " +
            "values (#{openid}, #{express_name}, #{express_address}, #{order_payment}, #{order_shipping_money}, #{order_point})")
    Long insertOrder(OrderDTO orderDTO);

    @Select("select * from order_master where openid_fk = #{openid}")
    List<OrderDTO> getOrder(@Param("openid") String openid);
}
