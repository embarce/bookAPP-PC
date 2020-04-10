package com.xzsd.pc.hotGoods.service;

import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.ChoseHotsGoodsVO;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/9 9:57
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        int count=hotGoodsDao.countHotGoods(hotGoodsInfo.getGoodsId());
        if(count>0){
            return AppResponse.success("商品已存在热门位，请前往修改");
        }else {
            hotGoodsInfo.setCreateBy(StringUtil.getCommonCode(2));
            int num=hotGoodsDao.addHotGoods(hotGoodsInfo);
            if(num==0){
                return AppResponse.bizError("新增失败");
            }else {
                return AppResponse.success("新增成功");
            }
        }
    }
    public AppResponse choseGoodsByPage(ChoseHotsGoodsVO choseHotsGoodsVO){
        List<ChoseHotsGoodsVO> choseHotsGoodsVOList=hotGoodsDao.choseGoods(choseHotsGoodsVO);
        return AppResponse.success("查询成功",PageUtils.getPageInfo(choseHotsGoodsVOList));
    }
}
