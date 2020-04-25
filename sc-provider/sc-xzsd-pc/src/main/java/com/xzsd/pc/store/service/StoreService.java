package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreDO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/13 16:58
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     *
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo) {
        int count = storeDao.countBusiness(storeInfo.getBusiness());
        int num = storeDao.checkUserId(storeInfo.getUserCode());
        if (count == 0) {
            if (num != 0) {
                //随机一个店铺码
                storeInfo.setStoreCode(StringUtil.getCommonCode(2));
                //随机获取自己一个邀请码
                storeInfo.setInvitation(StringUtil.getCode(2));
                int add = storeDao.addStore(storeInfo);
                if (add != 0) {
                    return AppResponse.success("新增成功");
                } else {
                    return AppResponse.success("新增失败");
                }
            } else {
                return AppResponse.success("用户编码不存在");
            }
        } else {
            return AppResponse.repeat("营业执照已经存在");
        }
    }

    /**
     * 删除门店
     *
     * @param listCode
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String listCode) {
        List<String> storeList = Arrays.asList(listCode.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        int num = storeDao.deleteStore(storeList, userId);
        if (num == 0) {
            return AppResponse.bizError("删除失败");
        } else {
            return AppResponse.success("删除成功");
        }
    }

    /**
     * 修改门店
     *
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        storeInfo.setLastModifiedBy(userId);
        int num = storeDao.updateStore(storeInfo);
        if (num == 0) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 分页查询门店
     *
     * @param storeDO
     * @return
     */
    public AppResponse listStoreByPage(StoreDO storeDO) {
        List<StoreVO> storeVOList = new ArrayList<>();
        int role = Integer.valueOf(storeDO.getRole());
        if (role == 0) {
            storeVOList = storeDao.listStoreByPage(storeDO);
        }
        if (role == 1) {
            String userId = SecurityUtils.getCurrentUserId();
            System.out.println(userId);
            storeDO.setUserCode(userId);
            storeVOList = storeDao.listStoreByPageByUserId(storeDO);
        }
        return AppResponse.success("查询成功", PageUtils.getPageInfo(storeVOList));
    }

    /**
     * 查门店详情
     *
     * @param storeCode
     * @return
     */
    public AppResponse findStoreById(String storeCode) {
        StoreInfo storeInfo = storeDao.findStoreById(storeCode);
        List<StoreInfo> storeInfos = new ArrayList<>();
        storeInfos.add(storeInfo);
        if (storeInfo == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", storeInfos);
        }
    }
}
