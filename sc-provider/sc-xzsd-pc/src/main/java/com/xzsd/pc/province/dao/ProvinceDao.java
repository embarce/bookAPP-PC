package com.xzsd.pc.province.dao;

import com.xzsd.pc.province.entity.ProvinceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProvinceDao {
    List<ProvinceInfo> findProvince();
    List<ProvinceInfo> findCityByProvinceId(@Param("pid")String pid);
}
