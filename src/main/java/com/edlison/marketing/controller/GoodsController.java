package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/getGoodsDetail")
    @ResponseBody
    public JSONObject getGoodsDetail(@RequestParam(name = "id") Long id) {
        GoodsDetailDTO goodsDetail = goodsService.getGoodsDetail(id);
        JSONObject jsonObject = new JSONObject();
        SystemResult res;

        if (goodsDetail != null) res = SystemResult.GOODS_DETAIL_SUCCESS;
        else res = SystemResult.GOODS_DETAIL_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("goods_detail", goodsDetail);

        return jsonObject;
    }
}
