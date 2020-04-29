package com.xzsd.app.clientOrder.dao;


import com.xzsd.app.clientOrder.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/6 21:22
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 新增订单接口
     *
     * @param orderInfo
     * @return
     */
    int addOrder(OrderInfo orderInfo);

    /**
     * 新增订单明细接口
     *
     * @param orderInfo
     * @return
     */
    int addOrderDetail(List<OrderDetailsVO> orderInfo);

    /**
     * 跟新库存
     *
     * @param orderInfo
     * @return
     */
    int updateGoodsStock(List<OrderDetailsVO> orderInfo);

    /**
     * 查指定用户的订单,状态
     *
     * @param orderStateId
     * @param userId
     * @return
     */
    List<ClientOrderVO> listOrder(@Param("orderStateId") String orderStateId, @Param("userId") String userId);

    /**
     * 返回商品数量库存
     *
     * @param goodsId
     * @return
     */
    List<Integer> chGoodsNum(@Param("goodsId") List<String> goodsId);

    /**
     * 更新订单状态
     *
     * @param orderDO
     * @return
     */
    int updateOrderState(OrderDO orderDO);

    /**
     * 查询订单详情接口
     *
     * @param orderId
     * @return
     */
    ClientOrderVO listOrderDeepen(@Param("orderId") String orderId);

    /**
     * 获取指定的订单的商品
     *
     * @param orderId
     * @return
     */
    List<ClientOrderGoodsVO> getGoodsByOrderId(@Param("orderId") String orderId);

    /**
     * 获取评价商品信息
     *
     * @param orderId
     * @return
     */
    List<ClientOrderGoodsList> listGoodsForEvaluate(@Param("orderId") String orderId);

    /**
     * 新增评价
     *
     * @param evaluateDOS
     * @return
     */
    int addGoodsEvaluate(List<EvaluateDO> evaluateDOS);

    /**
     * 跟新库存接口
     * @param goodsIdList
     * @return
     */
    int updateGoodsNumByGoodsList(@Param("goodsIdList")List<String> goodsIdList);

    /**
     * 清空购物车
     * @param goodsId
     * @param userId
     * @return
     */
    int updateShoppingCar(@Param("goodsId") List<String> goodsId,@Param("userId")String userId);
    List<GoodsScoreInfo> getGoodsCountByGoodsId(@Param("goodsId")List<String> goodsId);

    /**
     * 跟新评分
     * @param goodsScoreDO
     * @return
     */
    int updateGoodsScore(List<GoodsScoreDO> goodsScoreDO);

    /**
     * 获取数量
     * @param orderId
     * @return
     */
    List<OrderNumVO> getGoodsNumByOrderId(@Param("orderId") String orderId);

    /**
     * 库存返回
     * @param orderNumVOS
     * @return
     */
    int updateGoodsByGoodsId(List<OrderNumVO> orderNumVOS);

    /**
     * 跟新评价后的订单状态
     * @param orderId
     * @return
     */
    int updateOrderStateForEve(@Param("orderId")String orderId);
}
