package com.xzsd.app.clientGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/16 11:22
 */
public class ClientGoodsEvaluatesVO {
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 商品等级(0-5表示0-5颗星)
     */
    private String evaluateScore;
    /**
     * 评价时间
     */
    private String createTime;
    /**
     * 评价图片路径
     */
    private String imagePath;

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
