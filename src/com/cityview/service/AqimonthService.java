package com.cityview.service;

import java.util.List;

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
	//查询月全量
	public List<AqimonthCustom> findAqimonthList(AqimonthQueryVo aqimonthQueryVo)throws Exception;
}
