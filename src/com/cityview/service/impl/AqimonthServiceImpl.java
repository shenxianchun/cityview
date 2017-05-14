package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cityview.mapper.AqimonthMapper;
import com.cityview.po.Aqiday;
import com.cityview.po.AqidayCustom;
import com.cityview.po.Aqimonth;
import com.cityview.po.AqimonthCustom;
import com.cityview.po.AqimonthQueryVo;
import com.cityview.service.AqimonthService;

public class AqimonthServiceImpl implements AqimonthService{
	
	@Autowired
	private AqimonthMapper aqimonthMapper;
	
	
	
	public List<Aqimonth> findAqimonthList(Aqimonth aqimonth) throws Exception {
		// 查询历史空气质量指数 月全量的数据
		return aqimonthMapper.findAqimonthList(aqimonth);
	}



	@Override
	public void insertAqimonthList(List<Aqimonth> aqimonth) throws Exception {
		// TODO Auto-generated method stub
		aqimonthMapper.insertAqimonthList(aqimonth);
	}



	@Override
	public int findAqi(String aqiurl) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findAqi(aqiurl);
	}



	@Override
	public void insertAqidayList(List<Aqiday> aqidays) throws Exception {
		// TODO Auto-generated method stub
		aqimonthMapper.insertAqidayList(aqidays);
	}



	@Override
	public List<Aqiday> findaqidayList(Aqiday aqiday) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findaqidayList(aqiday);
	}



	@Override
	public List<AqidayCustom> findCountGrade(Aqiday aqiday) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findCountGrade(aqiday);
	}



	@Override
	public List<AqimonthQueryVo> findAqiMonthCountGrade(AqimonthCustom aqimonthCustom) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findAqiMonthCountGrade(aqimonthCustom);
	}



	@Override
	public List<AqidayCustom> findCountGradeDay(Aqiday aqiday) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findCountGradeDay(aqiday);
	}



	@Override
	public List<AqimonthCustom> findCountGradeMonth(Aqimonth aqimonth) throws Exception {
		// TODO Auto-generated method stub
		return aqimonthMapper.findCountGradeMonth(aqimonth);
	}
	
}
