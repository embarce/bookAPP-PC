package com.xzsd.app.clientOrder.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/6 21:23
 */
@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;

    /**
     * 新增订单
     *
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo) {
        int storeId=Integer.valueOf(orderInfo.getStoreId());
        if(storeId==0){
            return AppResponse.bizError("没有绑定邀请码，请前往绑定邀请码");
        }
        orderInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        String orderId = StringUtil.getCommonCode(2);
        orderInfo.setOrderId(orderId);
        List<String> goodsId = Arrays.asList(orderInfo.getGoodsIdList().split(","));
        List<String> goodsPrice = Arrays.asList(orderInfo.getGoodsPriceList().split(","));
        List<String> goodsNum = Arrays.asList(orderInfo.getGoodsNumList().split(","));
        List<OrderDetailsVO> orderInfoList = new ArrayList<>();
        orderInfo.setUserId(SecurityUtils.getCurrentUserId());
        orderInfo.setShippingUser(SecurityUtils.getCurrentUserId());
        float sum = 0;
        int goodsNumSum = 0;
        for (int i = 0; i < goodsId.size(); i++) {
            OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
            orderDetailsVO.setUserId(SecurityUtils.getCurrentUserId());
            orderDetailsVO.setOrderId(orderId);
            orderDetailsVO.setGoodsId(goodsId.get(i));
            float a = new Float(goodsPrice.get(i));
            int b = new Integer(goodsNum.get(i));
            orderDetailsVO.setPrice(new Float(goodsPrice.get(i)));
            orderDetailsVO.setNum(new Integer(goodsNum.get(i)));
            orderInfoList.add(orderDetailsVO);
            goodsNumSum = goodsNumSum + b;
            sum = sum + (a * b);
        }
        //检查库存
        List<Integer> listGoodsNum = clientOrderDao.chGoodsNum(goodsId);
        List<Integer> listNum = new ArrayList<>();
        List<String> goodsIdList = new ArrayList<>();
        for (int i = 0; i < listGoodsNum.size(); i++) {
            int nowGoodsNum = (new Integer(goodsNum.get(i)));
            if (listGoodsNum.get(i) < nowGoodsNum) {
                listNum.add(i);
            }
            if (listGoodsNum.get(i).intValue() == nowGoodsNum) {
                goodsIdList.add(goodsId.get(i));
            }
        }
        //返回库存不够的商品序号
        if (0 != listNum.size()) {
            return AppResponse.bizError("购买失败，库存不足");
        }
        if (0 != goodsIdList.size()) {
            clientOrderDao.updateGoodsNumByGoodsList(goodsIdList);
        }
        int goods = clientOrderDao.updateGoodsStock(orderInfoList);
        int num = clientOrderDao.addOrderDetail(orderInfoList);
        //清空购物车
        int updateNum=clientOrderDao.updateShoppingCar(goodsId,SecurityUtils.getCurrentUserId());
        orderInfo.setPrice(sum);
        orderInfo.setGoodsNum(goodsNumSum);
        int count = clientOrderDao.addOrder(orderInfo);
        if (num == 0 && count == 0) {
            return AppResponse.bizError("新增失败");
        } else {
            return AppResponse.success("新增成功");
        }
    }

    /**
     * 查询列表
     *
     * @param orderStateId
     * @return
     */
    public AppResponse listOrder(String orderStateId) {
        String userId = SecurityUtils.getCurrentUserId();
        List<ClientOrderVO> clientOrderVOS = clientOrderDao.listOrder(orderStateId, userId);
        return AppResponse.success("查询成功", clientOrderVOS);
    }

    /**
     * 修改订单
     *
     * @param orderDO
     * @return
     */
    public AppResponse updateOrderState(OrderDO orderDO) {
        orderDO.setUserId(SecurityUtils.getCurrentUserId());
        int num = clientOrderDao.updateOrderState(orderDO);
        if (0 == num) {
            return AppResponse.bizError("修改失败");
        } else {
            return AppResponse.success("修改成功");
        }
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    public AppResponse listOrderDeepen(String orderId) {
        ClientOrderVO clientOrderVOS = clientOrderDao.listOrderDeepen(orderId);
        List<ClientOrderGoodsVO> clientOrderGoodsVOS = clientOrderDao.getGoodsByOrderId(orderId);
        clientOrderVOS.setGoodsList(clientOrderGoodsVOS);
        return AppResponse.success("查询成功", clientOrderVOS);
    }

    /**
     * 查询需要评价的商品
     *
     * @param orderId
     * @return
     */
    public AppResponse listGoodsForEvaluate(String orderId) {
        List<ClientOrderGoodsList> clientOrderGoodsList = clientOrderDao.listGoodsForEvaluate(orderId);
        return AppResponse.success("查询成功", clientOrderGoodsList);
    }

    /**
     * 新增评价
     *
     * @param goodsEvaluateInfo
     * @return
     */
    public AppResponse addGoodsEvaluate(GoodsEvaluateInfo goodsEvaluateInfo) {
        List<EvaluateDO> evaluateDOS = new ArrayList<>();
        for (EvaluateInfo evaluateInfo : goodsEvaluateInfo.getEvaluateInfos()) {
            EvaluateDO evaluateDO = new EvaluateDO();
            evaluateDO.setAppraiseId(StringUtil.getCommonCode(2));
            evaluateDO.setGoodsId(evaluateInfo.getGoodsId());
            evaluateDO.setTxt(evaluateInfo.getEvaluateContent());
            evaluateDO.setImage(evaluateInfo.getImageUrlList());
            if (evaluateInfo.getEvaluateScore() == null) {
                evaluateInfo.setEvaluateScore("5");
            }
            evaluateDO.setLevel(evaluateInfo.getEvaluateScore());
            evaluateDO.setOrderId(goodsEvaluateInfo.getOrderId());
            evaluateDO.setUserId(SecurityUtils.getCurrentUserId());
            evaluateDOS.add(evaluateDO);
        }
        int count = clientOrderDao.addGoodsEvaluate(evaluateDOS);
        if (count == 0) {
            return AppResponse.bizError("评价失败");
        } else {
            return AppResponse.success("评价成功");
        }
    }
}
