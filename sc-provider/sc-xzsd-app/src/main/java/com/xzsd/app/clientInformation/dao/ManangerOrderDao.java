package com.xzsd.app.clientInformation.dao;

import com.xzsd.app.clientInformation.entity.ClientOrderVO;
import com.xzsd.app.clientInformation.entity.DriverInfo;
import com.xzsd.app.clientInformation.entity.OrderDO;
import com.xzsd.app.clientInformation.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ManangerOrderDao {
    /**
     * 查询店长的订单列表
     * @param orderStateId
     * @param userId
     * @return
     */
    List<ClientOrderVO> listOrder(@Param("orderStateId")String orderStateId, @Param("userId")String userId);
    List<ClientOrderVO> listOrderBy(@Param("userId")String userId);

    /**
     * 修改订单状态
     * @param orderDO
     * @return
     */
    int updateManangerOrderState(OrderDO orderDO);

    /**
     * 查询指定的订单详情
     * @param orderId
     * @return
     */
    List<ClientOrderVO> listManagerOrderDeepen(@Param("orderId")String orderId);

    /**
     * 查询店长的司机
     * @param userId
     * @return
     */
    List<DriverInfo>  listManangerDrivers(@Param("userId")String userId);

    /**
     * 查询负责门店的信息
     * @param userId
     * @return
     */
    List<StoreInfo> listDriverStores(@Param("userId")String userId);
}
