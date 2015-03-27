package com.ai.psims.web.model;

import java.util.Date;

public class UserToMenu {
    private Integer user2menuId;

    private String userId;

    private String menuId;

    private String user2menuStatus;

    private String remark;

    private Date createtime;

    private Date modifytime;

    private Date endtime;

    public Integer getUser2menuId() {
        return user2menuId;
    }

    public void setUser2menuId(Integer user2menuId) {
        this.user2menuId = user2menuId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getUser2menuStatus() {
        return user2menuStatus;
    }

    public void setUser2menuStatus(String user2menuStatus) {
        this.user2menuStatus = user2menuStatus == null ? null : user2menuStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}