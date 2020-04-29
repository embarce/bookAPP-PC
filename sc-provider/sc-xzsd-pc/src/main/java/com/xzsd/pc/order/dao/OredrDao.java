package com.xzsd.pc.order.dao;


import com.xzsd.pc.order.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/6 21:22
 */
@Mapper
public interface OredrDao {
    /**
     * 新增订单接口
     * @param orderInfo
     * @return
     */
    int addOrder(OrderInfo orderInfo);
    /**
     * 新增订单明细接口
     * @param orderInfo
     * @return
     */
    int addOrderDetail(List<OrderDetailsVO> orderInfo);

    /**
     * 分页查询订单列表
     * @param orderInfo
     * @return
     */
    List<OrderVO> listOrderByPage(OrderInfo orderInfo);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetailsVO> findOrderById(@Param("orderId")String orderId);

    /**
     * 订单各个状态修改 订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     *
     *                        订单取消  订单到货  取消到货   订单已取货     取消已取货
     *                           2         1      0          3              1
     * @param listCode
     * @param userId
     * @return
     */
      int updateOrderStatusById(@Param("listCode") List<String> listCode,@Param("userId")String userId,@Param("status")String status);
      int updateOrderStatus(List<OrderDTO> orderDTO);

    /**
     * 库存更新
     * @param orderInfo
     * @return
     */
      int updateGoodsStock(List<OrderDetailsVO> orderInfo);
    /**
     * 库存返回
     * @param orderNumVOS
     * @return
     */
    int updateGoodsByGoodsId(List<OrderNumVO> orderNumVOS);
    List<OrderNumVO> getGoodsNumByOrderId(@Param("orderId") List<String> orderId);
}
