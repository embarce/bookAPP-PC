package com.xzsd.app.clientGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/28 9:17
 */
public class GoodsScoreInfo {
    /**
     * 商品评价数
     * 商品评价等级
     */
    private String	goodsCount;
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
