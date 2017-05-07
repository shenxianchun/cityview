package com.cityview.po;

import java.util.Date;

public class Monthweather {
    private Integer id;

    private String cityname;

    private String date;

    private String maxtemperature;

    private String mintemperature;

    private String weather;

    private String direction;

    private String power;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getMaxtemperature() {
        return maxtemperature;
    }

    public void setMaxtemperature(String maxtemperature) {
        this.maxtemperature = maxtemperature == null ? null : maxtemperature.trim();
    }

    public String getMintemperature() {
        return mintemperature;
    }

    public void setMintemperature(String mintemperature) {
        this.mintemperature = mintemperature == null ? null : mintemperature.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}