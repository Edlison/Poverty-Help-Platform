package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.GoodsListDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {

    @Select("select * from goods where goods_id = #{goods_id}")
    GoodsDetailDTO getGoodsDetail(@Param("goods_id") Long goods_id);

    @Select("select * from goods")
    List<GoodsListDTO> getAllGoodsList();

    @Select("select * from goods limit #{start}, #{size}")
    List<GoodsListDTO> getGoodsList(Long start, Long size);

    @Select("select * from goods where goods_name like #{name}")
    List<GoodsListDTO> getGoodsSearch(@Param("name") String name);

    @Insert({"insert into goods (_id, goods_id, goods_name, goods_price, goods_freight, goods_sold_num, goods_area, goods_introduce, goods_small_logo, goods_pics) values (#{_id}, #{goods_id}, #{goods_name}, #{goods_price}, #{goods_freight}, #{goods_sold_num}, #{goods_area}, #{goods_introduce}, #{goods_small_logo}, #{goods_pics})"})
    int insertGoods(String _id, Long goods_id, String goods_name, Double goods_price, Double goods_freight, String goods_sold_num, String goods_area, String goods_introduce, String goods_small_logo, String goods_pics);

    @Update("update goods set _id = #{_id}, goods_name = #{goods_name}, goods_price = #{goods_price}, goods_freight = #{goods_freight}, goods_sold_num = #{goods_sold_num}, goods_area = #{goods_area}, goods_introduce = #{goods_introduce}, goods_small_logo = #{goods_small_logo}, goods_pics = #{goods_pics} where goods_id = #{goods_id}")
    int updateGoods(String _id, Long goods_id, String goods_name, Double goods_price, Double goods_freight, String goods_sold_num, String goods_area, String goods_introduce, String goods_small_logo, String goods_pics);

}
