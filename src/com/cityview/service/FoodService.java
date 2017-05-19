package com.cityview.service;

import java.util.List;

import com.cityview.po.Food;

/**
 * 美食Service
* <p>Title: FoodService.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
public interface FoodService {
	/**
	 * 批量插入美食
	 * @param foods
	 * @throws Exception
	 */
	public void insertFood(List<Food> foods)throws Exception;
	
	/**
	  * 查找对应的城市美食在数据库中是否存在
	 * @param cityname
	 * @return
	 */
	public int findFoodcity(String cityname)throws Exception ;
	
	/**
	 * 查找对应城市的全部美食
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Food> findFoodAll(String cityname)throws Exception;
}
