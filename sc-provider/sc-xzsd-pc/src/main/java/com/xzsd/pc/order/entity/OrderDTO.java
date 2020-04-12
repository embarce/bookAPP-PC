package com.xzsd.pc.order.entity;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/12 16:09
 */
public class OrderDTO {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 版本号
     */
    private String version;
    /**
     * 订单状态；订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     */
    private String orderStatus;
    /**
     * 跟新者
     */
    private String lastModifiedBy;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
