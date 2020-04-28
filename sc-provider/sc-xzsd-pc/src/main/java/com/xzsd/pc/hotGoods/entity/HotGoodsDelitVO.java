package com.xzsd.pc.hotGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/22 20:40
 */
public class HotGoodsDelitVO {
    /**
     * 热门数
     */
    private String hotGoodsNum;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名
     */
    private String goodsName;
    /**
     * 热门编号
     */
    private String hotGoodsId;
    /**
     * 版本号
     */
    private String version;

    public String getHotGoodsNum() {
        return hotGoodsNum;
    }

    public void setHotGoodsNum(String hotGoodsNum) {
        this.hotGoodsNum = hotGoodsNum;
    }

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

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
