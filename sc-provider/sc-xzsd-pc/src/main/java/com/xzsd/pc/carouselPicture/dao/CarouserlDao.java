package com.xzsd.pc.carouselPicture.dao;

import com.xzsd.pc.carouselPicture.entity.CarouserlInfo;
import com.xzsd.pc.carouselPicture.entity.CarouserlListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图功能接口
 * @author 72937
 * @date 2020-3-27
 */
@Mapper
public interface CarouserlDao {
    /**
     * 统计轮播图个数
     * @param num
     * @return
     */
    int countCarouserlById(@Param("num") int num);

    /**
     * 新增轮播图
     * @param carouserlInfo
     * @return
     */
    int addCarouserl(CarouserlInfo carouserlInfo);

    /**
     * 删除轮播图
     * @param listCode
     * @param lastModifiedBy
     * @return
     */
    int deleteCarouserl(@Param("listCode") List<String> listCode, @Param("lastModifiedBy") String lastModifiedBy);

    /**
     * 查询轮播图列表
     * @param carouserlInfo
     * @return
     */
    List<CarouserlListVo> carouserlListByPage(CarouserlInfo carouserlInfo);

    /**
     * 启用接口
     * @param listCode
     * @param lastModifiedBy
     * @return
     */
    int updateStatusOpen(@Param("listCode") List<String> listCode, @Param("lastModifiedBy") String lastModifiedBy);

    /**
     * 禁用接口
     * @param listCode
     * @param lastModifiedBy
     * @return
     */
    int updateStatusOff(@Param("listCode") List<String> listCode, @Param("lastModifiedBy") String lastModifiedBy);
}
