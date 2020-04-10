package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * @author Embrace
 * @date 2020/4/8 10:46
 */
public class OrderDetailsVO {
    /**
     * 订单号
     */
    private String orderId;

    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 定价
     */
    private float price;
    /**
     *售价
     */
    private float salesPrice;
    /**
     * 数量
     */
    private int num;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
