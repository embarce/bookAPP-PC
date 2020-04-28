package com.xzsd.app.clientShopCart.entity;

/**
 * @author Embrace
 * @date 2020/4/19 22:26
 */
public class ShopCartVO {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 图片路径
     */
    private String goodsImagePath;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 数量
     */
    private String cartGoodsCount;
    /**
     * 购物车id
     */
    private String shopCartId;

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

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(String cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(String shopCartId) {
        this.shopCartId = shopCartId;
    }
}
