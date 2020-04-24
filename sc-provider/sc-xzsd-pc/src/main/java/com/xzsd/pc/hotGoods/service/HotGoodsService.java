package com.xzsd.pc.hotGoods.service;

import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/9 9:57
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 新增热门位
     *
     * @param hotGoodsInfo
     * @return
     */
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo) {
        int count = hotGoodsDao.countHotGoods(hotGoodsInfo.getGoodsId());
        int Id = hotGoodsDao.findNumByNum(hotGoodsInfo.getNoId());
        if (count > 0) {
            return AppResponse.repeat("商品已存在热门位，请前往修改");
        } else {
            if (Id == 0) {
                hotGoodsInfo.setCreateBy(SecurityUtils.getCurrentUserId());
                hotGoodsInfo.setHotGoodsCode(StringUtil.getCommonCode(2));
                int num = hotGoodsDao.addHotGoods(hotGoodsInfo);
                if (num == 0) {
                    return AppResponse.bizError("新增失败");
                } else {
                    return AppResponse.success("新增成功");
                }
            } else {
                return AppResponse.repeat("序号已存在请前往修改");
            }
        }
    }

    /**
     * 查询可选择商品
     *
     * @param choseHotsGoodsVO
     * @return
     */
    public AppResponse choseGoodsByPage(ChoseHotsGoodsVO choseHotsGoodsVO) {
        List<ChoseHotsGoodsVO> choseHotsGoodsVOList = hotGoodsDao.choseGoods(choseHotsGoodsVO);
        return AppResponse.success("查询成功", PageUtils.getPageInfo(choseHotsGoodsVOList));
    }

    /**
     * 修改展示数量
     *
     * @param showNum
     * @return
     */
    public AppResponse changeShowNum(String showNum) {
        String userId = SecurityUtils.getCurrentUserId();
        int num = hotGoodsDao.changeShowNum(showNum, userId);
        if (num == 0) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    public AppResponse showTheNum() {
        int showNum = hotGoodsDao.showTheNum();
        return AppResponse.success("查询成功", showNum);
    }

    /**
     * 删除热门
     *
     * @param listCode
     * @return
     */
    public AppResponse deleteHotGoods(String listCode) {
        List<String> hotGoodsList = Arrays.asList(listCode.split(","));
        int num = hotGoodsDao.deleteHotGoods(hotGoodsList, SecurityUtils.getCurrentUserId());
        if (num == 0) {
            return AppResponse.bizError("删除失败");
        } else {
            return AppResponse.success("删除成功");
        }
    }

    /**
     * 修改热门
     *
     * @param hotGoodsDO
     * @return
     */
    public AppResponse updateHotGoodsById(HotGoodsDO hotGoodsDO) {
        int Id = hotGoodsDao.findNumByNum(hotGoodsDO.getNoId());
        if (Id > 0) {
            return AppResponse.repeat("序号已存在，请更改别的序号");
        } else {
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsDO.setUserId(userId);
            int num = hotGoodsDao.updateHotGoodsById(hotGoodsDO);
            if (num == 0) {
                return AppResponse.bizError("修改失败");
            } else {
                return AppResponse.success("修改成功");
            }
        }
    }

    /**
     * 分页查询热门商品
     *
     * @param goodsId
     * @param goodsName
     * @return
     */
    public AppResponse listHotGoodsByPage(String goodsId, String goodsName) {
        List<HotGoodsVO> listHotGoods = hotGoodsDao.listHotGoodsByPage(goodsId, goodsName);
        return AppResponse.success("查询成功", PageUtils.getPageInfo(listHotGoods));
    }
    public AppResponse getHotGoods(String hotGoodsId){
        HotGoodsDelitVO hotGoodsDelitVO=hotGoodsDao.getHotGoods(hotGoodsId);
        if(hotGoodsDelitVO==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",hotGoodsDelitVO);
        }
    }
}
