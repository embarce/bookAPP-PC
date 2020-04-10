package com.xzsd.pc.hotGoods.dao;

import com.xzsd.pc.hotGoods.entity.ChoseHotsGoodsVO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;

import java.util.List;

public interface HotGoodsDao {
    int countHotGoods(String goodsId);
    int addHotGoods(HotGoodsInfo hotGoodsInfo);
    List<ChoseHotsGoodsVO> choseGoods(ChoseHotsGoodsVO choseHotsGoodsVO);
}
