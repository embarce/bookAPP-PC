package com.xzsd.pc.carouselPicture.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.carouselPicture.entity.CarouserlInfo;
import com.xzsd.pc.carouselPicture.service.CarouserlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/3/27 10:54
 */
@RestController
@RequestMapping("/Carouserl")
public class CarouserlController {
    private static final Logger logger = LoggerFactory.getLogger(CarouserlController.class);

    @Resource
    private CarouserlService carouserlService;

    /**
     * 新增轮播图
     * @param carouserlInfo
     * @return
     */
    @PostMapping("addCarouserl")
    public AppResponse addCarouserl(CarouserlInfo carouserlInfo){
        try {
            AppResponse appResponse=carouserlService.addCarouserl(carouserlInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增轮播图失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("deleteCarouserl")
    public AppResponse deleteCarouserl(String listString){
        try{
            AppResponse appResponse=carouserlService.deleteCarouserl(listString);
            return appResponse;
        }catch (Exception e){
            logger.error("删除轮播图失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @RequestMapping(value="carouserlListByPage")
    public AppResponse carouserlListByPage(CarouserlInfo carouserlInfo){
        try {
            return carouserlService.carouserlListByPage(carouserlInfo);
        }catch (Exception e){
            logger.error("查询列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateStatusOpen")
    public AppResponse updateStatusOpen(String listString){
        try{
            AppResponse appResponse=carouserlService.updateStatusOpen(listString);
            return appResponse;
        }catch (Exception e){
            logger.error("启用轮播图失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateStatusOff")
    public AppResponse updateStatusOff(String listString){
        try{
            AppResponse appResponse=carouserlService.updateStatusOff(listString);
            return appResponse;
        }catch (Exception e){
            logger.error("启用轮播图失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
