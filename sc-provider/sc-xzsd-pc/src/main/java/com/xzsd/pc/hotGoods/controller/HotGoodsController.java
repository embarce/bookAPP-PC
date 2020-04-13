package com.xzsd.pc.hotGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.hotGoods.entity.ChoseHotsGoodsVO;
import com.xzsd.pc.hotGoods.entity.HotGoodsDO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/9 9:56
 */
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);
    @Resource
    private HotGoodsService hotGoodsService;
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            AppResponse appResponse=hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @RequestMapping(value="choseGoodsByPage")
    public AppResponse choseGoodsByPage(ChoseHotsGoodsVO choseHotsGoodsVO){
        try{
            AppResponse appResponse=hotGoodsService.choseGoodsByPage(choseHotsGoodsVO);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            throw e;
        }
    }
    @PostMapping("changeShowNum")
    public AppResponse changeShowNum(String showNum){
        try{
            AppResponse appResponse=hotGoodsService.changeShowNum(showNum);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            throw e;
        }
    }
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsIdList){
        try{
            AppResponse appResponse=hotGoodsService.deleteHotGoods(hotGoodsIdList);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败");
            throw e;
        }
    }
    @PostMapping("updateHotGoodsById")
    public AppResponse updateHotGoodsById(HotGoodsDO hotGoodsDO){
        try{
            AppResponse appResponse=hotGoodsService.updateHotGoodsById(hotGoodsDO);
            return appResponse;
        }catch (Exception e){
            logger.error("修改失败");
            throw e;
        }
    }
    @RequestMapping(value="listHotGoodsByPage")
    public AppResponse listHotGoodsByPage(String goodsId,String goodsNam){
        try{
            AppResponse appResponse=hotGoodsService.listHotGoodsByPage(goodsId,goodsNam);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            throw e;
        }
    }
}
