package com.xzsd.pc.cate.dao;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.entity.cateParentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CateDao {
    /**
     * 查询分类是否存在
     * @param cateName
     * @return
     */
    int countCateByName(@Param("cateName") String cateName);

    /**
     * 新增分类
     * @param cateInfo
     * @return
     */
    int addCate(CateInfo cateInfo);
    /**
     * 查询父级分类列表
     */
    List<CateInfo> getCate();

    /**
     * 查询子类
     * @param chId
     * @return
     */
    CateInfo findCateById(@Param("chId")String chId);
//
//    int addMq(String json);

    /**
     * 删除分类
     * @param cateId
     * @return
     */
    int delectCateById(@Param("cateId") String cateId, @Param("lastModifiedBy")String lastModifiedBy);

    /**
     * 检查是否有子类存在
     * @param cateId
     * @return
     */
    int chekChiById(@Param("cateId")String cateId);

    /**
     * 修改分类
     * @param cateInfo
     * @return
     */
    int updateCateById(CateInfo cateInfo);
    List<CateInfo> listMenus();
    CateInfo getCateById(@Param("cateId")String cateId);
}
