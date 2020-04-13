package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Embrace
 * @date 2020/4/13 16:58
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        int count=storeDao.countBusiness(storeInfo.getBusiness());
        int num=storeDao.findStoreByStoreName(storeInfo.getStoreName());
        if(count==0){
            if(num==0){
                storeInfo.setStoreCode(StringUtil.getCommonCode(2));
                int add=storeDao.addStore(storeInfo);
                if(add!=0){
                    return AppResponse.success("新增成功");
                }else {
                    return AppResponse.success("新增失败");
                }
            }else {
                return AppResponse.success("商店名已经存在");
            }
        }else {
            return AppResponse.success("营业执照已经存在");
        }
    }
}
