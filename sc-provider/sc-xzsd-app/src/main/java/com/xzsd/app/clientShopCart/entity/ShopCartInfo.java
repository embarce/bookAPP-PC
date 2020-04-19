package com.xzsd.app.clientShopCart.entity;

/**
 * @author Embrace
 * @date 2020/4/19 21:18
 */
public class ShopCartInfo {
    /**
     * 用户id
     */
    private String userCode;
    /**
     * 店铺邀请码
     */
    private String invitation;
    /**
     * 店铺名称
     */
    private String storeName;
    /**
     * 数量
     */
    private String cnt;
    private String sortNo;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 购物车编号
     */
    private String shoppingCartCode;
    private String createTime;
    private String changeName;
    private String isDelete;
    private String changeTime;
    private String version;
    private String createName;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getShoppingCartCode() {
        return shoppingCartCode;
    }

    public void setShoppingCartCode(String shoppingCartCode) {
        this.shoppingCartCode = shoppingCartCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}
