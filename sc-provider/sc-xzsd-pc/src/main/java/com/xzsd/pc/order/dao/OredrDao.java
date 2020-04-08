package com.xzsd.pc.order.dao;


import com.xzsd.pc.order.entity.OrderDetailsVO;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
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
    OrderDetailsVO findOrderById(@Param("orderId")String orderId);

    int CancelOrderById(@Param("listCode") List<String> listCode,@Param("userId")String userId);
}
