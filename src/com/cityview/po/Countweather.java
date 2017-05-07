package com.cityview.po;

import java.util.Date;

public class Countweather {
    private Integer id;

    private String cityname;

    private String weatherName;

    private String weatherValue;

    private String directionName;

    private String directionValue;

    private String powerName;

    private String powerValue;

    private String day;

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

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName == null ? null : weatherName.trim();
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String weatherValue) {
        this.weatherValue = weatherValue == null ? null : weatherValue.trim();
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName == null ? null : directionName.trim();
    }

    public String getDirectionValue() {
        return directionValue;
    }

    public void setDirectionValue(String directionValue) {
        this.directionValue = directionValue == null ? null : directionValue.trim();
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }

    public String getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(String powerValue) {
        this.powerValue = powerValue == null ? null : powerValue.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}