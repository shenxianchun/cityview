package com.cityview.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cityview.po.Aqiday;
import com.cityview.po.AqidayCustom;
import com.cityview.po.Aqimonth;
import com.cityview.po.AqimonthCustom;
import com.cityview.po.AqimonthQueryVo;
import com.cityview.service.AqimonthService;
import com.cityview.spider.AOI;

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
		
		@RequestMapping("/insert")
		public @ResponseBody String insertAqimonth() throws Exception{
			AOI aqi=new AOI();
			List<Aqimonth> aqiList=aqi.insertAqimonth("杭州");
			List<Aqimonth> queryaqiList=new ArrayList<Aqimonth>();//新的list存入数据库
			for(Aqimonth list:aqiList){
				if(aqimonthService.findAqi(list.getAqiurl())!=1){
					queryaqiList.add(list);
					List<Aqiday> aqidaylist=aqi.insertAqiday(list.getCityname(),list.getMonth());
					if(aqidaylist.size()>0){
						aqimonthService.insertAqidayList(aqidaylist);
					}
				}
			}
			System.out.println(aqiList.size());
			if(queryaqiList.size()>0){
				System.out.println(queryaqiList.toString()+"插入空气质量指数");
				aqimonthService.insertAqimonthList(queryaqiList);
			}
			return "成功";
		}
//		//限制http请求方法，可以post和get
//		@RequestMapping("/queryAqiDay")
//		public ModelAndView queryAqiDay(HttpServletRequest request) throws Exception{
//			String cityname=request.getParameter("cityname");
//			String month=request.getParameter("month");
//			System.out.println(cityname+">>>>>>>>>>>>>>>>>>>>>"+month);
//			//调用service查找数据库，查询每月数据列表
//			Aqiday aqiday=new Aqiday();
//			aqiday.setCityname(cityname);
//			aqiday.setDay(month);
//			
//			List<Aqiday> aqidaysList = aqimonthService.findaqidayList(aqiday);
//			
//			//返回ModelAndView
//			ModelAndView modelAndView=new ModelAndView();
//			
//			//此方法相当于request的setAttribute()方法,在jsp中通过itemsList取数据
//			modelAndView.addObject("aqidaysList", aqidaysList);
//			
//			//指定视图
//			//下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
//			//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
//			//上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
//			modelAndView.setViewName("aqi/dayaqi");
//			return modelAndView;
//		}
		@RequestMapping("/queryAqidayAll")
		public @ResponseBody List<Aqiday> queryAqidayAll(@RequestBody Aqiday aqiday) throws Exception{
			System.out.println("====================查询当月每天的AQI=========="+aqiday.getCityname()+aqiday.getDay());
			List<Aqiday> aqidaylist=aqimonthService.findaqidayList(aqiday);
			return aqidaylist;
		}
		
		@RequestMapping("/queryAqidayCountGrade")
		public @ResponseBody List<AqidayCustom> queryAqidayCountGrade(@RequestBody Aqiday aqiday) throws Exception{
			System.out.println("===================每月AQI质量等级天数统计=========="+aqiday.getCityname()+aqiday.getDay());
			
			List<AqidayCustom> aqidayCustomsList=aqimonthService.findCountGrade(aqiday);
			for(AqidayCustom li:aqidayCustomsList){
				System.out.println(li.getGrade()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+li.getNumGrade());
			}
			return aqidayCustomsList;
		}
		//一对多映射
		@RequestMapping("/queryAqiMonthCountGrade")
		public @ResponseBody List<AqimonthQueryVo> queryAqiMonthCountGrade(@RequestBody AqimonthCustom aqimonthCustom) throws Exception{
			System.out.println("===================每月AQI质量等级天数统计=========="+aqimonthCustom.getCityname());
			
			List<AqimonthQueryVo> aqimonthQueryVoList=aqimonthService.findAqiMonthCountGrade(aqimonthCustom);
			for(AqimonthQueryVo li:aqimonthQueryVoList){
				System.out.println(li.getMonthday()+"-------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				List<AqimonthCustom> aqimonthCustomList=li.getAqimonthCustoms();
				for(AqimonthCustom aqili:aqimonthCustomList){
					System.out.println(aqili.getGrade()+":"+aqili.getNumGrade()+"天");
				}
			}
			return aqimonthQueryVoList;
		}
		
		
}
