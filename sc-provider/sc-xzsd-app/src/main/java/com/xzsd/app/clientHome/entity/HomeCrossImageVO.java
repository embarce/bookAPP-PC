package com.xzsd.app.clientHome.entity;

/**
 * @author Embrace
 * @date 2020/4/16 9:57
 */
public class HomeCrossImageVO {
    /**
     * 轮播图片路径
     */
    private String slideshowPath;
    /**
     * 商品编号
     */
    private String goodsId;

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
