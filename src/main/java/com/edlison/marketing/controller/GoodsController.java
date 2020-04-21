package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.GoodsListDTO;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/getGoodsDetail")
    @ResponseBody
    public JSONObject getGoodsDetail(@RequestParam(name = "id") Long id) {
        JSONObject jsonObject = new JSONObject();
        SystemResult res;
        GoodsDetailDTO goodsDetail = goodsService.getGoodsDetail(id);

        if (goodsDetail != null) res = SystemResult.GOODS_DETAIL_SUCCESS;
        else res = SystemResult.GOODS_DETAIL_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("goods_detail", goodsDetail);

        return jsonObject;
    }

    @PostMapping("/getGoodsList")
    @ResponseBody
    public JSONObject getGoodsList(@RequestParam(name = "page") Long page,
                                   @RequestParam(name = "type") Integer type) {
        JSONObject jsonObject = new JSONObject();
        SystemResult res;
        List<GoodsListDTO> goodsList = goodsService.getGoodsList(page, type);

        if (goodsList != null) res = SystemResult.GOODS_LIST_SUCCESS;
        else res = SystemResult.GOODS_LIST_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("goods_list", goodsList);

        return jsonObject;
    }

    @PostMapping("/search")
    @ResponseBody
    public JSONObject search(@RequestParam(name = "name") String name) {
        JSONObject jsonObject = new JSONObject();
        SystemResult res;
        List<GoodsListDTO> search = goodsService.goodsSearch(name);

        if (search != null) res = SystemResult.GOODS_SEARCH_SUCCESS;
        else res = SystemResult.GOODS_SEARCH_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("search_results", search);

        return jsonObject;
    }
}
