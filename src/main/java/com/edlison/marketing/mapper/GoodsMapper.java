package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GoodsMapper {

    @Select("select * from goods where goods_id = #{goods_id}")
    GoodsDetailDTO goodsDetailDTO(@Param("goods_id")Long goods_id);
}
