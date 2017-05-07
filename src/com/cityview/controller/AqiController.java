package com.cityview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.AqidayCustom;
import com.cityview.po.AqimonthCustom;

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
		public @ResponseBody AqidayCustom requestJson(@RequestBody AqidayCustom aqimonthCustom){
			System.out.println("传过来了=======================");
			System.out.println(aqimonthCustom.getCityname());
			//@ResponseBody将itemsCustom转成json输出
			return aqimonthCustom;
		}
		
		//请求key/value，输出json
		@RequestMapping("/responseJson")
		public @ResponseBody AqidayCustom responseJson(AqidayCustom aqimonthCustom){
			System.out.println("传过来了=======================");
			System.out.println(aqimonthCustom.getCityname());
			//@ResponseBody将itemsCustom转成json输出
			return aqimonthCustom;
		}
}
