package com.xzsd.pc.carouselPicture.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.carouselPicture.dao.CarouserlDao;
import com.xzsd.pc.carouselPicture.entity.CarouserlInfo;
import com.xzsd.pc.carouselPicture.entity.CarouserlListVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/3/27 10:56
 */
@Service
public class CarouserlService {
    @Resource
    private CarouserlDao carouserlDao;

    /**
     * 新增轮播图
     * @param carouserlInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCarouserl(CarouserlInfo carouserlInfo){
        carouserlInfo.setBannerCode(StringUtil.getCommonCode(2));
        carouserlInfo.setIsDeleted(0);
        carouserlInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        int num=carouserlDao.countCarouserlById(carouserlInfo.getSortNo());
        if(num==0){
            //新增
            int count=carouserlDao.addCarouserl(carouserlInfo);
            if(0==count){
                return AppResponse.bizError("新增失败，请重试");
            }
            return AppResponse.success("新增成功");
        }
      else {
          return AppResponse.repeat("序号存在");
        }
    }

    /**
     * 删除轮播图
     * @param listString
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCarouserl(String listString){
        String lastModifiedBy=SecurityUtils.getCurrentUserId();
        List<String> listCode = Arrays.asList(listString.split(","));
        int count=carouserlDao.deleteCarouserl(listCode,lastModifiedBy);
        if(0==count){
            return AppResponse.bizError("删除失败，请重试");
        }
        return AppResponse.success("删除成功");
    }

    /**
     * 分页查询轮播图
     * @param carouserlInfo
     * @return
     */
    public AppResponse carouserlListByPage(CarouserlInfo carouserlInfo){
        PageHelper.startPage(carouserlInfo.getPageNum(), carouserlInfo.getPageSize());
        List<CarouserlListVo> carouserlList = carouserlDao.carouserlListByPage(carouserlInfo);
        // 包装Page对象
        PageInfo<CarouserlListVo> pageData = new PageInfo<CarouserlListVo>(carouserlList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 轮播图状态修改
     * @param listString
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStatusOpen(String listString){
        String lastModifiedBy=SecurityUtils.getCurrentUserId();
        System.out.println(lastModifiedBy);
        List<String> listCode = Arrays.asList(listString.split(","));
        int count=carouserlDao.updateStatusOpen(listCode,lastModifiedBy);
        if(0==count){
            return AppResponse.bizError("启用失败，请重试");
        }
        return AppResponse.success("启用成功");
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStatusOff(String listString){
        String lastModifiedBy=SecurityUtils.getCurrentUserId();
        List<String> listCode = Arrays.asList(listString.split(","));
        int count=carouserlDao.updateStatusOff(listCode,lastModifiedBy);
        if(0==count){
            return AppResponse.bizError("禁用失败，请重试");
        }
        return AppResponse.success("禁用成功");
    }
}
