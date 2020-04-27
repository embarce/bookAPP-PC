package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.entity.DriverDo;
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

    /**
     * 新增司机
     *
     * @param driverInfo
     * @return
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo) {
        try {
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增失败", e);
            throw e;
        }
    }

    /**
     * 更新司机
     *
     * @param driverInfo
     * @return
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            AppResponse appResponse = driverService.updateDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改失败", e);
            throw e;
        }
    }

    /**
     * 删除司机
     *
     * @param driverList
     * @return
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverList) {
        try {
            AppResponse appResponse = driverService.deleteDriver(driverList);
            return appResponse;
        } catch (Exception e) {
            logger.error("删除失败", e);
            throw e;
        }
    }

    /**
     * 分页查询
     *
     * @param driverDo
     * @return
     */
    @RequestMapping(value = "listDriverByPage")
    public AppResponse listDriverByPage(DriverDo driverDo) {
        try {
            return driverService.listDriverByPage(driverDo);
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 查询司机详情
     *
     * @param driverId
     * @return
     */
    @RequestMapping(value = "findDriverById")
    public AppResponse findDriverById(String driverId) {
        try {
            AppResponse appResponse = driverService.findDriverById(driverId);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }
}
