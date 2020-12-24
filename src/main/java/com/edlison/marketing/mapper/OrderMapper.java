package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.OrderDTO;
import com.edlison.marketing.DTO.OrderDetailDTO;
import com.edlison.marketing.DTO.OrderViewDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {

    @Insert("insert into order_master (order_id, openid_fk, express_name, express_address, order_payment, order_shipping_money, order_point, order_status) " +
            "values (#{order_id}, #{openid}, #{express_name}, #{express_address}, #{order_payment}, #{order_shipping_money}, #{order_point}, #{order_status})")
    Long insertOrder(OrderDTO orderDTO);

    @Insert({"<script> insert into order_detail (order_id_fk, product_id, product_name, product_price, product_num) " +
            "values " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\"  separator=\",\"> "+
            "(#{order_id}, #{item.product_id}, #{item.product_name}, #{item.product_price}, #{item.product_num})" +
            "</foreach> </script>"})
    Long insertOrderDetail(@Param("order_id") Long order_id, @Param("list") List<OrderDetailDTO> orderDetailDTOS);

    @Select("select order_id from order_master where openid_fk = #{openid}")
    Long getOrderId(@Param("openid") String openid);

    @Select("select * from order_master where openid_fk = #{openid}")
    List<OrderDTO> getOrder(@Param("openid") String openid);

    @Select("select * from order_detail where order_id_fk = #{order_id}")
    List<OrderDetailDTO> getOrderDetail(@Param("order_id") Long order_id);

    @Delete("delete from order_master where order_id = #{order_id}")
    void deleteOrder(@Param("order_id") String order_id);

    @Select("select * from v_order")
    List<OrderViewDTO> showView();
}
