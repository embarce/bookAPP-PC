package com.xzsd.app.clientGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.entity.EvaluateScoreDo;
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

    /**
     * 获取商品信息
     *
     * @param goodsId
     * @return
     */
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId) {
        try {
            AppResponse appResponse = clientGoodsService.getGoods(goodsId);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 获取商品评价
     *
     * @param evaluateScoreDo
     * @return
     */
    @PostMapping("listGoodsEvaluatesByPage")
    public AppResponse getEvaluatesByPage(EvaluateScoreDo evaluateScoreDo) {
        try {
            AppResponse appResponse = clientGoodsService.getEvaluatesByPage(evaluateScoreDo);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 查询一级商品分类列接口
     *
     * @return
     */
    @PostMapping("listGetClassGoods")
    public AppResponse listGetClassGoods() {
        try {
            AppResponse appResponse = clientGoodsService.listGetClassGoods();
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 查询二级商品分类以及商品接口
     *
     * @param cateId
     * @return
     */
    @PostMapping("listGoodsByCateId")
    public AppResponse listGoodsByCateId(String cateId) {
        try {
            AppResponse appResponse = clientGoodsService.listGoodsByCateId(cateId);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }
}
