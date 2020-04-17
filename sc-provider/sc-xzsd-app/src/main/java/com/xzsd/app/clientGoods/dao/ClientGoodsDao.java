package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.ClientGoodsEvaluatesVO;
import com.xzsd.app.clientGoods.entity.ClientGoodsVO;
import com.xzsd.app.clientGoods.entity.ListOneGoodsClassifyVO;
import com.xzsd.app.clientGoods.entity.EvaluateScoreDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientGoodsDao {
    /**
     * 获取商品
     * @param goodsId
     * @return
     */
    ClientGoodsVO getGoods(@Param("goodsId") String goodsId);
    /**
     * 获取商品评价
     * @param evaluateScoreDo
     * @return
     */
    List<ClientGoodsEvaluatesVO> getEvaluatesByPage(EvaluateScoreDo evaluateScoreDo);
    /**
     * 查找一级分类
     * @return
     */
    List<ListOneGoodsClassifyVO> listGetClassGoods();

}
