package com.xzsd.app.clientGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/16 16:21
 */
public class EvaluateScoreDo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价等级
     */
    private String evaluateScore;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }
}
