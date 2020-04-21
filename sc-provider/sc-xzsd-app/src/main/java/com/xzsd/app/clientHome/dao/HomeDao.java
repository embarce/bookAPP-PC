package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.HomeCrossImageVO;
import com.xzsd.app.clientHome.entity.HomeHotGoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDao {
    /**
     * 查询首页轮播图接口
     *
     * @return
     */
    List<HomeCrossImageVO> listRotationCharHome();

    /**
     * 查询热门商品接口
     *
     * @return
     */
    List<HomeHotGoodsVO> listHotGoods();
}
