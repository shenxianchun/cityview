package com.cityview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.City;
import com.cityview.service.CityService;
import com.cityview.tool.GetIp;
import com.cityview.tool.IpgetCityname;

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
	
	
	/**
	 * 得到ip地址对应的城市
	 * @param request
	 * @return
	 */
	@RequestMapping("/IpgetCityname")
	public @ResponseBody String IpgetCityname(HttpServletRequest request,HttpSession session){
		String ip=new GetIp().getIpAddr(request);
		System.out.println("访问者的ip地址为"+ip);
		
		String cityname=IpgetCityname.GetAddressByIp("106.3.240.209");
		
		System.out.println("当前访问者的地址为:"+cityname);
		
		cityname="北京";
		
		session.setAttribute("cityname", cityname);
		return cityname;
	}
	
	
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
