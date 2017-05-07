package com.cityview.service;

import java.util.List;

import com.cityview.po.City;

public interface CityService {
	//查询所有省份
	public List<City> findcityList()throws Exception;
	//根据省份查询市区
	public List<City> findprovinceList(City city)throws Exception;
}
