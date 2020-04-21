package com.edlison.marketing.service;

import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.GoodsListDTO;
import com.edlison.marketing.appoint.GoodsAppoint;
import com.edlison.marketing.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsAppoint goodsAppoint;

    @Autowired
    GoodsMapper goodsMapper;

    public GoodsDetailDTO getGoodsDetail(Long id) {
        GoodsDetailDTO goodsDetailDTO = goodsMapper.getGoodsDetail(id);

        return goodsDetailDTO;
    }

    public List<GoodsListDTO> getGoodsList(Long page, Integer type) {
        int start = (page.intValue() - 1) * 8;
        int size = 8;

        List<GoodsListDTO> allGoodsList = goodsMapper.getAllGoodsList();

        if (start > allGoodsList.size()) {
            return null;
        } else {
            List<GoodsListDTO> res = goodsAppoint.sortByType(allGoodsList, start, size, type);
            return res;
        }
    }

    public List<GoodsListDTO> goodsSearch(String name) {
        name = "%" + name + "%";
        List<GoodsListDTO> goodsSearch = goodsMapper.getGoodsSearch(name);

        return goodsSearch;
    }
}
