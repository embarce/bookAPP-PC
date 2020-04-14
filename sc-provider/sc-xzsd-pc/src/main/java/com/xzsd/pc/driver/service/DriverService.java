package com.xzsd.pc.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.Dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/14 11:11
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    @Resource
    private UserDao userDao;
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        int count=driverDao.countDriverAcct(driverInfo.getDriverAcct());
        driverInfo.setDriverCode(StringUtil.getCommonCode(2));
        if(count!=0){
            return AppResponse.success("司机账号已存在");
        }else {
           int num= driverDao.addDriver(driverInfo);
            UserInfo userInfo=new UserInfo();
//            userInfo.setUserPwd();
//           int user=userDao.addUser()
           if(num==0){
               return AppResponse.bizError("新增失败");
           }else {
               return AppResponse.success("新增成功");
           }
        }
    }
}
