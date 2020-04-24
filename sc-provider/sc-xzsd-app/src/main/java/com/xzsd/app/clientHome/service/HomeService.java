package com.xzsd.app.clientHome.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.dao.HomeDao;
import com.xzsd.app.clientHome.entity.HomeCrossImageVO;
import com.xzsd.app.clientHome.entity.HomeHotGoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/16 9:40
 */
@Service
public class HomeService {
    @Resource
    private HomeDao homeDao;

    /**
     * 轮播图
     *
     * @return
     */
    public AppResponse listRotationCharHome() {
        List<HomeCrossImageVO> slideShowList = homeDao.listRotationCharHome();
        if (slideShowList == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", slideShowList);
        }
    }

    /**
     * 查询热门商品接口
     *
     * @return
     */
    public AppResponse listHotGoods() {
        int showNum=homeDao.showTheNum();
        List<HomeHotGoodsVO> list = homeDao.listHotGoods(showNum);
        if (list == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", list);
        }
    }
}
