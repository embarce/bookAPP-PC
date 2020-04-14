package com.xzsd.pc.driver.Dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DriverDao {
    int countDriverAcct(@Param("driverAcct") String driverAcct);
    int addDriver(DriverInfo driverInfo);
}
