package com.cityview.spider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Job {
	public static void main(String[] args) {
		String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=北京&kw=CTO&sf=50001&st=99999";
		for(int i=0;i<99;i++){
			test(url+"&p="+i);
		}
		
	}
	public static void test(String joburl) {
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
				work(a.attr("abs:href"));//得到具体职位信息
			}
			
			System.out.println("职位数："+i+"===================================");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void work(String url){
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element el=doc.select(".fl>h1").get(0);
			System.out.println(el.text());
			Elements labels=doc.select(".welfare-tab-box>span");
			StringBuffer bel=new StringBuffer();
			for(Element label:labels){
				bel.append("["+label.text()+"]");
			}
			System.out.println(bel.toString());
			//得到工资基本信息
			Elements uls=doc.select(".terminalpage-left>ul>li>strong");
			for(Element ul:uls){
				System.out.println(ul.text());
			}
			//工作描述
			Elements miaoshus=doc.select(".tab-inner-cont>p");
			for(Element miaoshu:miaoshus){
				System.out.println(miaoshu.text());
				
			}
			
			//得到公司名称
			Element companyname=doc.select(".company-name-t").get(0);
			System.out.println(companyname.text());
			
			//得到公司信息
			Elements companyli=doc.select(".company-box>ul>li>strong");
			for(Element li:companyli){
				System.out.println(li.text());
			}
		System.out.println("------------------------------------------------------------------------------------------------");	
			
		}
		catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
