package com.xzsd.app.clientGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.service.ClientGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/16 9:37
 */
@RestController
@RequestMapping("/clientGoods")
public class ClientGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);
    @Resource
    private ClientGoodsService clientGoodsService;
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try {
            AppResponse appResponse=clientGoodsService.getGoods(goodsId);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }

    @PostMapping("getEvaluates")
    public AppResponse getEvaluates(String goodsId){
        try {
            AppResponse appResponse=clientGoodsService.getEvaluates(goodsId);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
