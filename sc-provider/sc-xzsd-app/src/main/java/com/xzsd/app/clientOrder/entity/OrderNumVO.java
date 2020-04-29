package com.xzsd.app.clientOrder.entity;

/**
 * @author Embrace
 * @date 2020/4/29 11:07
 */
public class OrderNumVO {
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 数量
     */
    private int num;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
