package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/14 11:08
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;

    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try {
            AppResponse appResponse=driverService.addDriver(driverInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增失败",e);
            throw e;
        }
    }
}
