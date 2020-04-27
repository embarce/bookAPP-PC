package com.xzsd.app.clientHome.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.service.HomeService;
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
@RequestMapping("/clientHome")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private HomeService homeService;

    /**
     * 轮播图获取
     * @return
     */
    @PostMapping("listRotationCharHome")
    public AppResponse listRotationCharHome(){
        try {
            AppResponse appResponse=homeService.listRotationCharHome();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }

    /**
     * 热门商品获取
     * @return
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(){
        try {
            AppResponse appResponse=homeService.listHotGoods();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
