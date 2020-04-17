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
import java.util.Map;

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

    /**
     * 新增分类
     * @param cateInfo
     * @return
     */
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

    /**
     * 获取分类
     * @return
     */
    @PostMapping("getCate")
    public AppResponse getCate(){
        try {
            Map<String,Object> map=cateService.listCate("0");
            return AppResponse.success("查询成功", map);
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

    /**
     * 查询详情
     * @param cateId
     * @return
     */
    @PostMapping("findCateById")
    public AppResponse findCateById(String cateId){
        try{
            AppResponse appResponse=cateService.findCateById(cateId);
            return  appResponse;
        }catch (Exception e){
            return AppResponse.bizError("查询失败");
        }
    }
}
