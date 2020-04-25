package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.CustomerInfo;
import com.xzsd.pc.user.entity.CustomerVO;
import com.xzsd.pc.user.entity.TopVo;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.getType;

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
            return AppResponse.repeat("用户已存在,请重新输入");
        }
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDeleted(0);
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        //新增用户
        int count = userDao.addUser(userInfo);
        int role=Integer.valueOf(userInfo.getRole());
        if (role == 3) {
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
        //加密密码
        userInfo.setUserPwd(PasswordUtils.generatePassword(userInfo.getUserPwd()));
        //修改
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败请检查数据");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询客户
     * @param customerInfo
     * @return
     */
    public AppResponse listCustomer(CustomerInfo customerInfo){
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerVO> customerList;
        System.out.println(customerInfo.getRole());
        int role=Integer.valueOf(customerInfo.getRole());
        if(role==1){
            System.out.println("店长");
            customerInfo.setUserCode(SecurityUtils.getCurrentUserId());
            customerList=userDao.listCustomerByRole(customerInfo);
        }
        else if(role==0){
            System.out.println("管理员");
            customerList= userDao.listCustomer(customerInfo);
        }else {
            return AppResponse.success("你无权访问");
        }
        // 包装Page对象
        PageInfo<CustomerVO> pageData = new PageInfo<CustomerVO>(customerList);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * 顶部栏
     * @return
     */
    public AppResponse getTopOfColumn(){
        TopVo topVo=userDao.getTopOfColumn(SecurityUtils.getCurrentUserId());
        if(topVo==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",topVo);
        }
    }
}
