package com.xzsd.app.clientHome.entity;

/**
 * @author Embrace
 * @date 2020/4/16 9:56
 */
public class HomeHotGoodsVO {
    /**
     * 商品编号
     * 商品名称
     * 商品图片路径
     * 商品价格
     */
    private String goodsId;
    private String goodsName;
    private String goodsImagePath;
    private String goodsPrice;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
