package com.cityview.mapper;

import java.util.List;

import com.cityview.po.Monthweather;
import com.cityview.po.Weatherurl;

/**
* <p>Title: WeatherMapper.java<／p>
* <p>Description:描述:历史天气统计 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月13日
* @version 1.0cityview
*/
public interface WeatherMapper {
	/**
	 * 批量插入历史天气
	 * @param monthweathers
	 * @throws Exception
	 */
	public void insertWeatherMonth(List<Monthweather> monthweathers)throws Exception;
	
	/**
	 * 传入月份链接统计该月份的数据有无 有：>0;无：=0
	 * @return
	 * @throws Exception
	 */
	public int findCountWeacherUrl(String monthweatherurl)throws Exception;
	
	/**
	 * 插入每个月天气的链接
	 * @param weatherurl
	 * @throws Exception
	 */
	public void insertWeatherUrl(String weatherurl)throws Exception;
	
	
	/**
	 * 天气状况统计
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findCountweather(String cityname)throws Exception;
	
	/**
	 * 风向统计
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findCountdirection(String cityname)throws Exception;
	
	/**
	 * 风力统计
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findCountpower(String cityname)throws Exception;
	
	
	/**
	 * 每月天气状况统计
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findMonthcountweather(Monthweather monthweather)throws Exception;
	
	/**
	 * 每月风向统计
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findMonthCountdirection(Monthweather monthweather)throws Exception;
	
	/**
	 * 每月风力
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findMonthCountpower(Monthweather monthweather)throws Exception;
	
	/**
	 *  每月天气状况所有数据查询
	 * @param monthweather
	 * @return
	 * @throws Exception
	 */
	public List<Monthweather> findWeatherMonthAll(Monthweather monthweather)throws Exception;
	
	/**
	 * 查找月份
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<String> querymonth(String cityname)throws Exception;
}
