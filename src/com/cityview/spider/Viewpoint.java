package com.cityview.spider;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Viewpoint {
	public static void main(String[] args) {
		String url="http://beijing.cncn.com/jingdian/1-1-0-0.html";
		int i=0;
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Elements city_spots_list=doc.select("div[class='city_spots_list']>ul>li");
			for(Element spots_list:city_spots_list){
				System.out.println("单个景点主页："+spots_list.select("a[href]").attr("href")+"profile");
				//景点详情页的链接start========================
				//加入abs:前缀取得链接的绝对路径而不是相对路径
				String firsturl=spots_list.select("a[href]").attr("abs:href")+"profile";
				Document fistdoc=Jsoup.parse(new URL(firsturl), 2000);
				
				Elements firstel=fistdoc.select("div.top");
				
				System.out.println("门票开放时间和交通"+firstel.text());
				
				System.out.println("简介："+fistdoc.select("div.type>p").text());
				
				//景点详情页的链接end========================
				System.out.println("图片链接："+spots_list.select("img").attr("data-original"));
				
				System.out.println("标题："+spots_list.select("div.title>b").text());
				System.out.println("想去的人数:"+spots_list.select("div.title>span").text());
				
				if("".equals(spots_list.select("span.price>b").text())){
					System.out.println("此景点没有价格");
				}else{
					System.out.println("价格是："+spots_list.select("span.price>b").text());
				}
			System.out.println("------------------------------------------------------------------");
			i++;
			
			}
			
			System.out.println("本页共有"+i+"个景点");
			
			
//			Elements el=doc.select("span[class='text']");
//			System.out.println(el.get(0).text());
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
