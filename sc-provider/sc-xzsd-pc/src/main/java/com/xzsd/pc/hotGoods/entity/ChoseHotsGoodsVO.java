package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/10 17:03
 */
public class ChoseHotsGoodsVO {
    /**
     * 商品编号
     *
     *
     * 商品名称
     *
     *
     * 商品状态
     *
     *
     * 一级分类
     *
     *
     * 二级分类
     */

    private String goodsId;
    private String goodsName;
    private String status;
    private String cateP;
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
