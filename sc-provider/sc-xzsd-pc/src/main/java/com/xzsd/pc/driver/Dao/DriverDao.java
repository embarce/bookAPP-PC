package com.xzsd.pc.driver.Dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverDao {
    int countDriverAcct(String driverAcct);
    int addDriver(DriverInfo driverInfo);
}
