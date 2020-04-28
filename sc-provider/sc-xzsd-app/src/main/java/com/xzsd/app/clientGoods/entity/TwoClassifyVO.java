package com.xzsd.app.clientGoods.entity;

import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/16 16:50
 */
public class TwoClassifyVO {
    /**
     * 分类id
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 商品信息
     */
    private List<TwoClassifyGoodsVO> goodsList;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<TwoClassifyGoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<TwoClassifyGoodsVO> goodsList) {
        this.goodsList = goodsList;
    }
}
