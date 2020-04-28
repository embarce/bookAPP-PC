package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/10 17:03
 */
public class ChoseHotsGoodsVO {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品状态
     */
    private String status;
    /**
     * 一级分类
     */
    private String cateP;
    /**
     * 二级分类
     */
    private String cate;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCateP() {
        return cateP;
    }

    public void setCateP(String cateP) {
        this.cateP = cateP;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}
