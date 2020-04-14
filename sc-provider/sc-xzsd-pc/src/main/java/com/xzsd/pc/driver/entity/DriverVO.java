package com.xzsd.pc.driver.entity;

/**
 * @author Embrace
 * @date 2020/4/14 11:10
 */
public class DriverVO {
    /**
     * 司机账号
     */
    private String driverAcct;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String IdCard;
    /**
     * 司机id
     */
    private String driverCode;
    /**
     * 版本号
     */
    private String version;
    private String version1;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion1() {
        return version1;
    }

    public void setVersion1(String version1) {
        this.version1 = version1;
    }

    public String getDriverAcct() {
        return driverAcct;
    }

    public void setDriverAcct(String driverAcct) {
        this.driverAcct = driverAcct;
    }
}
