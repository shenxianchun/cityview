package com.cityview.mapper;

import java.util.List;

import com.cityview.po.Food;
import com.cityview.po.Viewspot;

/**
 * 城市风景mapper
* <p>Title: ViewMapper.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
public interface ViewMapper {
	/**
	 * 批量插入风景
	 * @param foods
	 * @throws Exception
	 */
	public void insertView(List<Viewspot> Viewspots)throws Exception;
	
	/**
	  * 查找对应的城市风景在数据库中是否存在
	 * @param cityname
	 * @return
	 */
	public int findViewcity(String cityname)throws Exception;
	
	/**
	 * 查找对应城市的全部风景
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Viewspot> findViewAll(String cityname)throws Exception;
}
