package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {
    /**
     * 查询营业执照
     *
     * @param business
     * @return
     */

    int countBusiness(@Param("business") String business);

    /**
     * 新增门店
     *
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 删除门店
     *
     * @param listCode
     * @param userId
     * @return
     */

    int deleteStore(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改门店
     *
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 分页查询
     *
     * @param storeDO
     * @return
     */
    List<StoreVO> listStoreByPage(StoreDO storeDO);

    /**
     * 店铺详情
     *
     * @param storeCode
     * @return
     */

    StoreInfo findStoreById(@Param("storeCode") String storeCode);

    /**
     * 查店长下面的门店
     *
     * @param storeDO
     * @return
     */
    List<StoreVO> listStoreByPageByUserId(StoreDO storeDO);

    /**
     * 检查用户是否存在
     *
     * @param userId
     * @return
     */
    int checkUserId(@Param("userId") String userId);
}
