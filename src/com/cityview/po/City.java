package com.cityview.po;

public class City {
    private Integer id;

    private Integer parentId;

    private String cityname;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
	 * @return the cityname
	 */
	public String getCityname() {
		return cityname;
	}

	/**
	 * @param cityname the cityname to set
	 */
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}