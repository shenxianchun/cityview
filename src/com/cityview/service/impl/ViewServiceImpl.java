package com.cityview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cityview.mapper.ViewMapper;
import com.cityview.po.Viewspot;
import com.cityview.service.ViewService;

/**
 * 风景实现类
* <p>Title: ViewServiceImpl.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
public class ViewServiceImpl implements ViewService {
	@Autowired
	private ViewMapper viewMapper;

	@Override
	public void insertView(List<Viewspot> Viewspots) throws Exception {
		// TODO Auto-generated method stub
		viewMapper.insertView(Viewspots);
	}

	@Override
	public int findViewcity(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return viewMapper.findViewcity(cityname);
	}

	@Override
	public List<Viewspot> findViewAll(String cityname) throws Exception {
		// TODO Auto-generated method stub
		return viewMapper.findViewAll(cityname);
	}
	
	

}
