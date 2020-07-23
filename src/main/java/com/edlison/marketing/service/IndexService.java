package com.edlison.marketing.service;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.SwiperDTO;
import com.edlison.marketing.mapper.IndexMapper;
import com.edlison.marketing.result.SystemResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IndexService
 *
 * @Author Edlison
 * @Date 7/23/20 11:15
 */
@Service
public class IndexService {

    @Autowired
    private IndexMapper indexMapper;

    public List<SwiperDTO> getSwiper() {

        List<SwiperDTO> swiperList = indexMapper.getSwiper();

        return swiperList;
    }

    public List<GoodsDetailDTO> getGoodsList() {

        List<GoodsDetailDTO> goodsList = indexMapper.getGoodsList();

        return goodsList;
    }
}
