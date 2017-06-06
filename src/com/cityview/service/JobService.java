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
	
	/**
	 * 统计公司不同公司类型的总数
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> findCompanynatureTotal(String cityname)throws Exception;
	
	/**
	 * 统计不同规模的公司的数目
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> findScaleTotal(String cityname)throws Exception;
	
	/**
	 * 统计不同行业公司的数量
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> findindustry(String cityname)throws Exception;
	
	/**
	 * 统计工作经验与工资的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> findpriceExp(Job job)throws Exception;
	
	/**
	 * 统计学历与工资的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> findpriceEducation(Job job)throws Exception;
	
	/**
	 * 统计工作经验和用人需求的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> finddemandExp(Job job)throws Exception;
	
	/**
	 * 学历与用人需求的关系
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Job> finddemandEducation(Job job)throws Exception;
	
	
}
