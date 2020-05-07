package com.xzsd.app.clientOrder.entity;

import java.util.Date;

/**
 * @author Embrace
 * @date 2020/4/6 21:22
 */
public class OrderInfo {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 价格
     */
    private float price;
    /**
     * 付款时间
     */
    private String payTime;
    private String payTime2;
    /**
     * 订单状态；订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     */
    private int orderStatus;
    /**
     * 收货校边店id
     */
    private String receiverNo;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 下单人
     */
    private String shippingUser;
    /**
     * 门店id
     */
    private String storeId;
    /**
     * 商品list
     */
    private String goodsIdList;
    /**
     * 商品价格list
     */
    private String goodsPriceList;
    /**
     * 数量list
     */
    private String goodsNumList;
    /**
     * 电话
     */
    private String phone;
    private double unitPrice;
    private int num;
    private int goodsNum;
    private String isShopping;

    public String getIsShopping() {
        return isShopping;
    }

    public void setIsShopping(String isShopping) {
        this.isShopping = isShopping;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(String goodsIdList) {
        this.goodsIdList = goodsIdList;
    }

    public String getGoodsPriceList() {
        return goodsPriceList;
    }

    public void setGoodsPriceList(String goodsPriceList) {
        this.goodsPriceList = goodsPriceList;
    }

    public String getGoodsNumList() {
        return goodsNumList;
    }

    public void setGoodsNumList(String goodsNumList) {
        this.goodsNumList = goodsNumList;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShippingUser() {
        return shippingUser;
    }

    public void setShippingUser(String shippingUser) {
        this.shippingUser = shippingUser;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayTime2() {
        return payTime2;
    }

    public void setPayTime2(String payTime2) {
        this.payTime2 = payTime2;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(String receiverNo) {
        this.receiverNo = receiverNo;
    }
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
