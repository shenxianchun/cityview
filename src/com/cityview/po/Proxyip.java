package com.cityview.po;

import java.util.Date;

public class Proxyip {
    private Integer id;

    private String ip;

    private String port;

    private String anonymity;

    private String iptype;

    private String support;

    private String position;

    private String responsetime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(String anonymity) {
        this.anonymity = anonymity == null ? null : anonymity.trim();
    }

    public String getIptype() {
        return iptype;
    }

    public void setIptype(String iptype) {
        this.iptype = iptype == null ? null : iptype.trim();
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support == null ? null : support.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(String responsetime) {
        this.responsetime = responsetime == null ? null : responsetime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}