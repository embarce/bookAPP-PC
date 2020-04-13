package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/13 9:10
 */
public class HotGoodsDO {
    private String hotGoodsId;
    private int hotGoodsSort;
    private String goodsId;
    private String userId;
    private String version;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public int getHotGoodsSort() {
        return hotGoodsSort;
    }

    public void setHotGoodsSort(int hotGoodsSort) {
        this.hotGoodsSort = hotGoodsSort;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
