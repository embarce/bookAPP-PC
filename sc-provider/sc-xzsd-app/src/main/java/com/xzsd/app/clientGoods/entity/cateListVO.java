package com.xzsd.app.clientGoods.entity;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/19 17:26
 */
public class cateListVO {
    /**
     * 节点头id
     */
    private String id;
    /**
     * 分类名称
     */
    private String classify;
    /**
     * 商品信息
     */
    private List<goodsCateVO> goodsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public List<goodsCateVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<goodsCateVO> goodsList) {
        this.goodsList = goodsList;
    }
}
