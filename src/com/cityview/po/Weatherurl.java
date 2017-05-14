package com.cityview.po;

import java.util.Date;

public class Weatherurl {
    private Integer id;

    private String cityurl;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityurl() {
        return cityurl;
    }

    public void setCityurl(String cityurl) {
        this.cityurl = cityurl == null ? null : cityurl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}