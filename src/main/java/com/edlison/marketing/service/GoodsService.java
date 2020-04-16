package com.edlison.marketing.service;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public GoodsDetailDTO getGoodsDetail(Long id) {

        GoodsDetailDTO goodsDetailDTO = goodsMapper.goodsDetailDTO(id);

        return goodsDetailDTO;
    }
}
