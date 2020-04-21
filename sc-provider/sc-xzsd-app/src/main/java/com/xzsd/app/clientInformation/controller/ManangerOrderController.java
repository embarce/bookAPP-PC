package com.xzsd.app.clientInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientInformation.entity.OrderDO;
import com.xzsd.app.clientInformation.service.ManangerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/21 11:43
 */
@RestController
@RequestMapping("/manangerOrder")
public class ManangerOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ManangerOrderController.class);
    @Resource
    private ManangerService manangerService;

    @PostMapping("listManagerOrders")
    public AppResponse listManagerOrders(String orderStateId) {
        try {
            AppResponse appResponse = manangerService.listOrder(orderStateId);
            return appResponse;
        } catch (Exception e) {
            logger.error("订单查询失败", e);
            throw e;
        }
    }
    @PostMapping("updateManangerOrderState")
    public AppResponse updateManangerOrderState(OrderDO orderDO){
        try {
            AppResponse appResponse=manangerService.updateManangerOrderState(orderDO);
            return appResponse;
        }catch (Exception e){
            logger.error("订单修改失败", e);
            throw e;
        }
    }
    @PostMapping("listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId) {
        try {
            AppResponse appResponse = manangerService.listManagerOrderDeepen(orderId);
            return appResponse;
        } catch (Exception e) {
            logger.error("订单查询失败", e);
            throw e;
        }
    }
    @PostMapping("listManangerDrivers")
    public AppResponse listManangerDrivers(){
        try {
            AppResponse appResponse=manangerService.listManangerDrivers();
            return appResponse;
        }catch (Exception e){
            logger.error("司机查询失败", e);
            throw e;
        }
    }
    @PostMapping("listDriverStores")
    public AppResponse listDriverStores(){
        try {
            AppResponse appResponse=manangerService.listDriverStores();
            return appResponse;
        }catch (Exception e){
            logger.error("查询门店失败", e);
            throw e;
        }
    }
}
