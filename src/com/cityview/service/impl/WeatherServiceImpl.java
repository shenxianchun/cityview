package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.WeatherMapper;
import com.cityview.po.Monthweather;
import com.cityview.po.Weatherurl;
import com.cityview.service.WeatherService;

/**
* <p>Title: WeatherServiceImpl.java<／p>
* <p>Description:描述:历史天气统计service实现类 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月13日
* @version 1.0cityview
*/
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherMapper weatherMapper;
	
	@Override
	public void insertWeatherMonth(List<Monthweather> monthweathers) throws Exception {
		// TODO Auto-generated method stub
		weatherMapper.insertWeatherMonth(monthweathers);
	}

	@Override
	public int findCountWeacherUrl(String monthweatherurl) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findCountWeacherUrl(monthweatherurl);
	}

	@Override
	public void insertWeatherUrl(String weatherurl) throws Exception {
		// TODO Auto-generated method stub
		weatherMapper.insertWeatherUrl(weatherurl);
	}

	@Override
	public List<Monthweather> findCountweather(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findCountweather(cityname);
	}

	@Override
	public List<Monthweather> findCountdirection(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findCountdirection(cityname);
	}

	@Override
	public List<Monthweather> findCountpower(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findCountpower(cityname);
	}

	@Override
	public List<Monthweather> findMonthcountweather(Monthweather monthweather) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findMonthcountweather(monthweather);
	}

	@Override
	public List<Monthweather> findMonthCountdirection(Monthweather monthweather) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findMonthCountdirection(monthweather);
	}

	@Override
	public List<Monthweather> findMonthCountpower(Monthweather monthweather) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findMonthCountpower(monthweather);
	}

	@Override
	public List<Monthweather> findWeatherMonthAll(Monthweather monthweather) throws Exception {
		// TODO Auto-generated method stub
		return weatherMapper.findWeatherMonthAll(monthweather);
	}

}
