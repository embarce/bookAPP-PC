package com.xzsd.pc.order.entity;

/**
 * @author Embrace
 * @date 2020/4/8 9:05
 */
public class OrderVO {
    /**
     * 订单号
     */
    private String orderId;

    /**
     * 总价
     */
    private float price;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 收货人
     */
    private String shippingUser;
    /**
     * 付款时间
     */
    private String payTime;
    /**
     * 订单状态；订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     */
    private int orderStatus;
    /**
     * 收货校边店id
     */
    private String receiverNo;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
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
}
