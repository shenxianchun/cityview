package com.cityview.service;

import java.util.List;

import com.cityview.po.Houses;

/**
* <p>Title: HousesService.java<／p>
* <p>Description:描述：房租service <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月23日
* @version 1.0cityview
*/
public interface HousesService {
	/**
	 * 插入房租信息
	 * @param houses
	 * @throws Exception
	 */
	public void insertHouseslist(List<Houses> houses)throws Exception;
	
	/**
	 * 统计房子的朝向和价格的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Houses> findFaceprice(String cityname)throws Exception;
	
	/**
	 * 统计房子的装修风格和价格的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Houses> findFaceRenovation(String cityname)throws Exception;
	
	/**
	 * 统计房屋的中介公司
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Houses> findAgencytotal(String cityname)throws Exception;
	
	/**
	 * 统计区域哪块租房最贵
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Houses> findAreaPrice(String cityname)throws Exception;
	
	/**
	 * 统计不同户型的价格关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Houses> findTypePrice(String cityname)throws Exception;
	
	
}
