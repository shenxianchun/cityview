package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.AqimonthMapperCustom;
import com.cityview.po.AqimonthCustom;
import com.cityview.po.AqimonthQueryVo;
import com.cityview.service.AqimonthService;

public class AqimonthServiceImpl implements AqimonthService{
	
	@Autowired
	private AqimonthMapperCustom aqimonthMapperCustom;
	
	
	
	public List<AqimonthCustom> findAqimonthList(AqimonthQueryVo aqimonthQueryVo) throws Exception {
		// 查询历史空气质量指数 月全量的数据
		return aqimonthMapperCustom.findAqimonthList(aqimonthQueryVo);
	}
	
}
