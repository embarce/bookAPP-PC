package com.xzsd.app.clientOrder.entity;

/**
 * @author Embrace
 * @date 2020/4/20 16:29
 */
public class OrderDO {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 版本号
     */
    private String version;
    /**
     * 用户id
     */
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

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
