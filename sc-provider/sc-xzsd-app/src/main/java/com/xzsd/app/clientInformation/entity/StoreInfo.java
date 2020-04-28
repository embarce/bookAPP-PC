package com.xzsd.app.clientInformation.entity;

/**
 * @author Embrace
 * @date 2020/4/21 16:31
 */
public class StoreInfo {
    /**
     * 门店id
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 电话
     */
    private String phone;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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
}
