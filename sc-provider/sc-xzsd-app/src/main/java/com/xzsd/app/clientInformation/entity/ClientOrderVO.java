package com.xzsd.app.clientInformation.entity;

import com.xzsd.app.clientOrder.entity.ClientOrderGoodsVO;

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
     * 订单状态 0已下单， 2待取货，4或5已完成（按钮对应的订单状态）
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
     * 总数量
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
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
