package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.ClientGoodsEvaluatesVO;
import com.xzsd.app.clientGoods.entity.ClientGoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientGoodsDao {
    ClientGoodsVO getGoods(@Param("goodsId") String goodsId);
    ClientGoodsEvaluatesVO getEvaluates(@Param("goodsId") String goodsId);

}
