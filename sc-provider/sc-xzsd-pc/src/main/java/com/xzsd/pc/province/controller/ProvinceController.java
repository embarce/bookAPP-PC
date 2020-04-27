package com.xzsd.pc.province.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.province.service.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/14 21:51
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);
    @Resource
    private ProvinceService provinceService;

    /**
     * 查询省份
     * @return
     */
    @PostMapping("findProvince")
    public AppResponse findProvince(){
        try {
            AppResponse appResponse=provinceService.findProvince();
            return appResponse;
        }catch (Exception e){
            logger.error("查询省份失败",e);
            throw e;
        }
    }

    /**
     * 下级城市或者区查询
     * @param pid
     * @return
     */
    @PostMapping("findCityByProvinceId")
    public AppResponse findCityByProvinceId(String pid){
        try {
            AppResponse appResponse=provinceService.findCityByProvinceId(pid);
            return appResponse;
        }catch (Exception e){
            logger.error("查询省份失败",e);
            throw e;
        }
    }
}
