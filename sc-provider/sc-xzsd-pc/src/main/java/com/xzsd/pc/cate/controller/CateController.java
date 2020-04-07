package com.xzsd.pc.cate.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.service.CateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/3/27 16:32
 */
@RestController
@RequestMapping("/cate")
public class CateController {
    private static final Logger logger = LoggerFactory.getLogger(CateController.class);
    @Resource
    private CateService cateService;
    @PostMapping("addCate")
    public AppResponse addCate(CateInfo cateInfo){
        try {
            AppResponse appResponse=cateService.addCate(cateInfo);
            return  appResponse;

        }catch (Exception e){
            logger.error("add the cate false");
            System.out.println(e.toString());
            throw  e;
        }
    }
    @PostMapping("getCate")
    public AppResponse getCate(){
        try {
            AppResponse appResponse=cateService.getCate();
            return  appResponse;
        }catch (Exception e){
            return AppResponse.bizError(e.toString());
        }
    }
    @PostMapping("delectCateById")
    public AppResponse delectCateById(String cateId){
        try{
            AppResponse appResponse=cateService.delectCateById(cateId);
            return appResponse;
        }catch (Exception e){
            return AppResponse.bizError(e.toString());
        }
    }
    @PostMapping("updateCateById")
    public AppResponse updateCateById(CateInfo cateInfo){
        try{
            AppResponse appResponse=cateService.updateCateById(cateInfo);
            return  appResponse;
        }catch (Exception e){
            return AppResponse.bizError("修改失败");
        }
    }
}
