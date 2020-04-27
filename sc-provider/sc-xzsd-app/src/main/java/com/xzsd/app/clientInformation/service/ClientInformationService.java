package com.xzsd.app.clientInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientInformation.dao.ClientInformationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Embrace
 * @date 2020/4/20 22:52
 */
@Service
public class ClientInformationService {
    @Resource
    private ClientInformationDao clientInformationDao;

    /**
     * 修改邀请码
     *
     * @param inviteCode
     * @return
     */
    public AppResponse updateClientInvite(String inviteCode) {
        int count=clientInformationDao.countInvite(inviteCode);
        if(count==0){
            return AppResponse.success("邀请码不存在");
        }else{
            clientInformationDao.updateClientInvite(inviteCode, SecurityUtils.getCurrentUserId());
            return AppResponse.success("修改成功");
        }
    }
}
