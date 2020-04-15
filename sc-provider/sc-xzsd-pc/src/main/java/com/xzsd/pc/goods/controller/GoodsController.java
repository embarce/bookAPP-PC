package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.entity.goodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author 72937
 * @time 2020年3月24日 11:31:48
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;
//    @PostMapping("setKey")
//    public AppResponse setKey(goodsInfo goodsInfo){
//        try {
//            AppResponse appResponse=goodsService.setKey(goodsInfo);
//            return appResponse;
//        }catch (Exception e){
//            return AppResponse.bizError("新增失败");
//        }
//    }
//    @PostMapping("getKey")
//    public AppResponse getKey(String goodsInfo){
//        try {
//            AppResponse appResponse=goodsService.getKey(goodsInfo);
//            return appResponse;
//        }catch (Exception e){
//            return AppResponse.bizError("查询失败");
//        }
//    }

    /**
     * 新增商品
     * @param goodsInfo
     * @return AppResponse
     * @author 72937
     * @Date 2020年3月24日 22:16:34
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(goodsInfo goodsInfo, MultipartFile file) throws Exception {
        try {
            //获取用户id 用于修改后的记录
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo,file);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询商品列表（分页）
     * @Param goodsInfo
     * @return AppResponse
     * @author 72937
     * @Date 2020-2-25
     */
    @RequestMapping(value="listGoods")
    public AppResponse listGoods(goodsInfo goodsInfo){
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e){
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除商品
     * @author 72937
     * @Date 2020-3-25
     * @Param goodsId   商品id
     * @return AppResponse
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsList){
        try {
            return goodsService.deleteGoods(goodsList);
        }catch (Exception e){
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品信息
     * @author 7293747
     * @Date 2020-3-25
     * @param goodsInfo
     * @return
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(goodsInfo goodsInfo){
        try{
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            goodsInfo.setLastModifiedBy(userId);
            return goodsService.updateGoods(goodsInfo);
        }catch(Exception e){
            logger.error("修改商品信息错误");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @date 2020-3-26
     * @param goodsId
     * @return
     */
    @RequestMapping(value="getGoodsByGoodsId")
    public AppResponse getGoodsByGoodsId(String goodsId){
        try{
            return goodsService.getGoodsByGoodsId(goodsId);
        }catch (Exception e){
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 上架下架商品
     * @param goodsList
     * @return
     */
    @PostMapping("updateGoodsUpper")
    public AppResponse updateGoodsUpper(String goodsList){
        try{
            return goodsService.updateGoodsUpper(goodsList);
        }catch (Exception e){
            logger.error("商品信息错误");
            System.out.println(e.toString());
            throw e;
        }
    }
    @PostMapping("updateGoodsLower")
    public AppResponse updateGoodsLower(String goodsList){
        try{
            return goodsService.updateGoodsLower(goodsList);
        }catch (Exception e){
            logger.error("商品信息错误");
            System.out.println(e.toString());
            throw e;
        }
    }

}
