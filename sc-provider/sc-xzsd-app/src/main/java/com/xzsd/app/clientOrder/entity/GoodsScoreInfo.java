package com.xzsd.app.clientOrder.entity;

/**
 * @author Embrace
 * @date 2020/4/28 9:17
 */
public class GoodsScoreInfo {
    /**
     * 商品评价数
     */
    private String goodsCount;
    /**
     * 商品评价等级
     */
    private String goodsSum;

    public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(String goodsSum) {
        this.goodsSum = goodsSum;
    }
}
