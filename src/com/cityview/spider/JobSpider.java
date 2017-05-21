package com.cityview.spider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.po.Job;

public class JobSpider {
	public static void main(String[] args) throws InterruptedException {
		String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=北京&kw=java";//&p=1
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			
			String count=doc.select("span.search_yx_tj>em").text().trim();
			
			int num=Integer.parseInt(count);
			System.out.println(num);
			System.out.println(num/60);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test(url);
	}
	public static void test(String joburl) throws InterruptedException {
		// TODO Auto-generated method stub
//		String joburl="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=北京&kw=java&p=1";
//		String companysearchurl="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=北京&kw=联想&p=1";
//		String url="http://jobs.zhaopin.com/431959137251006.htm";
			try {
			Document doc = Jsoup.parse(new URL(joburl), 2000);
			Elements jobtable=doc.select("td[class='zwmc'");
			int i=0;
			for(Element alist:jobtable){
				Element a=alist.select("a").get(0);
				i++;
				System.out.println(a.attr("abs:href")+"这是第"+i+"个链接=====================");
				Thread.sleep(1000);//暂停1秒
				work(a.attr("abs:href"));//得到具体职位信息
			}
			
			System.out.println("职位数："+i+"===================================");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static Job work(String url){
		Job jobbean=new Job();
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element el=doc.select(".fl>h1").get(0);
			System.out.println("工作名称："+el.text());
			Elements labels=doc.select(".welfare-tab-box>span");
			StringBuffer bel=new StringBuffer();
			for(Element label:labels){
				bel.append(label.text()+",");
			}
			System.out.println("职位标签："+bel.toString());
			//得到工资基本信息
			Elements uls=doc.select(".terminalpage-left>ul>li>strong");
			for(int i=0;i<uls.size();i++){
				String li=uls.get(i).text();
				if(i==0){
					System.out.println("职位月薪："+li);
					continue;
				}
				if(i==1){
					System.out.println("工作地点："+li);
					continue;
				}
				if(i==2){
					System.out.println("发布时间："+li);
					continue;
				}
				if(i==3){
					System.out.println("工作性质："+li);
					continue;
				}
				if(i==4){
					System.out.println("工作经验："+li);
					continue;
				}
				if(i==5){
					System.out.println("最低学历："+li);
					continue;
				}
				if(i==6){
					System.out.println("招聘人数："+li);
					continue;
				}
				if(i==7){
					System.out.println("职位类别："+li);
					continue;
				}
//				System.out.println("-----------------");
			}
			//工作描述
			Elements miaoshus=doc.select(".tab-inner-cont").get(0).select("p");
			StringBuffer ms=new StringBuffer();
			for(Element miaoshu:miaoshus){
				ms.append(miaoshu.text());
			}
			System.out.println("职位描述:"+ms.toString());
			
			
			//得到公司名称
			Element companyname=doc.select(".company-name-t").get(0);
			System.out.println("公司名称:"+companyname.text());
			
			//得到公司信息
			Elements companyli=doc.select(".company-box>ul>li>strong");
			for(int j=0;j<companyli.size();j++){
				String li=companyli.get(j).text();
				if(j==0){
					System.out.println("公司规模："+li);
					continue;
				}
				if(j==1){
					System.out.println("公司性质："+li);
					continue;
				}
				if(j==2){
					System.out.println("行业："+li);
					continue;
				}
				if(j==3){
					System.out.println("公司主页："+li);
					continue;
				}
				if(j==4){
					System.out.println("公司地址："+li);
					continue;
				}
				
			}
		System.out.println("------------------------------------------------------------------------------------------------");	
			
		}
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobbean;
	}
	

}
