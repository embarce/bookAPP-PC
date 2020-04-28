package com.xzsd.app.clientOrder.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/4/21 9:05
 */
public class GoodsEvaluateInfo {
    /**
     * 评价id
     */
    private int appraiseId;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 评价list
     */
    private List<EvaluateInfo> evaluateInfos;
    /**
     * 是否删除
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(int appraiseId) {
        this.appraiseId = appraiseId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<EvaluateInfo> getEvaluateInfos() {
        return evaluateInfos;
    }

    public void setEvaluateInfos(List<EvaluateInfo> evaluateInfos) {
        this.evaluateInfos = evaluateInfos;
    }
}
