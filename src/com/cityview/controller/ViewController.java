package com.cityview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Viewspot;
import com.cityview.service.ViewService;
import com.cityview.spider.ViewSpider;

/**
 * 城市风景管理
* <p>Title: ViewController.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	private ViewService viewService;
	/**
	 * 插入风景数据
	 * @param food
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertView")
	public @ResponseBody String insertView(@RequestBody Viewspot viewspot)throws Exception{
		ViewSpider viewSpider=new ViewSpider();
		String cityname=viewspot.getCityname();
		if(viewService.findViewcity(cityname)==0){
			List<Viewspot> viewspots=viewSpider.getViews(cityname);
			viewService.insertView(viewspots);
			return "插入成功";
		}else{
			return "插入失败";
		}
	}
	
	/**
	 * 查询风景全部
	 * @param food
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findViewAll")
	public @ResponseBody List<Viewspot> findViewAll(@RequestBody Viewspot viewspot)throws Exception{	
		List<Viewspot> views=viewService.findViewAll(viewspot.getCityname());
		if(views.size()>0){
			return views;
		}else{
			return null;
		}
	}
}
