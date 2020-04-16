package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.HomeCrossImageVO;
import com.xzsd.app.clientHome.entity.HomeHotGoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDao {
    List<HomeCrossImageVO> listRotationCharHome();
    List<HomeHotGoodsVO> listHotGoods();
}
