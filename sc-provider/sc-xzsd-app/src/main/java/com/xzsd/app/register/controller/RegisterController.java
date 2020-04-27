package com.xzsd.app.register.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.entity.UserInfo;
import com.xzsd.app.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Embrace
 * @Desrciption 用户功能模块
 * @date 2020/3/26 11:06
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    private RegisterService registerService;

    /***
     * @ClassName
     * @Description : 新增用户
     *
     * @param userInfo
     * @Author : Embrace
     * @Date : 2020-03-26
     */
    @PostMapping("clientRegister")
    public AppResponse addUser(UserInfo userInfo) {
        try {
            AppResponse appResponse = registerService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增用户失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
