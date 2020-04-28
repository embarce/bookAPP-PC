package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/13 9:10
 */
public class HotGoodsDO {
    /**
     * 热门id
     */
    private String hotGoodsId;
    /**
     * 排序
     */
    private int noId;
    /**
     * 商品编号
     */
    private String goodsId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 版本号
     */
    private String version;

    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

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
