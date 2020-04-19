package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopCartDao {
    int countByGoodsId(@Param("goodsId")String goodsId);
    int addShopCart(ShopCartInfo shopCartInfo);
    List<ShopCartVO> listShoppingCarts(@Param("userCode")String userCode);
}
