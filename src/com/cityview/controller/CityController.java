package com.cityview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.City;
import com.cityview.service.CityService;

/**
* <p>Title: CityController.java<／p>
* <p>Description:查询城市<／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月6日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/city")
public class CityController {
	
	//注入CityService
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/city")
	public @ResponseBody List<City> querycitys() throws Exception{
		System.out.println("------省份查询start-----");
		List<City> citylist=cityService.findcityList();
		System.out.println("------省份查询end-----");
		//@ResponseBody将itemsCustom转成json输出
		return citylist;
	}
	
	@RequestMapping("/province")
	public @ResponseBody List<City> queryprovinces(@RequestBody City city) throws Exception{
		System.out.println("------市区查询start-----");
		System.out.println(city.getCityname());
		List<City> citylist=cityService.findprovinceList(city);
		if(citylist.size()==0){
			citylist.add(city);
		}
		System.out.println("------市区查询end-----");
		//@ResponseBody将itemsCustom转成json输出
		return citylist;
	}
	
}
