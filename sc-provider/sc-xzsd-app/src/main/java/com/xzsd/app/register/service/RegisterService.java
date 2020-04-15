package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/3/26 11:22
 */
@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;

    /***
     * 新增用户
     * @ClassName
     * @Description : 功能说明
     *
     * @param userInfo
     * @Return :
     * @Author : Embrace
     * @Date : 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo) {
        //检查用户是否存在
        int countUserById = registerDao.countUserById(userInfo.getUserAcct());
        if (0 != countUserById) {
            return AppResponse.repeat("用户已存在,请重新输入");
        }
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        //新增用户
        int count = registerDao.clientRegister(userInfo);
        int num=registerDao.addCustomer(userInfo.getUserId());
        if (0 == count||0==num) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }
}
