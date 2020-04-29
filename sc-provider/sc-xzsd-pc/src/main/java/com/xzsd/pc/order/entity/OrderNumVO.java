package com.xzsd.pc.order.entity;

import java.util.List;

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
    private Integer num;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderNumVO{" +
                "goodsId='" + goodsId + '\'' +
                ", num=" + num +
                '}';
    }
}
