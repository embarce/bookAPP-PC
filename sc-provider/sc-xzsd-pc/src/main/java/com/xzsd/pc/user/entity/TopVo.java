package com.xzsd.pc.user.entity;

/**
 * @author Embrace
 * @date 2020/4/17 9:41
 */
public class TopVo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 头像路径
     */
    private String userImage;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色
     */
    private String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
