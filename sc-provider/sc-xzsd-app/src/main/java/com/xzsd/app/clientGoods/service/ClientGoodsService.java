package com.xzsd.app.clientGoods.service;

import com.neusoft.core.restful.AppResponse;

import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.ClientGoodsEvaluatesVO;
import com.xzsd.app.clientGoods.entity.ClientGoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/16 9:40
 */
@Service
public class ClientGoodsService {
    @Resource
    private ClientGoodsDao clientGoodsDao;
    public AppResponse getGoods(String goodsId){
        ClientGoodsVO goodsInfo=clientGoodsDao.getGoods(goodsId);
        if(goodsInfo==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",goodsInfo);
        }
    }
    public AppResponse getEvaluates(String goodsId){
        ClientGoodsEvaluatesVO evaluatesVO=clientGoodsDao.getEvaluates(goodsId);
        if(evaluatesVO==null){
            return AppResponse.bizError("查询失败");
        }else {
            return AppResponse.success("查询成功",evaluatesVO);
        }
    }
}
