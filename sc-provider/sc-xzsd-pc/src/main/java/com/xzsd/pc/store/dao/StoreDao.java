package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {
    int findStoreByStoreName(@Param("name") String name);

    int countBusiness(@Param("business") String business);

    int addStore(StoreInfo storeInfo);

    int deleteStore(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    int updateStore(StoreInfo storeInfo);

    List<StoreVO> listStoreByPage(StoreDO storeDO);

    StoreInfo findStoreById(@Param("storeCode") String storeCode);
    List<StoreVO> listStoreByPageByUserId(StoreDO storeDO);
}
