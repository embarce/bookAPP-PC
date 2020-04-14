package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.CustomerInfo;
import com.xzsd.pc.user.entity.CustomerVO;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/3/26 11:22
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

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
        int countUserById = userDao.countUserById(userInfo.getUserAcct());
        if (0 != countUserById) {
            return AppResponse.bizError("用户已存在,请重新输入");
        }
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        //新增用户
        int count = userDao.addUser(userInfo);
        if (userInfo.getRole() == 3) {
            userDao.addCustomer(userInfo.getUserId());
        }
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功");
    }

    /***
     * 批量删除用户
     * @ClassName
     * @Description : 功能说明
     *
     * @param userList
     * @Return :
     * @Author : Embrace
     * @Date :  2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userList) {
        List<String> listCode = Arrays.asList(userList.split(","));
        int count = userDao.deleteUser(listCode, SecurityUtils.getCurrentUserId());
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /***
     * 分页查询用户信息
     * @ClassName
     * @Description : 功能说明
     *
     * @param userInfo
     * @Return :
     * @Author : Embrace
     * @Date : 2020-3-26
     */
    public AppResponse listUserByPage(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUserByPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 查询用户详情
     *
     * @param userAcct
     * @return
     */
    public AppResponse getUserById(String userAcct) {
        UserInfo userInfo = userDao.getUserById(userAcct);
        return AppResponse.success("查询成功", userInfo);
    }

    /**
     * @param : String userAcct,UserInfo userInfo
     * @ClassName
     * @Description : 修改用户信息
     * @Return : AppResponse
     * @Author : Embrace
     * @Date : 2020-3-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //修改
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改成功，刷新页面");
            return appResponse;
        }
        return appResponse;
    }
    public AppResponse listCustomer(CustomerInfo customerInfo){
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerVO> customerList = userDao.listCustomer(customerInfo);
        // 包装Page对象
        PageInfo<CustomerVO> pageData = new PageInfo<CustomerVO>(customerList);
        return AppResponse.success("查询成功",pageData);
    }
}
