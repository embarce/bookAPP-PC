package com.xzsd.app.clientInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientInformation.service.ClientInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/20 22:51
 */
@RestController
@RequestMapping("/clientInformation")
public class ClientInformationController {
    private static final Logger logger = LoggerFactory.getLogger(ClientInformationController.class);
    @Resource
    private ClientInformationService clientInformationService;

    /**
     * 修改邀请码
     * @param inviteCode
     * @return
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(String inviteCode) {
        try {
            AppResponse appResponse = clientInformationService.updateClientInvite(inviteCode);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改失败", e);
            throw e;
        }
    }
}
