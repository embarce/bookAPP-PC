package com.xzsd.pc.order.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.order.dao.OredrDao;
import com.xzsd.pc.order.entity.OrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/6 21:23
 */
@Service
public class OrderService {
    @Resource
    private OredrDao oredrDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        orderInfo.setCreateBy("embrace");
        orderInfo.setOrderId(StringUtil.getCommonCode(2));
        int count=oredrDao.addOrder(orderInfo);
        if(count==0){
            return AppResponse.bizError("新增失败");
        }else {
            return AppResponse.success("新增成功");
        }
    }
}
