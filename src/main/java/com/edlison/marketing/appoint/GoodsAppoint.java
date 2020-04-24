package com.edlison.marketing.appoint;

import com.edlison.marketing.DTO.GoodsListDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsAppoint {

    public List<GoodsListDTO> sortByType(List<GoodsListDTO> allGoodsList, int start, int size, int type) {
        List<GoodsListDTO> res;

        if (type == 0) {    // 原序
            if (start + size < allGoodsList.size()) {
                res = allGoodsList.subList(start, start + size);
            } else {
                res = allGoodsList.subList(start, allGoodsList.size());
            }
        } else if (type == 1){  // 降序
            allGoodsList.sort(((o1, o2) -> (int) (o2.getGoods_price() - o1.getGoods_price())));

            if (start + size < allGoodsList.size()) {
                res = allGoodsList.subList(start, start + size);
            } else {
                res = allGoodsList.subList(start, allGoodsList.size());
            }
        } else if (type == 2) { // 升序
            allGoodsList.sort((o1, o2) -> (int) (o1.getGoods_price() - o2.getGoods_price()));

            if (start + size < allGoodsList.size()) {
                res = allGoodsList.subList(start, start + size);
            } else {
                res = allGoodsList.subList(start, allGoodsList.size());
            }
        } else {
            res = null;
        }

        return res;
    }
}
