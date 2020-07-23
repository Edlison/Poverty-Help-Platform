package com.edlison.marketing.mapper;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.SwiperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * IndexMapper
 *
 * @Author Edlison
 * @Date 7/23/20 11:15
 */
@Mapper
@Component
public interface IndexMapper {

    @Select("select * from swiper")
    List<SwiperDTO> getSwiper();

    @Select("select * from goods limit 10")
    List<GoodsDetailDTO> getGoodsList();
}
