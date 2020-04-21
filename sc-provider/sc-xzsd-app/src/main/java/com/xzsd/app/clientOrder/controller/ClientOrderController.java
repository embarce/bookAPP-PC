package com.xzsd.app.clientOrder.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientOrder.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientOrder.entity.OrderDO;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.POST;

/**
 * @author Embrace
 * @date 2020/4/6 21:22
 */
@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);
    @Resource
    private ClientOrderService clientOrderService;
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo){
        try {
            AppResponse appResponse= clientOrderService.addOrder(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("订单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("listOrder")
    private AppResponse listOrder(String orderStatus){
        try{
            AppResponse appResponse=clientOrderService.listOrder(orderStatus);
            return appResponse;
        }catch (Exception e){
            logger.error("订单查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateOrderState")
    private AppResponse updateOrderState(OrderDO orderDO){
        try {
            return clientOrderService.updateOrderState(orderDO);
        }catch (Exception e){
            logger.error("订单状态修改失败",e);
            throw e;
        }
    }
    @PostMapping("listOrderDeepen")
    private AppResponse listOrderDeepen(String orderId){
        try{
            return clientOrderService.listOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("订单查询失败",e);
            throw e;
        }
    }
    @PostMapping("listGoodsForEvaluate")
    private AppResponse listGoodsForEvaluate(String orderId){
        try{
            return clientOrderService.listGoodsForEvaluate(orderId);
        }catch (Exception e){
            logger.error("信息查询失败",e);
            throw e;
        }
    }
    @PostMapping("addGoodsEvaluate")
    private AppResponse addGoodsEvaluate(@RequestBody GoodsEvaluateInfo goodsEvaluateInfo){
        try {
            return clientOrderService.addGoodsEvaluate(goodsEvaluateInfo);
//            return AppResponse.success("1",goodsEvaluateInfo);
        }catch (Exception e){
            logger.error("评价失败",e);
            throw e;
        }
    }
}
