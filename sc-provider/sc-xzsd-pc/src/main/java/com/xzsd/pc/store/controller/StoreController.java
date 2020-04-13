package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * @author Embrace
 * @date 2020/4/13 16:57
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try {
            AppResponse appResponse=storeService.addStore(storeInfo);
            return  appResponse;
        }catch (Exception e){
            logger.error("新增失败",e);
            throw e;
        }
    }
}
