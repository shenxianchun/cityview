package com.cityview.spider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.bloomFilter.BloomFilter;
import com.cityview.po.Job;

public class JobSpider {
	public static void main(String[] args) throws Exception {
//		String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=北京&kw=java&p=1";//&p=1
		
		List<Job> jobs=new JobSpider().getJobs(1,"北京", "java");
		System.out.println(jobs.size()+"++++++++++++++++++++++++++++++++++++++=");
	}
	
	public static List<Job> getJobs(int page,String cityname,String name) throws Exception {
		List<Job> jobs=new ArrayList<Job>();
		try {
				String joburl="http://sou.zhaopin.com/jobs/searchresult.ashx?jl="+cityname+"&kw="+name+"&p="+page;
				System.out.println("----------------这是第"+page+"页--------------------------------");
				Document doc = Jsoup.parse(new URL(joburl), 2000);
				Elements jobtable=doc.select("td[class='zwmc'");
				int k=0;
				for(Element alist:jobtable){//
					Element a=alist.select("a").get(0);
					k++;
					System.out.println(a.attr("abs:href")+"这是第"+k+"个链接=====================");
					BloomFilter filter = BloomFilter.getIstance();//网页去重工具类（单例模式）
					//Thread.sleep(1000);//暂停1秒
					String urls=a.attr("abs:href");
					if(filter.contains(urls)){
						System.out.println("已存在，跳出");
						continue;
					}else{
						filter.add(urls);
						//Job job=;//得到具体职位信息
						jobs.add(work(cityname,urls));
					}
				}
				System.out.println("职位数："+k+"===================================");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return jobs;
	}
	
	public static Job work(String cityname,String url){
		//url="http://jobs.zhaopin.com/43340898990250127000.htm";
		Job jobbean=new Job();
		jobbean.setCityname(cityname);
		jobbean.setJoburl(url);
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Elements els=doc.select(".fl>h1");
			System.out.println("----------+"+els.text()+"+------------------");
			if(!"".equals(els.text())){
				Element el=els.get(0);
				System.out.println("工作名称："+el.text());
				jobbean.setName(el.text());
				
				Elements labels=doc.select(".welfare-tab-box>span");
				StringBuffer bel=new StringBuffer();
				for(Element label:labels){
					bel.append(label.text()+",");
				}
				System.out.println("职位标签："+bel.toString());
				jobbean.setJoblabel(bel.toString());
				
				//得到工资基本信息
				Elements uls=doc.select(".terminalpage-left>ul>li>strong");
				for(int i=0;i<uls.size();i++){
					String li=uls.get(i).text();
					if(i==0){
						System.out.println("职位月薪："+li);
						int index=li.indexOf("-");
						if(index!=-1){
							int index2=li.indexOf("元");
							String min=li.substring(0, index);
							String max=li.substring(index+1, index2);
							jobbean.setMinprice(min);
							jobbean.setMaxprice(max);
							System.out.println("最低工资："+min+"-最高工资："+max);
						}else{
							jobbean.setMonthprice(li);
							System.out.println("舍弃");
						}
						continue;
					}
					if(i==1){
						System.out.println("工作地点："+li);
						jobbean.setLocation(li);
						continue;
					}
					if(i==2){
						Calendar calendar=Calendar.getInstance();
//						System.out.println("发布的时间是："+li+"------------------");
						if(li.contains("小时")||li.contains("刚刚")||li.contains("今天")){
							calendar.add(Calendar.DATE,0);
							Date time=calendar.getTime();
							String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
							System.out.println("发布时间："+day);
							jobbean.setReleasetime(day);
						}
						else if(li.contains("昨天")){
							calendar.add(Calendar.DATE,-1);
							Date time=calendar.getTime();
							String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
							jobbean.setReleasetime(day);
							System.out.println("发布时间："+day);
						}
						else if(li.contains("前天")){
							calendar.add(Calendar.DATE,-2);
							Date time=calendar.getTime();
							String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
							System.out.println("发布时间："+day);
							jobbean.setReleasetime(day);
						}else if(li.contains("天前")){
							int index=li.indexOf("天");
							if(index!=-1){
								int t=Integer.parseInt(li.substring(0, index));
								calendar.add(Calendar.DATE,-t);
								Date time=calendar.getTime();
								String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
								System.out.println("发布时间："+day);
								jobbean.setReleasetime(day);
							}
						}
						else{
							System.out.println("发布时间："+li);
							jobbean.setReleasetime(li);
						}
						continue;
					}
					if(i==3){
						System.out.println("工作性质："+li);
						jobbean.setJobnature(li);
						continue;
					}
					if(i==4){
						System.out.println("工作经验："+li);
						jobbean.setExp(li);
						continue;
					}
					if(i==5){
						System.out.println("最低学历："+li);
						jobbean.setEducation(li);
						continue;
					}
					if(i==6){
						System.out.println("招聘人数："+li);
						jobbean.setDemand(li);
						continue;
					}
					if(i==7){
						System.out.println("职位类别："+li);
						jobbean.setJobtype(li);
						continue;
					}
//					System.out.println("-----------------");
				}
				//工作描述
				Elements miaoshus=doc.select(".tab-inner-cont").get(0).select("p");
				StringBuffer ms=new StringBuffer();
				for(Element miaoshu:miaoshus){
					ms.append(miaoshu.text());
				}
				System.out.println("职位描述:"+ms.toString());
				jobbean.setDescription(ms.toString());
				
				//得到公司名称
				Element companyname=doc.select(".company-name-t").get(0);
				System.out.println("公司名称:"+companyname.text());
				jobbean.setCompany(companyname.text());
				
				//得到公司信息
				Elements companyli=doc.select(".company-box>ul>li>strong");
				
				for(int j=0;j<companyli.size();j++){
					String li=companyli.get(j).text();
					if(j==0){
						System.out.println("公司规模："+li);
						jobbean.setScale(li);
						continue;
					}
					if(j==1){
						System.out.println("公司性质："+li);
						jobbean.setCompanynature(li);
						continue;
					}
					if(j==2){
						System.out.println("行业："+li);
						jobbean.setIndustry(li);
						continue;
					}
					if(j==3||j==4){
						if(!li.startsWith("http")||!li.startsWith("www")){
							System.out.println("公司地址："+li);
							jobbean.setAddress(li);
						}
						continue;
					}
					
				}
			System.out.println("------------------------------------------------------------------------------------------------");	
				
			}
		}
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobbean;
	}
}
