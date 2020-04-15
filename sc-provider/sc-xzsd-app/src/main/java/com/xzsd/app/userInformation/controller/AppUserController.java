package com.xzsd.app.userInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userInformation.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/15 16:27
 */
@RestController
@RequestMapping("/userInformation")
public class AppUserController {
    private static final Logger logger = LoggerFactory.getLogger(AppUserController.class);
    @Resource
    private AppUserService appUserService;
    @PostMapping("getUser")
    public AppResponse getUser(){
        try {
            AppResponse appResponse=appUserService.getUser();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(String userPassword,String userNewPassword){
        try {
            AppResponse appResponse=appUserService.updateUserPassword(userPassword,userNewPassword);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
