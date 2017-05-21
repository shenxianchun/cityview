package com.cityview.service;

import java.util.List;

import com.cityview.po.Job;

/**
* <p>Title: JobService.java<／p>
* <p>Description:描述：招聘职位service <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月19日
* @version 1.0cityview
*/
public interface JobService {
	/**
	 * 插入职位信息
	 * @throws Exception
	 */
	public void insertJoblist(List<Job> jobs)throws Exception;
}
