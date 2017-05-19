package com.cityview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Food;
import com.cityview.service.FoodService;
import com.cityview.spider.FoodMS;

/**
 * 美食统计
* <p>Title: FoodController.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private FoodService foodService;
	
	
	/**
	 * 插入美食数据
	 * @param food
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertFood")
	public @ResponseBody String insertFood(@RequestBody Food food)throws Exception{
		FoodMS foosMS=new FoodMS();
		String cityname=food.getCityname();
		if(foodService.findFoodcity(cityname)==0){
			List<Food> foods=foosMS.getFoods(cityname);
			foodService.insertFood(foods);
			return "美食插入成功";
		}else{

			return "该城市的美食已存在";
		}
	}
	
	/**
	 * 查询美食全部
	 * @param food
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findFoodAll")
	public @ResponseBody List<Food> findFoodAll(@RequestBody Food food)throws Exception{
		List<Food> foods=foodService.findFoodAll(food.getCityname());
		if(foods.size()>0){
			return foods;
		}else{
			return null;
		}
	}
	
}
