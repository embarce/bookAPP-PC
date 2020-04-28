package com.xzsd.app.userInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.service.PasswordUtils;
import com.xzsd.app.userInformation.dao.AppUserDao;
import com.xzsd.app.userInformation.entity.AppUserInfoVO;
import com.xzsd.app.userInformation.entity.UserInformation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/15 16:27
 */
@Service
public class AppUserService {
    @Resource
    private AppUserDao appUserDao;

    public AppResponse getUser() {
        String userId = SecurityUtils.getCurrentUserId();
        int role = appUserDao.getUserRole(userId);
        AppUserInfoVO userInfo = new AppUserInfoVO();
        //权限验证获取信息
        if (role == 3) {
            userInfo = appUserDao.getUserIsCustomer(userId);
        } else if (role == 1) {
            userInfo = appUserDao.getUserIsOwner(userId);
        } else if (role == 2) {
            userInfo = appUserDao.getUserIsDriver(userId);
        } else if (role == 0) {
            return AppResponse.success("非使用角色");
        }
        if (userInfo == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", userInfo);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(String userPassword, String userNewPassword) {
        String userId = SecurityUtils.getCurrentUserId();
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        //进行比较
        boolean flag = bcryptPasswordEncoder.matches(userPassword, appUserDao.getPassword(userId));
        if (flag == true) {
            userNewPassword = PasswordUtils.generatePassword(userPassword);
            int num = appUserDao.updateUserPassword(userId, userNewPassword);
            return AppResponse.success("成功", flag);
        } else {
            return AppResponse.bizError("密码不一致");
        }
    }
}
