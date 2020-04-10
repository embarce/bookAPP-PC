package com.xzsd.pc.cate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Embrace
 * @date 2020/3/27 16:33
 */
public class CateInfo implements Serializable {
    /**
     * 分类id
     */
    private String cateId;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 父节点
     */
    private String cateIdParent;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 序号
     */
    private int sortNo;
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


    private String remake;

    /**
     * 子类
     * @return
     */
    private List<cateParentInfo> ci;

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public List<cateParentInfo> getCi() {
        return ci;
    }

    public void setCi(List<cateParentInfo> ci) {
        this.ci = ci;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateIdParent() {
        return cateIdParent;
    }

    public void setCateIdParent(String cateIdParent) {
        this.cateIdParent = cateIdParent;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
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

    public CateInfo() {
    }

    @Override
    public String toString() {
        return "CateInfo{" +
                "cateId='" + cateId + '\'' +
                ", cateName='" + cateName + '\'' +
                ", cateIdParent='" + cateIdParent + '\'' +
                ", isDeleted=" + isDeleted +
                ", sortNo=" + sortNo +
                ", gmtCreate=" + gmtCreate +
                ", createBy='" + createBy + '\'' +
                ", gmtModified=" + gmtModified +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
