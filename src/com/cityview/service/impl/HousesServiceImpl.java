package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.HousesMapper;
import com.cityview.po.Houses;
import com.cityview.service.HousesService;

public class HousesServiceImpl implements HousesService {
	@Autowired
	private HousesMapper housesMapper;
	
	@Override
	public void insertHouseslist(List<Houses> houses) throws Exception {
		// TODO Auto-generated method stub
		housesMapper.insertHouseslist(houses);
	}

	@Override
	public List<Houses> findFaceprice(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return housesMapper.findFaceprice(cityname);
	}

	@Override
	public List<Houses> findFaceRenovation(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return housesMapper.findFaceRenovation(cityname);
	}

	@Override
	public List<Houses> findAgencytotal(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return housesMapper.findAgencytotal(cityname);
	}

	@Override
	public List<Houses> findAreaPrice(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return housesMapper.findAreaPrice(cityname);
	}

	@Override
	public List<Houses> findTypePrice(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return housesMapper.findTypePrice(cityname);
	}

}
