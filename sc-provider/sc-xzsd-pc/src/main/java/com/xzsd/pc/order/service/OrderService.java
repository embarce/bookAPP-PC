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
import java.util.ArrayList;
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
     *
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo) {
        orderInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        String orderId = StringUtil.getCommonCode(2);
        orderInfo.setOrderId(orderId);
        List<String> goodsId = Arrays.asList(orderInfo.getGoodsIdList().split(","));
        List<String> goodsPrice = Arrays.asList(orderInfo.getGoodsPriceList().split(","));
        List<String> goodsNum = Arrays.asList(orderInfo.getGoodsNumList().split(","));
        List<OrderDetailsVO> orderInfoList = new ArrayList<>();
        orderInfo.setUserId(SecurityUtils.getCurrentUserId());
        orderInfo.setShippingUser(SecurityUtils.getCurrentUserId());
        float sum = 0;
        for (int i = 0; i < goodsId.size(); i++) {
            OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
            orderDetailsVO.setUserId(SecurityUtils.getCurrentUserId());
            orderDetailsVO.setOrderId(orderId);
            orderDetailsVO.setGoodsId(goodsId.get(i));
            float a = new Float(goodsPrice.get(i));
            int b = new Integer(goodsNum.get(i));
            orderDetailsVO.setPrice(new Float(goodsPrice.get(i)));
            orderDetailsVO.setNum(new Integer(goodsNum.get(i)));
            orderInfoList.add(orderDetailsVO);
            System.out.println(orderInfoList);
            sum = sum + (a * b);
            System.out.println(sum);
        }
        int goods=oredrDao.updateGoodsStock(orderInfoList);
        int num = oredrDao.addOrderDetail(orderInfoList);

        orderInfo.setPrice(sum);
        int count = oredrDao.addOrder(orderInfo);
        if (num == 0 && count == 0) {
            return AppResponse.bizError("新增失败");
        } else {
            return AppResponse.success("新增成功");
        }
    }
    /**
     * 查询订单分页
     *
     * @param orderInfo
     * @return
     */
    public AppResponse listOredrByPage(OrderInfo orderInfo) {
        List<OrderVO> orderVOList = oredrDao.listOrderByPage(orderInfo);
        return AppResponse.success("查询成功！", PageUtils.getPageInfo(orderVOList));
    }

    /**
     * 查询订单明细详情
     * @param orderId
     * @return
     */
    public AppResponse findOrderById(String orderId) {
        List<OrderDetailsVO> orderDetailsVO= oredrDao.findOrderById(orderId);
        return AppResponse.success("查询成功", orderDetailsVO);
    }
    /**
     * 订单各个状态修改 订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     *
     * @param orderId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatusById(String orderId, String status) {
        List<String> listCode = Arrays.asList(orderId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        int count = oredrDao.updateOrderStatusById(listCode, userId, status);
        if (count == 0) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }
}
