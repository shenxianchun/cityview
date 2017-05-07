package com.cityview.po;

import java.util.Date;

/**
* <p>Title: Aqiday.java<／p>
* <p>Description:空气质量指数每月日全量 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月26日
* @version 1.0cityview
*/
public class Aqiday {
    private Integer id;

    private String cityname;

    private String aiq;

    private String average;

    private String minaqi;

    private String maxaqi;

    private String grade;

    private String pm;

    private String pmo;

    private String so;

    private String co;

    private String no;

    private String o;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getAiq() {
        return aiq;
    }

    public void setAiq(String aiq) {
        this.aiq = aiq == null ? null : aiq.trim();
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average == null ? null : average.trim();
    }

    public String getMinaqi() {
        return minaqi;
    }

    public void setMinaqi(String minaqi) {
        this.minaqi = minaqi == null ? null : minaqi.trim();
    }

    public String getMaxaqi() {
        return maxaqi;
    }

    public void setMaxaqi(String maxaqi) {
        this.maxaqi = maxaqi == null ? null : maxaqi.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm == null ? null : pm.trim();
    }

    public String getPmo() {
        return pmo;
    }

    public void setPmo(String pmo) {
        this.pmo = pmo == null ? null : pmo.trim();
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so == null ? null : so.trim();
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co == null ? null : co.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o == null ? null : o.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}