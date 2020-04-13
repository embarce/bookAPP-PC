package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreDao {
    int findStoreByStoreName(@Param("name") String name);
    int countBusiness(@Param("business") String business);
    int addStore(StoreInfo storeInfo);
}
