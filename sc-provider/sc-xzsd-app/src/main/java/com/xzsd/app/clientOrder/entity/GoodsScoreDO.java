package com.xzsd.app.clientOrder.entity;

/**
 * @author Embrace
 * @date 2020/4/28 14:56
 */
public class GoodsScoreDO {
    /**
     * 平均分
     */
    private float Score;
    /**
     * 商品id
     */
    private String goodsId;

    public float getScore() {
        return Score;
    }

    public void setScore(float score) {
        Score = score;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
