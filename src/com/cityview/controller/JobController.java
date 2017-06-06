package com.cityview.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Food;
import com.cityview.po.Houses;
import com.cityview.po.Job;
import com.cityview.service.JobService;
import com.cityview.spider.JobSpider;
import com.cityview.tool.GetIp;
import com.cityview.tool.IpgetCityname;

import cn.com.webxml.IpTest;

/**
* <p>Title: JobController.java<／p>
* <p>Description:描述 :职位信息<／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月20日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;
	
	
	/**
	 * 得到ip地址对应的城市
	 * @param request
	 * @return
	 */
	@RequestMapping("/IpgetCityname")
	public @ResponseBody String IpgetCityname(HttpServletRequest request,HttpSession session){
		String ip=new GetIp().getIpAddr(request);
		System.out.println("访问者的ip地址为"+ip);
		
		String cityname=IpgetCityname.GetAddressByIp("106.3.240.209");
		
		System.out.println("当前访问者的地址为:"+cityname);
		
		cityname="北京";
		
		session.setAttribute("cityname", cityname);
		return cityname;
	}
	
	/**
	 * 批量插入招聘职位信息
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertJob")
	public @ResponseBody String insertJob(@RequestBody Job job)throws Exception{
		
		String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl="+job.getCityname()+"&kw="+job.getName();
		try {
			Document docpage=Jsoup.parse(new URL(url), 2000);
			String count=docpage.select("span.search_yx_tj>em").text().trim();
			int num=Integer.parseInt(count);
			System.out.println(num);
			int pages=num/60;
			int page=0;
			if(pages>90){
				page=90;
			}else{
				page=pages;
			}
			System.out.println(page);
			for(int i=1;i<=page;i++){
				List<Job> joblist=JobSpider.getJobs(i,job.getCityname(), job.getName());
				if(joblist.size()>0){
					jobService.insertJoblist(joblist);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return "插入成功";
	}
	
	/**
	 *	统计公司不同公司类型的总数
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findCompanynatureTotal")
	public @ResponseBody List<Job> findCompanynatureTotal(@RequestBody Job job)throws Exception{
		
		List<Job> companynaturelist=jobService.findCompanynatureTotal(job.getCityname());
		
		return companynaturelist;
	}
	
	/**
	 *	统计不同规模的公司的数目
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findScaleTotal")
	public @ResponseBody List<Job> findScaleTotal(@RequestBody Job job)throws Exception{
		
		List<Job> scalelist=jobService.findScaleTotal(job.getCityname());
		
		return scalelist;
	}
	
	/**
	 *	统计不同行业公司的数量
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findindustry")
	public @ResponseBody List<Job> findindustry(@RequestBody Job job)throws Exception{
		
		List<Job> industrylist=jobService.findindustry(job.getCityname());
		
		return industrylist;
	}
	
	
	/**
	 *	统计工作经验与工资的关系
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findpriceExp")
	public @ResponseBody List<Job> findpriceExp(@RequestBody Job job)throws Exception{
		List<Job> priceExplist=jobService.findpriceExp(job);
		return priceExplist;
	}
	/**
	 *	统计学历与工资的关系
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findpriceEducation")
	public @ResponseBody List<Job> findpriceEducation(@RequestBody Job job)throws Exception{
		List<Job> priceEducationlist=jobService.findpriceEducation(job);
		return priceEducationlist;
	}
	
	/**
	 *	统计工作经验和用人需求的关系
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/finddemandExp")
	public @ResponseBody List<Job> finddemandExp(@RequestBody Job job)throws Exception{
		List<Job> demandExplist=jobService.finddemandExp(job);
		return demandExplist;
	}
	
	/**
	 *	学历与用人需求的关系
	 * @param job
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/finddemandEducation")
	public @ResponseBody List<Job> finddemandEducation(@RequestBody Job job)throws Exception{
		List<Job> demandEducationlist=jobService.finddemandEducation(job);
		return demandEducationlist;
	}
	
	
	
	
	
	
}
