package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/***
 *
 * @Description :
 * @Author : Embrace
 * @Date :  2020-3-25
 */
@Mapper
public interface RegisterDao {
    /**
     * 查看用户是否存在
     * @param userAcct 用户信息
     * @return
     */
    int countById(@Param("userAcct") String userAcct);

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    int clientRegister(UserInfo userInfo);
    int addCustomer(@Param("userId")String userId);
}
