package com.edlison.marketing.controller;

import com.alibaba.fastjson.JSONObject;
import com.edlison.marketing.DTO.GoodsDetailDTO;
import com.edlison.marketing.DTO.SwiperDTO;
import com.edlison.marketing.result.SystemResult;
import com.edlison.marketing.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * IndexController
 *
 * @Author Edlison
 * @Date 7/23/20 11:08
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/swiper")
    @ResponseBody
    public JSONObject swiper() {
        JSONObject jsonObject = new JSONObject();
        SystemResult res;

        List<SwiperDTO> swiperList = indexService.getSwiper();

        if (swiperList != null) res = SystemResult.INDEX_SWIPER_SUCCESS;
        else res = SystemResult.INDEX_SWIPER_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("status", res.getStatus());
        jsonObject.put("swiperList", swiperList);

        return jsonObject;
    }

    @PostMapping("/getGoodsList")
    @ResponseBody
    public JSONObject getGoodsList() {
        JSONObject jsonObject = new JSONObject();
        SystemResult res;

        List<GoodsDetailDTO> goodsList = indexService.getGoodsList();

        if (goodsList != null) res = SystemResult.INDEX_GOODS_SUCCESS;
        else res = SystemResult.INDEX_GOODS_FAILED;

        jsonObject.put("msg", res.getMsg());
        jsonObject.put("code", res.getStatus());
        jsonObject.put("goodsList", goodsList);

        return jsonObject;
    }
}
