package com.cityview.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.po.Viewspot;
import com.cityview.tool.ImageDownload;
import com.cityview.tool.pingying;

/**
 * 城市风景爬虫
* <p>Title: ViewSpider.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月18日
* @version 1.0cityview
*/
public class ViewSpider {
	public static void main(String[] args) {
		String url="http://beijing.cncn.com/jingdian/1-1-0-0.html";
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			int page=0;
			Elements pages=doc.select(".page>.page_con>.text");
			if("".equals(pages.text())){
				page=1;
			}else{
				String pagenum=pages.text();
				int indexstart=pagenum.indexOf("共");
				int indexend=pagenum.indexOf("页");
				page=Integer.parseInt(pagenum.substring(indexstart+1,indexend));
			}
		//	List<Viewspot> listview=getpageView(page,"beijing");
			System.out.println("==============="+page+"====================");
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Viewspot> getViews(String cityname) {
		String url="http://"+pingying.getFullSpell(cityname)+".cncn.com/jingdian/1-1-0-0.html";
		List<Viewspot> listview=null;
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			int page=0;
			Elements pages=doc.select(".page>.page_con>.text");
			if("".equals(pages.text())){
				page=1;
			}else{
				String pagenum=pages.text();
				int indexstart=pagenum.indexOf("共");
				int indexend=pagenum.indexOf("页");
				page=Integer.parseInt(pagenum.substring(indexstart+1,indexend));
			}
			listview=getpageView(page,cityname);
			System.out.println("==============="+page+"====================");
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listview;
	}
	
	
	
	
	public List<Viewspot> getpageView(int page,String cityname){
		List<Viewspot> viewspots=new ArrayList<Viewspot>();
		String city=pingying.getFullSpell(cityname);
		for(int i=1;i<=page;i++){
			String url="http://"+city+".cncn.com/jingdian/1-"+i+"-0-0.html";
			try {
				Document doclist=Jsoup.parse(new URL(url), 2000);
				Elements city_spots_list=doclist.select("div[class='city_spots_list']>ul>li");
				for(Element spots_list:city_spots_list){
					Viewspot viewbean=new Viewspot();
					viewbean.setCityname(cityname);
					System.out.println("单个景点主页："+spots_list.select("a[href]").attr("href")+"profile");
					viewbean.setViewurl(spots_list.select("a[href]").attr("href")+"profile");
					
					//景点详情页的链接start========================
					//加入abs:前缀取得链接的绝对路径而不是相对路径
					System.out.println("描述："+spots_list.select("div.text_con>p").text());
					viewbean.setIntroduction(spots_list.select("div.text_con>p").text());
					
					
					//景点详情页的链接end========================
					System.out.println("图片链接："+spots_list.select("img").attr("data-original"));
					
					
					viewbean.setImageurl("view/"+ImageDownload.imgname(spots_list.select("img").attr("data-original"),"view"));
					
					
					System.out.println("标题："+spots_list.select("div.title>b").text());
					viewbean.setTitle(spots_list.select("div.title>b").text());
					
					//System.out.println("想去的人数:"+spots_list.select("div.title>span").text());
					String peoples=spots_list.select("div.title>span").text();
					int num=peoples.indexOf("人");
					if(num<0){
						viewbean.setPeoplenum("0");
					}else{
						System.out.println(num+"============================================");
						System.out.println("想去的人数:"+peoples.substring(0, num));
						viewbean.setPeoplenum(peoples.substring(0, num));
					}
					if("".equals(spots_list.select("span.price>b").text())){
						System.out.println("此景点没有价格");
						viewbean.setPrice("0");
					}else{
						System.out.println("价格是："+spots_list.select("span.price>b").text());
						viewbean.setPrice(spots_list.select("span.price>b").text());
					}
					viewspots.add(viewbean);
				System.out.println("------------------------------------------------------------------");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return viewspots;
	}
}
