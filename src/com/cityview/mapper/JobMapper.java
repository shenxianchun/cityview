package com.cityview.mapper;

import java.util.List;

import com.cityview.po.Job;

/**
 * 招聘职位mapper
* <p>Title: JobMapper.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月19日
* @version 1.0cityview
*/
public interface JobMapper {
	/**
	 * 插入职位信息
	 * @throws Exception
	 */
	public void insertJoblist(List<Job> jobs)throws Exception;
	
	
	
}
