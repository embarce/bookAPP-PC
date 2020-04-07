package com.xzsd.pc.cate.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.cate.dao.CateDao;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.entity.cateParentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/3/27 16:33
 */
@Service
public class CateService {
    @Resource
    private CateDao cateDao;
//    @Resource
//    private ProducerController producerController;

    /**
     * 新增分类
     * @param cateInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCate(CateInfo cateInfo){
        cateInfo.setCateId(StringUtil.getCommonCode(2));
        cateInfo.setIsDeleted(0);
        cateInfo.setCreateBy("1");
        int num=cateDao.countCateByName(cateInfo.getCateName());
//        producerController.sendQueue(cateInfo);
        //新增
        if(num==0){
            int count=cateDao.addCate(cateInfo);
            if(0==count){
                return AppResponse.bizError("新增失败，请重试");
            }
            return AppResponse.success("新增成功");
        }
        else {
            return AppResponse.success("分类已存在");
        }
    }

    /**
     * 查询分类列表
     * @return
     */
    public AppResponse getCate(){
        List<CateInfo> infos=cateDao.getCate();
        for (CateInfo cateP : infos) {
           List<cateParentInfo> cateInfoList=cateDao.findCateById(cateP.getCateId());
           cateP.setCi(cateInfoList);
        }

        return AppResponse.success("get",infos);
    }

    /**
     * 删除分类
     * @param cateId
     * @return
     */
    public AppResponse delectCateById(String cateId){
        int count=cateDao.chekChiById(cateId);
        String lastModifiedBy="embrace";
        if(count==0){
            int num=cateDao.delectCateById(cateId,lastModifiedBy);
            if(num>0){
                return AppResponse.success("删除成功");
            }
            else {
                return AppResponse.bizError("删除失败");
            }
        }else {
            return AppResponse.bizError("存在子类，删除失败");
        }
    }
    public AppResponse updateCateById(CateInfo cateInfo){
        cateInfo.setLastModifiedBy("embrace");
        int count=cateDao.updateCateById(cateInfo);
        if(count==0){
            return AppResponse.bizError("修改失败");
        }
        else {
            return AppResponse.success("修改成功");
        }
    }
}
