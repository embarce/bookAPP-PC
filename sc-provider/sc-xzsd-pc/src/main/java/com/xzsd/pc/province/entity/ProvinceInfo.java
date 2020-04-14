package com.xzsd.pc.province.entity;

/**
 * @author Embrace
 * @date 2020/4/14 21:52
 */
public class ProvinceInfo {
    /**
     * 区域主键
     */
    private String id;
    /**
     * 区域名称
     */
    private String name;
    /**
     * 区域上级标识
     */
    private String pid;
    /**
     * 区域等级
     */
    private int level;
    /**
     * 区域编码
     */
    private String cityCode;
    /**
     * 组合名称
     */
    private String merName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName;
    }
}
