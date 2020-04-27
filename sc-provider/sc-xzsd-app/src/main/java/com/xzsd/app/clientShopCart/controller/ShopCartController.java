package com.xzsd.app.clientShopCart.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.service.ShopCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/19 21:18
 */
@RestController
@RequestMapping("/clientShopCart")
public class ShopCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShopCartController.class);
    @Resource
    private ShopCartService shopCartService;

    /**
     * 新增购物车
     *
     * @param shopCartInfo
     * @return
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShopCartInfo shopCartInfo) {
        try {
            AppResponse appResponse = shopCartService.addShopCart(shopCartInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增失败", e);
            throw e;
        }
    }

    /**
     * 查询购物车
     *
     * @return
     */
    @PostMapping("listShoppingCarts")
    public AppResponse listShoppingCarts() {
        try {
            return shopCartService.listShoppingCarts();
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 更新购物车
     *
     * @param shopCartInfo
     * @return
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShopCartInfo shopCartInfo) {
        try {
            return shopCartService.updateShoppingCart(shopCartInfo);
        } catch (Exception e) {
            logger.error("修改失败", e);
            throw e;
        }
    }

    /**
     * 删除购物车
     *
     * @param shopCartId
     * @return
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId) {
        try {
            return shopCartService.deleteShoppingCart(shopCartId);
        } catch (Exception e) {
            logger.error("删除失败", e);
            throw e;
        }
    }
}
