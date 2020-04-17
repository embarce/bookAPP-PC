package com.xzsd.pc.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/17 9:38
 */
@RestController
@RequestMapping("topOfColumn")
public class TopController {
    private static final Logger logger = LoggerFactory.getLogger(TopController.class);
    @Resource
    private UserService userService;

    @PostMapping("getTopOfColumn")
    public AppResponse getTopOfColumn(){
        try {
            AppResponse appResponse=userService.getTopOfColumn();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败",e);
            throw e;
        }
    }
}
