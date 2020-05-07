package com.xzsd.app.clientInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientInformation.dao.ManangerOrderDao;
import com.xzsd.app.clientInformation.entity.ClientOrderVO;
import com.xzsd.app.clientInformation.entity.DriverInfo;
import com.xzsd.app.clientInformation.entity.OrderDO;
import com.xzsd.app.clientInformation.entity.StoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/21 11:44
 */
@Service
public class ManangerService {
    @Resource
    private ManangerOrderDao manangerOrderDao;

    /**
     * 查询列表
     *
     * @param orderStateId
     * @return
     */
    public AppResponse listOrder(String orderStateId) {
        String userId = SecurityUtils.getCurrentUserId();
        List<ClientOrderVO> clientOrderVOS=new ArrayList<>();
        if("4".equals(orderStateId)){
            clientOrderVOS=manangerOrderDao.listOrderBy(userId);
        }
        else {
            clientOrderVOS = manangerOrderDao.listOrder(orderStateId, userId);
        }
        return AppResponse.success("查询成功", clientOrderVOS);
    }

    /**
     * 修改订单
     *
     * @param orderDO
     * @return
     */
    public AppResponse updateManangerOrderState(OrderDO orderDO) {
        orderDO.setUserId(SecurityUtils.getCurrentUserId());
        int num = manangerOrderDao.updateManangerOrderState(orderDO);
        if (0 == num) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 查询指定店长订单的详细信息
     *
     * @param orderId
     * @return
     */
    public AppResponse listManagerOrderDeepen(String orderId) {
        List<ClientOrderVO> clientOrderVOS = manangerOrderDao.listManagerOrderDeepen(orderId);
        return AppResponse.success("查询成功", clientOrderVOS);
    }

    /**
     * 查询负责的司机信息
     *
     * @return
     */
    public AppResponse listManangerDrivers() {
        String userId = SecurityUtils.getCurrentUserId();
        List<DriverInfo> driverInfos = manangerOrderDao.listManangerDrivers(userId);
        return AppResponse.success("查询成功", driverInfos);
    }

    /**
     * 查询负责的门店
     *
     * @return
     */
    public AppResponse listDriverStores() {
        String userId = SecurityUtils.getCurrentUserId();
        List<StoreInfo> storeInfos = manangerOrderDao.listDriverStores(userId);
        return AppResponse.success("查询门店成功", storeInfos);
    }
}
