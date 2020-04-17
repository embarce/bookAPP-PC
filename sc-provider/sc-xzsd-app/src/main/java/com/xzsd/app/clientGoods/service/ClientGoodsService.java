package com.xzsd.app.clientGoods.service;

import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;

import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.ClientGoodsEvaluatesVO;
import com.xzsd.app.clientGoods.entity.ClientGoodsVO;
import com.xzsd.app.clientGoods.entity.EvaluateScoreDo;
import com.xzsd.app.clientGoods.entity.ListOneGoodsClassifyVO;
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

    /**
     * 获取商品详情
     * @param goodsId
     * @return
     */
    public AppResponse getGoods(String goodsId) {
        ClientGoodsVO goodsInfo = clientGoodsDao.getGoods(goodsId);
        if (goodsInfo == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", goodsInfo);
        }
    }

    /**
     * 查指定商品评价
     * @param evaluateScoreDo
     * @return
     */
    public AppResponse getEvaluatesByPage(EvaluateScoreDo evaluateScoreDo) {
        List<ClientGoodsEvaluatesVO> evaluatesVO = clientGoodsDao.getEvaluatesByPage(evaluateScoreDo);
        if (evaluatesVO == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", PageUtils.getPageInfo(evaluatesVO));
        }
    }

    /**
     * 查询一级分类
     * @return
     */
    public AppResponse listGetClassGoods() {
        List<ListOneGoodsClassifyVO> listOneGoodsClassifyVOS = clientGoodsDao.listGetClassGoods();
        if (listOneGoodsClassifyVOS == null) {
            return AppResponse.bizError("查询失败");
        } else {
            return AppResponse.success("查询成功", listOneGoodsClassifyVOS);
        }
    }
}
