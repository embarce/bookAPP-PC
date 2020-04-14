package com.xzsd.pc.province.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.province.dao.ProvinceDao;
import com.xzsd.pc.province.entity.ProvinceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/14 21:52
 */
@Service
public class ProvinceService {
    @Resource
    private ProvinceDao provinceDao;

    public AppResponse findProvince() {
        List<ProvinceInfo> provinceInfos = provinceDao.findProvince();
        if (provinceInfos == null) {
            return AppResponse.bizError("查询省份失败");
        } else {
            return AppResponse.success("查询省份成功", provinceInfos);
        }
    }

    public AppResponse findCityByProvinceId(String pid) {
        List<ProvinceInfo> provinceInfos = provinceDao.findCityByProvinceId(pid);
        if (provinceInfos == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", provinceInfos);
        }
    }
}
