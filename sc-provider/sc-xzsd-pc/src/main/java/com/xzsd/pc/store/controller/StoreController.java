package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.store.entity.StoreDO;
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

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo) {
        try {
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增失败", e);
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storeList
     * @return
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeList) {
        try {
            AppResponse appResponse = storeService.deleteStore(storeList);
            return appResponse;
        } catch (Exception e) {
            logger.error("删除失败", e);
            throw e;
        }
    }

    /**
     * 修改门店
     * @param storeInfo
     * @return
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo) {
        try {
            AppResponse appResponse = storeService.updateStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改失败", e);
            throw e;
        }
    }

    /**
     * 分页查询门店
     * @param storeDO
     * @return
     */
    @PostMapping("listStoreByPage")
    public AppResponse listStoreByPage(StoreDO storeDO) {
        try {
            AppResponse appResponse = storeService.listStoreByPage(storeDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }

    /**
     * 门店详情
     * @param storeId
     * @return
     */
    @PostMapping("findStoreById")
    public AppResponse findStoreById(String storeId) {
        try {
            AppResponse appResponse = storeService.findStoreById(storeId);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询失败", e);
            throw e;
        }
    }
}
