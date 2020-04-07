package com.xzsd.pc.order.dao;


import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

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
}
