package com.cityview.service;

import java.util.List;

import com.cityview.po.Aqiday;
import com.cityview.po.AqidayCustom;
import com.cityview.po.Aqimonth;
import com.cityview.po.AqimonthCustom;
import com.cityview.po.AqimonthQueryVo;


/**
* <p>Title: AqimonthService.java<／p>
* <p>Description:月全量service <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月2日
* @version 1.0cityview
*/
public interface AqimonthService {
	/**查询月全量
	 * @param aqimonth
	 * @return
	 * @throws Exception
	 */
	public List<Aqimonth> findAqimonthList(Aqimonth aqimonth)throws Exception;
	
	/**插入月全量空气质量指数
	 * @param aqimonth
	 * @throws Exception
	 */
	public void insertAqimonthList(List<Aqimonth> aqimonth)throws Exception;
	
	/**根据链接查询总数以确定该链接是否在数据库中存在
	 * @param aqiurl
	 * @return
	 * @throws Exception
	 */
	public int findAqi(String aqiurl)throws Exception;
	
	/**插入日全量空气质量指数
	 * @param aqidays
	 * @throws Exception
	 */
	public void insertAqidayList(List<Aqiday> aqidays)throws Exception;
	
	/**查询当月日全量
	 * @param aqiday
	 * @return
	 * @throws Exception
	 */
	public List<Aqiday> findaqidayList(Aqiday aqiday)throws Exception;
	
	/**
	 * 根据传入的cityname和月份
	 * @param aqiday
	 * @return 返回统计对应的天气状况及对应的总天数
	 * @throws Exception
	 */
	public List<AqidayCustom> findCountGrade(Aqiday aqiday)throws Exception;
	
	/**
	 * 根据传入的城市统计每个月质量等级的天数
	 * @return
	 * @throws Exception
	 */
	public List<AqimonthQueryVo> findAqiMonthCountGrade(AqimonthCustom aqimonthCustom)throws Exception;
	
	
}
