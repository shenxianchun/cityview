package com.cityview.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Monthweather;
import com.cityview.service.WeatherService;
import com.cityview.spider.WeacherMonth;
import com.cityview.tool.pingying;

/**
* <p>Title: WeatherController.java<／p>
* <p>Description:描述:历史天气 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月13日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	/**
	 * 插入历史天气数据
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertWeatherMonth")
	public @ResponseBody String insertWeatherMonth(@RequestBody Monthweather monthweather)throws Exception{
		WeacherMonth weacherMonth=new WeacherMonth();//天气爬虫类
		System.out.println("-------历史天气数据获取插入数据库------------------"+monthweather.getCityname());
		String cityname=pingying.getFullSpell(monthweather.getCityname());//得到城市汉子拼音
		
		List<String> urls=weacherMonth.getMonthUrl(cityname);
		for(String url:urls){
			if(weatherService.findCountWeacherUrl(url)==0){
				weatherService.insertWeatherUrl(url);
				List<Monthweather> monthweathers=weacherMonth.monthWeacher(monthweather.getCityname(), url);
				if(monthweathers.size()!=0){
					weatherService.insertWeatherMonth(monthweathers);
				}
			}
		}
		return "成功";
	}
	
	
	
	@RequestMapping("/querymonth")
	public @ResponseBody List<String> querymonth(@RequestBody Monthweather monthweather)throws Exception{
		String cityname=monthweather.getCityname();
		
		System.out.println(cityname+"--------历史天气状况月份-----------");
		List<String> Monthlist=weatherService.querymonth(cityname);
		
		return Monthlist;
	}
	
	
	
	
	
	/**
	 * 天气统计包括风向风力
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryCountWeather")
	public @ResponseBody List<List<Monthweather>> queryCountWeather(@RequestBody Monthweather monthweather,HttpSession session)throws Exception{
		String cityname=monthweather.getCityname();
		session.setAttribute("searchcityname", cityname);
		System.out.println(cityname+"--------历史天气状况统计-----------");
		List<List<Monthweather>> weatherList=new ArrayList<List<Monthweather>>();
		List<Monthweather> weathers=weatherService.findCountweather(cityname);
		List<Monthweather> directions=weatherService.findCountdirection(cityname);
		List<Monthweather> powers=weatherService.findCountpower(cityname);
		weatherList.add(weathers);
		weatherList.add(directions);
		weatherList.add(powers);
		return weatherList;
	}
	
	
	/**
	 * 统计每个月天气状况
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryCountMonthWeather")
	public @ResponseBody List<List<Monthweather>> queryCountMonthWeather(@RequestBody Monthweather monthweather)throws Exception{
		String cityname=monthweather.getCityname();
		System.out.println(cityname+"--------每月历史天气状况统计-----------");
		List<List<Monthweather>> weatherList=new ArrayList<List<Monthweather>>();
		List<Monthweather> weathers=weatherService.findMonthcountweather(monthweather);
		List<Monthweather> directions=weatherService.findMonthCountdirection(monthweather);
		List<Monthweather> powers=weatherService.findMonthCountpower(monthweather);
		weatherList.add(weathers);
		weatherList.add(directions);
		weatherList.add(powers);
		return weatherList;
	}
	/**
	 * 每个月天气详情数据
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryWeatherMonthAll")
	public @ResponseBody List<Monthweather> queryWeatherMonthAll(@RequestBody Monthweather monthweather)throws Exception{
		
		System.out.println(monthweather.getCityname()+monthweather.getDate()+"--------天气详情列表-----------");
		
		List<Monthweather> monthweatherlist=weatherService.findWeatherMonthAll(monthweather);
		
		return monthweatherlist;
	}
	
	
}
