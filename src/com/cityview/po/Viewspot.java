package com.cityview.po;

import java.util.Date;

public class Viewspot {
    private Integer id;

    private String cityname;

    private String title;

    private String peoplenum;
    
    private String viewurl;
    
    private String imageurl;

    private String price;

    private Date createTime;

    private String introduction;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum == null ? null : peoplenum.trim();
    }
    
    /**
	 * @return the viewurl
	 */
	public String getViewurl() {
		return viewurl;
	}

	/**
	 * @param viewurl the viewurl to set
	 */
	public void setViewurl(String viewurl) {
		this.viewurl = viewurl;
	}

	public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

   
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}