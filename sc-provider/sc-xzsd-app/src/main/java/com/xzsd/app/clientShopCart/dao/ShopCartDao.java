package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopCartDao {
    /**
     * 查重
     *
     * @param goodsId
     * @return
     */
    int countByGoodsId(@Param("goodsId") String goodsId, @Param("userId")String userId);

    /**
     * 新增
     *
     * @param shopCartInfo
     * @return
     */
    int addShopCart(ShopCartInfo shopCartInfo);

    /**
     * 查询购物车列表
     *
     * @param userCode
     * @return
     */
    List<ShopCartVO> listShoppingCarts(@Param("userCode") String userCode);

    /**
     * 修改购物车
     *
     * @param shopCartInfo
     * @return
     */
    int updateShoppingCart(ShopCartInfo shopCartInfo);

    /**
     * 删除购物车
     *
     * @param listCode
     * @return
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);

    /**
     * 获取价格
     *
     * @param goodsId
     * @return
     */
    String getPrice(@Param("goodsId") String goodsId);
}
