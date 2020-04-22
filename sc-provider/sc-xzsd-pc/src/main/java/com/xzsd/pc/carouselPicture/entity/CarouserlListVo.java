package com.xzsd.pc.carouselPicture.entity;

/**
 * @author Embrace
 * @date 2020/3/27 15:37
 */
public class CarouserlListVo{
    private String goodsId;
    /**
     * 轮播图状态
     */
    private String status;
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 有效期
     */
    private String startTime;
    /**
     * 截止日期
     */
    private  String endTime;
    /**
     * 序号
     */
    private int sortNo;
    private String bannerCode;
    private int version;

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }
}
