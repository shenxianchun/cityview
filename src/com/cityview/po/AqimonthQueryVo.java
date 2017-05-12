package com.cityview.po;

import java.util.List;

public class AqimonthQueryVo {
	
	private String monthday;

	private List<AqimonthCustom> aqimonthCustoms;
	
	/**
	 * @return the monthday
	 */
	public String getMonthday() {
		return monthday;
	}
	/**
	 * @param monthday the monthday to set
	 */
	public void setMonthday(String monthday) {
		this.monthday = monthday;
	}
	/**
	 * @return the aqimonthCustoms
	 */
	public List<AqimonthCustom> getAqimonthCustoms() {
		return aqimonthCustoms;
	}
	/**
	 * @param aqimonthCustoms the aqimonthCustoms to set
	 */
	public void setAqimonthCustoms(List<AqimonthCustom> aqimonthCustoms) {
		this.aqimonthCustoms = aqimonthCustoms;
	}
	
}
