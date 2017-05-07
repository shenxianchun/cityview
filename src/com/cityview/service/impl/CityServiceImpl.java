package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.CityMapper;
import com.cityview.po.City;
import com.cityview.service.CityService;

public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public List<City> findcityList() throws Exception {
		//通过cityMapper查询数据库
		return cityMapper.findcityList();
	}

	@Override
	public List<City> findprovinceList(City cityname) throws Exception {
		//通过cityMapper查询数据库
		return cityMapper.findprovinceList(cityname);
	}

}
