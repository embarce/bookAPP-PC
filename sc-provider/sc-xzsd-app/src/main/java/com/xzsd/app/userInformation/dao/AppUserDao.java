package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.AppUserInfoVO;
import com.xzsd.app.userInformation.entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppUserDao {
    int getUserRole(@Param("userId") String userId);

    AppUserInfoVO getUserIsCustomer(@Param("userId") String userId);

    AppUserInfoVO getUserIsOwner(@Param("userId") String userId);

    AppUserInfoVO getUserIsDriver(@Param("userId") String userId);

    String getPassword(@Param("userId") String userId);

    int updateUserPassword(@Param("userId") String userId,@Param("userNewPassword") String userNewPassword);
}
