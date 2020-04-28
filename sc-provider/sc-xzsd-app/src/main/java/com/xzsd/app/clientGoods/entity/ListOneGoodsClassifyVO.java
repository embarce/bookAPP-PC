package com.xzsd.app.clientGoods.entity;

/**
 * @author Embrace
 * @date 2020/4/16 15:14
 */
public class ListOneGoodsClassifyVO {
    /**
     * 一级商品分类编号
     */
    private String classifyId;
    /**
     * 一级商品分类名称
     */
    private String classifyName;

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
}
