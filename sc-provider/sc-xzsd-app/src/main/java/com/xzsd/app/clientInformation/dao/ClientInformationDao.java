package com.xzsd.app.clientInformation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientInformationDao {
    /**
     * 修改邀请码
     *
     * @param ind
     * @param userId
     * @return
     */
    int updateClientInvite(@Param("ind") String ind, @Param("userId") String userId);

    /**
     * 检查邀请码
     * @param ind
     * @return
     */
    int countInvite(@Param("ind") String ind);
}
