package com.cityview.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.po.Monthweather;

public class WeacherMonth {
	public List<String> getMonthUrl(String cityname) {
		List<String> urls=new ArrayList<String>();
		String weatherurl="http://lishi.tianqi.com/"+cityname+"/index.html";
		try {
			Document doc=Jsoup.parse(new URL(weatherurl), 2000);
			Elements month_uls=doc.select(".tqtongji1>ul");
			System.out.println(month_uls.size());
			for(Element month_ul:month_uls){
				Elements month_lis=month_ul.select("li");
				for(Element month_li:month_lis){
//					String monthurl=month_li.select("a").get(0).attr("abs:href");
					urls.add(month_li.select("a").get(0).attr("abs:href"));
					//monthWeacher(monthurl);
//					System.out.println("月份天气："+monthurl);
					System.out.println("---------------分割线------------------------------------------------------");
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urls;
	}
	public List<Monthweather> monthWeacher(String cityname,String url){
		//url="http://lishi.tianqi.com/beijing/201311.html";
		List<Monthweather> monthweatherList=new ArrayList<Monthweather>();
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Elements uls=doc.select(".tqtongji2>ul");
			for(int i=1;i<uls.size();i++){
				Elements lis=uls.get(i).select("li");
				Monthweather monthweatherbean=new Monthweather();
				for(int j=0;j<lis.size();j++){
					Element li=lis.get(j);
					String content=li.text();
					if(j==0){
						monthweatherbean.setCityname(cityname);
						monthweatherbean.setDate(content);
					}else if(j==1){
						monthweatherbean.setMaxtemperature(content);
					}else if(j==2){
						monthweatherbean.setMintemperature(content);
					}else if(j==3){
						monthweatherbean.setWeather(content);
					}else if(j==4){
						monthweatherbean.setDirection(content);
					}else if(j==5){
						monthweatherbean.setPower(content);
					}
				}
				monthweatherList.add(monthweatherbean);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monthweatherList;
	}
}
