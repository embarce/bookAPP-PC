package com.xzsd.pc.order.service;


import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.order.dao.OredrDao;
import com.xzsd.pc.order.entity.OrderDetailsVO;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/6 21:23
 */
@Service
public class OrderService {
    @Resource
    private OredrDao oredrDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
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

    /**
     * 查询订单分页
     * @param orderInfo
     * @return
     */
    public AppResponse listOredrByPage(OrderInfo orderInfo){
        List<OrderVO> orderVOList=oredrDao.listOrderByPage(orderInfo);
        return AppResponse.success("查询成功！", PageUtils.getPageInfo(orderVOList));
    }
    public AppResponse findOrderById(String orderId){
        OrderDetailsVO orderDetailsVO=oredrDao.findOrderById(orderId);
        return AppResponse.success("查询成功",orderDetailsVO);
    }
    @Transactional(rollbackFor = Exception.class)
    public AppResponse CancelOrderById(String orderId){
        List<String> listCode = Arrays.asList(orderId.split(","));
        String userId=SecurityUtils.getCurrentUserId();
        int count=oredrDao.CancelOrderById(listCode,userId);
        if(count==0){
            return AppResponse.bizError("取消失败");
        }
        else {
            return AppResponse.success("取消成功");
        }
    }
}
