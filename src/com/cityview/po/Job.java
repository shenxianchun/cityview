package com.cityview.po;

import java.util.Date;

public class Job {
    private Integer id;

    private String cityname;

    private String name;

    private String company;

    private String joburl;

    private String minprice;

    private String maxprice;
    
    private String monthprice;

    private String location;

    private String education;

    private String scale;

    private String jobnature;

    private String description;

    private String address;

    private String companynature;

    private String joblabel;
    
    private String exp;
    
    private String demand;
    
    private String jobtype;

    private String industry;

    private String releasetime;

    private Date creatTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getJoburl() {
        return joburl;
    }

    public void setJoburl(String joburl) {
        this.joburl = joburl == null ? null : joburl.trim();
    }

    public String getMinprice() {
        return minprice;
    }

    public void setMinprice(String minprice) {
        this.minprice = minprice == null ? null : minprice.trim();
    }

    public String getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(String maxprice) {
        this.maxprice = maxprice == null ? null : maxprice.trim();
    }
    
    /**
	 * @return the monthprice
	 */
	public String getMonthprice() {
		return monthprice;
	}

	/**
	 * @param monthprice the monthprice to set
	 */
	public void setMonthprice(String monthprice) {
		this.monthprice = monthprice;
	}

	public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getJobnature() {
        return jobnature;
    }

    public void setJobnature(String jobnature) {
        this.jobnature = jobnature == null ? null : jobnature.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanynature() {
        return companynature;
    }

    public void setCompanynature(String companynature) {
        this.companynature = companynature == null ? null : companynature.trim();
    }

    public String getJoblabel() {
        return joblabel;
    }

    public void setJoblabel(String joblabel) {
        this.joblabel = joblabel == null ? null : joblabel.trim();
    }

    /**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getIndustry() {
        return industry;
    }
	
    /**
	 * @return the demand
	 */
	public String getDemand() {
		return demand;
	}

	/**
	 * @param demand the demand to set
	 */
	public void setDemand(String demand) {
		this.demand = demand;
	}
	
	/**
	 * @return the jobtype
	 */
	public String getJobtype() {
		return jobtype;
	}

	/**
	 * @param jobtype the jobtype to set
	 */
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

   
    /**
	 * @return the releasetime
	 */
	public String getReleasetime() {
		return releasetime;
	}

	/**
	 * @param releasetime the releasetime to set
	 */
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

	public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}