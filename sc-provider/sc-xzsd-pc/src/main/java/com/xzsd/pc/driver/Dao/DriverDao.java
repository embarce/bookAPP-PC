package com.xzsd.pc.driver.Dao;

import com.xzsd.pc.driver.entity.DriverDo;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {
    int countDriverAcct(@Param("driverAcct") String driverAcct);
    int addDriver(DriverInfo driverInfo);
    int updateDriver(DriverInfo driverInfo);
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("userCode") String userCode);
    List<DriverVO> listDriverByPage(DriverDo driverDo);
    DriverInfo findDriverById(@Param("driverId")String driverId);
}
