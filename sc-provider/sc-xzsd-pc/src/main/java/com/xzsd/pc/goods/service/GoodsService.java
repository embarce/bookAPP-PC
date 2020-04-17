package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.JsonUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.TencentUtil.CosController;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.classifVO;
import com.xzsd.pc.goods.entity.goodsInfo;
import com.xzsd.pc.goods.entity.goodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author 72937
 * @Description 实现类
 * @Date 2020-03-23
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
//    @Resource
//    private RedisOperator redisOperator;
//    public AppResponse setKey(goodsInfo goodsInfo){
//        String jsonString=JsonUtils.toJson(goodsInfo);
//        if(null==redisOperator.get("goods1")){
//            redisOperator.set("goods1",jsonString);
//            return AppResponse.success("新增成功");
//        }
//        else return AppResponse.bizError("新增失败redis已存在");
//    }
//    public AppResponse getKey(String goodsInfo){
//        String info=redisOperator.get(goodsInfo);
//        return AppResponse.success("查询成功",JsonUtils.fromJson(info,PageInfo.class));
//    }

    /**
     * goods 新增商品
     *
     * @param goodsInfo
     * @return
     * @author 72937
     * @Date 2020-03-23
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(goodsInfo goodsInfo) {
        // 校验商品是否存在
        int countgoodsBybookId = goodsDao.countgoodsBybookId(goodsInfo.getBookId());
        if (0 != countgoodsBybookId) {
            return AppResponse.repeat("商品账号已存在，请重新输入！");
        }
        String bookId=StringUtil.getCommonCode(2);
        goodsInfo.setGoodId(bookId);
        goodsInfo.setBookId(bookId);
        goodsInfo.setIsDeleted(0);
//        String filePath = CosController.upload(file);
//        goodsInfo.setPicture(filePath);
        // 新增商品
        int count = goodsDao.addGoods(goodsInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询列表
     *
     * @param goodsInfo
     * @return
     * @Author 7293747
     * @Date 2020-03-25
     */
    public AppResponse listGoodsByPage(goodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<goodsVO> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
////        if(null==redisOperator.get("goods1")){
//        // 包装Page对象
//        PageInfo<goodsInfo> pageData = new PageInfo<goodsInfo>(goodsInfoList);
//        String jsonString = JsonUtils.toJson(pageData);
////            redisOperator.set("goods1",jsonString,60*5);
        return AppResponse.success("查询成功！", PageUtils.getPageInfo(goodsInfoList));
//        }
//        else return AppResponse.bizError("新增失败redis已存在");
    }

    /**
     * 删除商品
     *
     * @return AppResponse
     * @pram goodsId
     * @author 72937
     * @date 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId) {
        List<String> listCode = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        String lastModifiedBy = SecurityUtils.getCurrentUserId();
        // 删除商品
        int count = goodsDao.deleteGoods(listCode, lastModifiedBy);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改商品信息
     *
     * @param goodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(goodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验商品是否存在
        goodsInfo.setLastModifiedBy(SecurityUtils.getCurrentUserId());
        //修改商品信息
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 != count) {
            appResponse = AppResponse.success("修改成功，请刷新页面");
            return appResponse;
        }else {
            return AppResponse.bizError("修改失败");
        }
    }

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     */
    public AppResponse getGoodsByGoodsId(String goodsId) {
        goodsInfo goodsInfo = goodsDao.getGoodsByGoodsId(goodsId);
        return AppResponse.success("查询成功", goodsInfo);
    }

    /**
     * 上下架商品
     *
     * @param goodsId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsUpper(String goodsId) {
        List<String> listCode = Arrays.asList(goodsId.split(","));
        String lastModifiedBy = SecurityUtils.getCurrentUserId();
        AppResponse appResponse = AppResponse.success("上架成功");
        int count = goodsDao.updateGoodsUpper(listCode, lastModifiedBy);
        if (0 == count) {
            appResponse = AppResponse.bizError("上架失败，请重试！");
        }
        return appResponse;
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsLower(String goodsId) {
        List<String> listCode = Arrays.asList(goodsId.split(","));
        String lastModifiedBy = SecurityUtils.getCurrentUserId();
        AppResponse appResponse = AppResponse.success("下架成功");
        int count = goodsDao.updateGoodsLower(listCode, lastModifiedBy);
        if (0 == count) {
            appResponse = AppResponse.bizError("下架失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询商品一级分类下拉框接口
     *
     * @return
     */
    public AppResponse listGoodsClassify() {
        List<classifVO> classifVOS = goodsDao.listGoodsClassify();
        if (classifVOS == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", classifVOS);
        }
    }

    /**
     * 查询商品二级分类下拉框接口
     *
     * @param classifyId
     * @return
     */
    public AppResponse listGoodsClassifyByPid(String classifyId) {
        List<classifVO> classifVOSCh = goodsDao.listGoodsClassifyByPid(classifyId);
        if (classifVOSCh == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", classifVOSCh);
        }
    }
}
