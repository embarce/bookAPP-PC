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
    public AppResponse listRotationCharHome(){
        List<HomeCrossImageVO>slideShowList =homeDao.listRotationCharHome();
        if(slideShowList==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",slideShowList);
        }
    }
    public AppResponse listHotGoods(){
        List<HomeHotGoodsVO> list=homeDao.listHotGoods();
        if(list==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",list);
        }
    }
}
