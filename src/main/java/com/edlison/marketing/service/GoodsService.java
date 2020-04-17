package com.edlison.marketing.service;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.GoodsListDTO;
import com.edlison.marketing.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public GoodsDetailDTO getGoodsDetail(Long id) {
        GoodsDetailDTO goodsDetailDTO = goodsMapper.getGoodsDetail(id);

        return goodsDetailDTO;
    }

    public List<GoodsListDTO> getGoodsList(Long page) {
        Long start = (page - 1) * 8;
        Long size = 8L;
        List<GoodsListDTO> goodsList = goodsMapper.getGoodsList(start, size);

        return goodsList;
    }

    public List<GoodsListDTO> goodsSearch(String name) {
        name = "%" + name + "%";
        List<GoodsListDTO> goodsSearch = goodsMapper.getGoodsSearch(name);

        return goodsSearch;
    }
}
