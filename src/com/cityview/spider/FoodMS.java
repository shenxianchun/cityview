package com.cityview.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.po.Food;
import com.cityview.tool.ImageDownload;
import com.cityview.tool.pingying;

/**
* <p>Title: Food.java<／p>
* <p>Description:城市美食 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class FoodMS {

	public static void main(String[] args) {
		String cityname="sichuan";
		String url="http://"+cityname+".cncn.com/meishi/";//美食链接
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
			System.out.println("==============="+page+"====================");
			if(page==1){
				System.out.println(new FoodMS().Meishione(cityname).size());
			}else{
				System.out.println(new FoodMS().MeishiList(page,cityname).size());
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Food> getFoods(String cityname){
		List<Food> lists=null;
		String city=pingying.getFullSpell(cityname);
		String url="http://"+city+".cncn.com/meishi/";//美食链接
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			int page=0;
			Elements pages=doc.select(".page>.page_con>.text");
			if("".equals(pages.text())){
				page=1;
			}else{
				page=Integer.parseInt(pages.text().substring(1, 2));
			}
			System.out.println("==============="+page+"====================");
			if(page==1){
				lists=Meishione(cityname);
			}else{
				lists=MeishiList(page,cityname);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public List<Food> Meishione(String cityname){
		System.out.println("只有一页");
		List<Food> lists=new ArrayList<Food>();
		String url="http://"+pingying.getFullSpell(cityname)+".cncn.com/meishi/";//美食链接
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element ms=doc.select(".a").get(0);
			Elements mses=ms.select("a");
			
			for(Element mss:mses){
				Food foodbean=new Food();
				foodbean.setCityname(cityname);
				//输出链接
				foodbean.setFoodurl(mss.attr("abs:href"));
//				System.out.println(mss.attr("abs:href"));
				
				//得到图片
				Element img=mss.select("img").get(0);
				System.out.println(img.attr("abs:data-original"));
				
				foodbean.setImageurl("food/"+ImageDownload.imgname(img.attr("abs:data-original"),"food"));
				
				
				//美食名称
				Element name=mss.select("div>span").get(0);
				System.out.println(name.text());
				foodbean.setTitle(name.text());
				
				//美食热度
				Element rd=mss.select("div>font").get(0);
				System.out.println(rd.text().replace("热度", "").trim());
				foodbean.setHeat(rd.text().replace("热度", "").trim());
				
				//美食简介
				Element content=mss.select("div>p").get(0);
				System.out.println(content.text());
				foodbean.setIntroduction(content.text());
				lists.add(foodbean);
				System.out.println("-----------------------------------------------------");
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public List<Food> MeishiList(int page,String cityname){
		System.out.println("================第"+page+"页============================");
		List<Food> lists=new ArrayList<Food>();
		for(int i=1;i<=page;i++){
			String pageUrl="http://"+pingying.getFullSpell(cityname)+".cncn.com/meishi/index"+i+".htm";//美食链接
			try {
				Document doc = Jsoup.parse(new URL(pageUrl), 2000);
				Element ms=doc.select(".a").get(0);
				Elements mses=ms.select("a");
				for(Element mss:mses){
					Food foodbean=new Food();
					foodbean.setCityname(cityname);
					//输出链接
					System.out.println(mss.attr("abs:href"));
					foodbean.setFoodurl(mss.attr("abs:href"));
					
					//得到图片
					Element img=mss.select("img").get(0);
					System.out.println(img.attr("abs:src"));
					foodbean.setImageurl("food/"+ImageDownload.imgname(img.attr("abs:src"),"food"));
					
					//美食名称
					Element name=mss.select("div>span").get(0);
					System.out.println(name.text());
					foodbean.setTitle(name.text());
					
					//美食热度
					Element rd=mss.select("div>font").get(0);
					System.out.println(rd.text().replace("热度", "").trim());
					foodbean.setHeat(rd.text().replace("热度", "").trim());
					
					//美食简介
					Element content=mss.select("div>p").get(0);
					System.out.println(content.text());
					foodbean.setIntroduction(content.text());
					lists.add(foodbean);
					System.out.println("-----------------------------------------------------");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lists;
	}

}
