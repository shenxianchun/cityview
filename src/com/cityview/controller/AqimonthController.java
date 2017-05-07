package com.cityview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cityview.po.AqidayCustom;
import com.cityview.po.AqidayQueryVo;
import com.cityview.po.AqimonthCustom;
import com.cityview.po.AqimonthQueryVo;
import com.cityview.po.City;
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
		public @ResponseBody List<AqimonthCustom> queryAqimonth(AqimonthQueryVo aqimonthQueryVo) throws Exception{
			System.out.println("------空气质量指数查询start-----");
			List<AqimonthCustom> aqimonthCustom=aqimonthService.findAqimonthList(aqimonthQueryVo);
			if(aqimonthCustom.size()==0){
				aqimonthCustom.add(null);
			}
			System.out.println("------空气质量指数查询查询end-----");
			//@ResponseBody将itemsCustom转成json输出
			return aqimonthCustom;
		}
	
}
