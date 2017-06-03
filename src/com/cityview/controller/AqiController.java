package com.cityview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Aqiday;
import com.cityview.tool.GetIp;

import cn.com.webxml.IpTest;

/**
* <p>Title: AqiController.java<／p>
* <p>Description:测试月全量aqi <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月5日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/aqi")
public class AqiController {
	//请求json串(商品信息)，输出json(商品信息)
		//@RequestBody将请求的商品信息的json串转成itemsCustom对象
		//@ResponseBody将itemsCustom转成json输出
		@RequestMapping("/requestJson")
		public @ResponseBody Aqiday requestJson(@RequestBody Aqiday aqimonth){
			System.out.println("传过来了=======================");
			System.out.println(aqimonth.getCityname());
			//@ResponseBody将itemsCustom转成json输出
			return aqimonth;
		}
		
		//请求key/value，输出json
		@RequestMapping("/responseJson")
		public @ResponseBody Aqiday responseJson(Aqiday aqimonth){
			System.out.println("传过来了=======================");
			System.out.println(aqimonth.getCityname());
			//@ResponseBody将itemsCustom转成json输出
			return aqimonth;
		}
		@RequestMapping("/responseip")
		public @ResponseBody String responseip(HttpServletRequest request){
			String ip=new GetIp().getIpAddr(request);
			System.out.println("访问者的ip地址为"+ip);
			List<String> iplist=IpTest.iptest(ip);
			for(String s:iplist){
				System.out.println(s.toString());
			}
			return ip;
		}
}
