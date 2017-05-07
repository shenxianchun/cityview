package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.AqimonthMapper;
import com.cityview.po.Aqimonth;
import com.cityview.service.AqimonthService;

public class AqimonthServiceImpl implements AqimonthService{
	
	@Autowired
	private AqimonthMapper aqimonthMapperCustom;
	
	
	
	public List<Aqimonth> findAqimonthList(Aqimonth aqimonth) throws Exception {
		// 查询历史空气质量指数 月全量的数据
		return aqimonthMapperCustom.findAqimonthList(aqimonth);
	}
	
}
