package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/20 11:07
 */
public class ClientOrderVO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 商品信息
     */
    private List<ClientOrderGoodsVO> goodsList;
    /**
     * 总价
     */
    private String orderAllCost;
    /**
     * 数量
     */
    private String orderAllGoodsCount;
    /**
     * 版本号
     */
    private String version;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 地址
     */
    private String address;
    /**
     * 创建时间
     */
    private String crateTime;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public List<ClientOrderGoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ClientOrderGoodsVO> goodsList) {
        this.goodsList = goodsList;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(String orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
