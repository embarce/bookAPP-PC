package com.xzsd.pc.order.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/6 21:22
 */
@RestController
@RequestMapping("/Order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo){
        try {
            AppResponse appResponse= orderService.addOrder(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("订单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
