package com.xzsd.app.clientOrder.entity;

/**
 * @author Embrace
 * @date 2020/4/21 10:02
 */
public class EvaluateInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价等级
     */
    private String evaluateScore;
    /**
     * 图片路径
     */
    private String imageUrlList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(String evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(String imageUrlList) {
        this.imageUrlList = imageUrlList;
    }
}
