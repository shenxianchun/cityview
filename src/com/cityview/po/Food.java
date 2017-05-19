package com.cityview.po;

import java.util.Date;

public class Food {
    private Integer id;

    private String cityname;

    private String title;

    private String heat;
    
    private String foodurl;

    private String imageurl;

    private String introduction;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat == null ? null : heat.trim();
    }
    
    
    /**
	 * @return the foodurl
	 */
	public String getFoodurl() {
		return foodurl;
	}

	/**
	 * @param foodurl the foodurl to set
	 */
	public void setFoodurl(String foodurl) {
		this.foodurl = foodurl;
	}

	public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}