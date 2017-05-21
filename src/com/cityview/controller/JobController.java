package com.cityview.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Food;
import com.cityview.po.Job;
import com.cityview.service.JobService;
import com.cityview.spider.JobSpider;

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
	
	@RequestMapping("/insertJob")
	public @ResponseBody String insertJob(@RequestBody Job job)throws Exception{
		
		String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl="+job.getCityname()+"&kw="+job.getName();	
		List<Job> jobs=new ArrayList<Job>();
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
	
}
