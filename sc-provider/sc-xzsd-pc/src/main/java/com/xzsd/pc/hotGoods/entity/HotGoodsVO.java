package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/9 9:57
 */
public class HotGoodsVO {
    /**
     * 排序
     *
     *
     * 商品编号
     *
     *
     * 商品名称
     *
     *
     * 商品价格
     *
     * 商品介绍
     */
    private int noId;
    private String goodsId;
    private float price;
    private String goodsName;
    private String goodsIntroduction;

    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }
}
