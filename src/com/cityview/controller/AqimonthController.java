package com.cityview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Aqimonth;
import com.cityview.service.AqimonthService;

/**
* <p>Title: AqimonthController.java<／p>
* <p>Description:月全量controller <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月2日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/aqimonth")
public class AqimonthController {
	@Autowired
	private AqimonthService aqimonthService;//注入service
		//历史空气质量指数月全量查询
		//@RequestMapping实现 对queryItems方法和url进行映射，一个方法对应一个url
		//一般建议将url和方法写成一样.action可加可不加
		@RequestMapping("/table")
		public @ResponseBody List<Aqimonth> queryAqimonth(@RequestBody Aqimonth aqimonth) throws Exception{
			System.out.println("------空气质量指数查询start-----"+aqimonth.getCityname());
			List<Aqimonth> aqimonthlist=aqimonthService.findAqimonthList(aqimonth);
//			if(aqimonthlist.size()==0){
//				aqimonthlist.add(null);
//			}
			System.out.println("------空气质量指数查询查询end-----");
			//@ResponseBody将itemsCustom转成json输出
			return aqimonthlist;
		}
	
}
