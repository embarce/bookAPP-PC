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
        //验证邀请码是否有绑定
        if (orderInfo.getStoreId().equals("0")) {
            return AppResponse.bizError("没有绑定邀请码，请前往绑定邀请码");
        }
        orderInfo.setCreateBy(SecurityUtils.getCurrentUserId());
        String orderId = StringUtil.getCommonCode(2);
        orderInfo.setOrderId(orderId);
        //拆分数据
        List<String> goodsId = Arrays.asList(orderInfo.getGoodsIdList().split(","));
        List<String> goodsPrice = Arrays.asList(orderInfo.getGoodsPriceList().split(","));
        List<String> goodsNum = Arrays.asList(orderInfo.getGoodsNumList().split(","));
        List<OrderDetailsVO> orderInfoList = new ArrayList<>();
        orderInfo.setUserId(SecurityUtils.getCurrentUserId());
        orderInfo.setShippingUser(SecurityUtils.getCurrentUserId());
        //封装到订单类且统计价格
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
        if ("1".equals(orderInfo.getIsShopping())) {
            //清空购物车
            int updateNum = clientOrderDao.updateShoppingCar(goodsId, SecurityUtils.getCurrentUserId());
        }
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
        List<ClientOrderVO> clientOrderVOS =new ArrayList<>();
        //判断是不是传已完成的值来，是就调用已完成的接口，因为4和5都是已完成
        boolean orderState="5".equals(orderStateId);
        System.out.println(orderState);
        if(orderState==true){
            clientOrderVOS=clientOrderDao.listOrders(userId);
        }else {
            clientOrderVOS = clientOrderDao.listOrder(orderStateId, userId);
        }
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
        int state = Integer.valueOf(orderDO.getOrderStateId());
        if (1 == state) {
            //库存返回
            List<OrderNumVO> orderNumVOS = clientOrderDao.getGoodsNumByOrderId(orderDO.getOrderId());
            clientOrderDao.updateGoodsByGoodsId(orderNumVOS);
        }
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
        List<String> goodsList = new ArrayList<>();
        //封装评价
        for (EvaluateInfo evaluateInfo : goodsEvaluateInfo.getEvaluateInfos()) {
            EvaluateDO evaluateDO = new EvaluateDO();
            evaluateDO.setAppraiseId(StringUtil.getCommonCode(2));
            evaluateDO.setGoodsId(evaluateInfo.getGoodsId());
            //封装商品id
            goodsList.add(evaluateInfo.getGoodsId());
            evaluateDO.setTxt(evaluateInfo.getEvaluateContent());
            evaluateDO.setImage(evaluateInfo.getImageUrlList());
            //默认好评
            if (evaluateInfo.getEvaluateScore() == null) {
                evaluateInfo.setEvaluateScore("5");
            }
            evaluateDO.setLevel(evaluateInfo.getEvaluateScore());
            evaluateDO.setOrderId(goodsEvaluateInfo.getOrderId());
            evaluateDO.setUserId(SecurityUtils.getCurrentUserId());
            evaluateDOS.add(evaluateDO);
        }
        int count = clientOrderDao.addGoodsEvaluate(evaluateDOS);
        List<GoodsScoreInfo> goodsScoreInfoList = clientOrderDao.getGoodsCountByGoodsId(goodsList);
        List<Float> Score = new ArrayList<>();
        //封装评价等级
        for (GoodsScoreInfo scoreInfo : goodsScoreInfoList) {
            int goodsNum = Integer.valueOf(scoreInfo.getGoodsCount());
            int goodsSumNum = Integer.valueOf(scoreInfo.getGoodsSum());
            Score.add((float) (goodsSumNum / goodsNum));
        }
        List<GoodsScoreDO> goodsScoreDOList = new ArrayList<>();
        for (int i = 0; i < goodsList.size(); i++) {
            GoodsScoreDO goodsScoreDO = new GoodsScoreDO();
            goodsScoreDO.setGoodsId(goodsList.get(i));
            goodsScoreDO.setScore(Score.get(i));
            goodsScoreDOList.add(goodsScoreDO);
        }
        //跟新评分
        int num = clientOrderDao.updateGoodsScore(goodsScoreDOList);
        clientOrderDao.updateOrderStateForEve(goodsEvaluateInfo.getOrderId());
        if (count == 0) {
            return AppResponse.bizError("评价失败");
        } else {
            return AppResponse.success("评价成功");
        }
    }
}
