package com.xzsd.pc.driver.service;

import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.Dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDo;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo) {
        int count = driverDao.countDriverAcct(driverInfo.getDriverAcct());
        String userId = StringUtil.getCommonCode(2);
        driverInfo.setDriverCode(userId);
        driverInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        if (count!=0) {
            return AppResponse.repeat("司机账号已存在");
        } else {
            int num = driverDao.addDriver(driverInfo);
            //封装司机进用户类新增用户和司机
            UserInfo userInfo = new UserInfo();
            userInfo.setUserPwd(PasswordUtils.generatePassword(driverInfo.getPassword()));
            userInfo.setUserId(userId);
            userInfo.setUserAcct(driverInfo.getDriverAcct());
            userInfo.setUserName(driverInfo.getDriverName());
            userInfo.setIdCard(driverInfo.getIdCard());
            userInfo.setPhone(driverInfo.getPhone());
            userInfo.setRole(2);
            int user = userDao.addUser(userInfo);
            if (user==0||num==0) {
                return AppResponse.bizError("新增失败");
            } else {
                return AppResponse.success("新增成功");
            }
        }
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        driverInfo.setLastModifiedBy(SecurityUtils.getCurrentUserId());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(driverInfo.getDriverCode());
        userInfo.setUserAcct(driverInfo.getDriverAcct());
        userInfo.setUserName(driverInfo.getDriverName());
        userInfo.setIdCard(driverInfo.getIdCard());
        userInfo.setPhone(driverInfo.getPhone());
        userInfo.setVersion(driverInfo.getVersion1());
        int count = driverDao.updateDriver(driverInfo);
        int num = userDao.updateUser(userInfo);
        if (count==0 || num==0) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 删除司机信息
     * @param driverList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverList) {
        List<String> listCode = Arrays.asList(driverList.split(","));
        int num=userDao.deleteUser(listCode, SecurityUtils.getCurrentUserId());
        int count = driverDao.deleteDriver(listCode, SecurityUtils.getCurrentUserId());
        if (0 == count || 0==num) {
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }
    public AppResponse listDriverByPage(DriverDo driverDo){
        List<DriverVO> driverVOList=driverDao.listDriverByPage(driverDo);
        return AppResponse.success("查询成功", PageUtils.getPageInfo(driverVOList));
    }
    public AppResponse findDriverById(String driverId){
        DriverInfo driverInfo=driverDao.findDriverById(driverId);
        if(driverInfo==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",driverInfo);
        }
    }
}
