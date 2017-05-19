package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.FoodMapper;
import com.cityview.po.Food;
import com.cityview.service.FoodService;

public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodMapper	foodMapper;
	
	@Override
	public void insertFood(List<Food> foods) throws Exception {
		// TODO Auto-generated method stub
		foodMapper.insertFood(foods);
	}

	@Override
	public int findFoodcity(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.findFoodcity(cityname);
	}

	@Override
	public List<Food> findFoodAll(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return foodMapper.findFoodAll(cityname);
	}

}
