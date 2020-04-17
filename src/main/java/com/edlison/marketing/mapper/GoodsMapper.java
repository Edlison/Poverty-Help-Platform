package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.GoodsListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {

    @Select("select * from goods where goods_id = #{goods_id}")
    GoodsDetailDTO getGoodsDetail(@Param("goods_id")Long goods_id);

    @Select("select * from goods limit #{start}, #{size}")
    List<GoodsListDTO> getGoodsList(Long start, Long size);

    @Select("select * from goods where goods_name like #{name}")
    List<GoodsListDTO> getGoodsSearch(@Param("name") String name);
}
