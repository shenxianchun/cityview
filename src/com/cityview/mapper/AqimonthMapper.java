package com.cityview.mapper;

import java.util.List;

import com.cityview.po.Aqimonth;

/**
* <p>Title: AqimonthMapperCustom.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月26日
* @version 1.0
*/
public interface AqimonthMapper {
	//查询月全量
	public List<Aqimonth> findAqimonthList(Aqimonth aqimonth)throws Exception;

}
