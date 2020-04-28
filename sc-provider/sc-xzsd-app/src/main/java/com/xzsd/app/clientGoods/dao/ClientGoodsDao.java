package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientGoodsDao {
    /**
     * 获取商品
     *
     * @param goodsId
     * @return
     */
    ClientGoodsVO getGoods(@Param("goodsId") String goodsId);

    /**
     * 获取商品评价
     *
     * @param evaluateScoreDo
     * @return
     */
    List<ClientGoodsEvaluatesVO> getEvaluatesByPage(EvaluateScoreDo evaluateScoreDo);

    /**
     * 查找一级分类
     *
     * @return
     */
    List<ListOneGoodsClassifyVO> listGetClassGoods();

    /**
     * 查询分类商品
     *
     * @param cateId
     * @return
     */
    List<cateListVO> listGoodsByCateId(@Param("cateId") String cateId);
    GoodsScoreInfo getGoodsScoreByGoodsId(@Param("goodsId")String goodsId);
}
