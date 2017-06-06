package com.cityview.spider;

import java.io.IOException;
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
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;

import com.cityview.bloomFilter.BloomFilter;
import com.cityview.po.Houses;
import com.cityview.tool.pingying;

/**
* <p>Title: House.java<／p>
* <p>Description:房租信息、二手房信息<／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class HouseSpider {
	public static void main(String[] args) {
		new HouseSpider().getHouses(171,"大连");
	}
	public static List<Houses> getHouses(int page,String cityname) {
		// TODO Auto-generated method stub
		String url="http://"+pingying.getFirstSpell(cityname)+".ganji.com/fang1/o"+page+"/";//租房
//		String twourl="http://dl.ganji.com/fang5/o1/";//二手房
		List<Houses> houses=new ArrayList<Houses>();
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			int k=0;
			Elements list_itemss=doc.select(".f-list-item");
			System.out.println(list_itemss.size());
			for(Element list_items:list_itemss){
				Houses housesbean=new Houses();
				housesbean.setCityname(cityname);
				//得到标题
				Element title=list_items.select("dd[class='dd-item title']").get(0);
				Element afwurl=title.select("a").get(0);
				System.out.println("本出租房链接是："+afwurl.attr("abs:href"));
				String fwurl=afwurl.attr("abs:href");
				housesbean.setHouseurl(fwurl);
//				BloomFilter filter = BloomFilter.getIstance();//网页去重工具类（单例模式）
//				if(filter.contains(fwurl)){
//					System.out.println("已存在，跳出");
//					continue;
//				}else{
//					filter.add(fwurl);
					System.out.println("房屋标题："+title.text());
					housesbean.setTitle(title.text());
					Elements sizes=list_items.select("dd[class='dd-item size']>span");
					System.out.println(sizes.size()+"个列表》》》》》》》》》》》》》》》》》》》》》》》》》");
					if(sizes.size()==11){
						for(int i=0;i<sizes.size();i++){//Element size:sizes
							if(!"item-line".equals(sizes.get(i).attr("class"))){
								String sizelist=sizes.get(i).text();
								System.out.println(sizelist);
								if(i==0){
									housesbean.setWay(sizelist);
									continue;
								}
								if(i==2){
									housesbean.setType(sizelist);
									continue;
								}
								if(i==4){
									int index=sizelist.indexOf("㎡");
									System.out.println("取出来了-----"+sizelist.substring(0, index));
									if(index!=-1){
										housesbean.setSize(sizelist.substring(0, index));
									}
									continue;
								}
								if(i==6){
									housesbean.setFace(sizelist);
									continue;
								}
								if(i==8){
									housesbean.setFloor(sizelist);
									continue;
								}
								if(i==10){
									housesbean.setRenovation(sizelist);
									continue;
								}
								System.out.println();
								System.out.println("--------房屋情况分割线-------------");
							}
						}
					}
					if(sizes.size()==9){
						for(int i=0;i<sizes.size();i++){//Element size:sizes
							if(!"item-line".equals(sizes.get(i).attr("class"))){
								String sizelist=sizes.get(i).text();
								System.out.println(sizelist);
								if(i==0){
									housesbean.setType(sizelist);
									continue;
								}
								if(i==2){
									int index=sizelist.indexOf("㎡");
									System.out.println("取出来了-----"+sizelist.substring(0, index));
									if(index!=-1){
										housesbean.setSize(sizelist.substring(0, index));
									}
									continue;
								}
								if(i==4){
									housesbean.setFace(sizelist);
									continue;
								}
								if(i==6){
									housesbean.setFloor(sizelist);
									continue;
								}
								if(i==8){
									housesbean.setRenovation(sizelist);
									continue;
								}
								System.out.println();
								System.out.println("--------房屋情况分割线-------------");
							}
						}
					}
					
					Element address=list_items.select("dd[class='dd-item address']>span[class='area']").get(0);
					System.out.println("出租房地址："+address.text());
					housesbean.setAddress(address.text());
					
					Element sources=list_items.select("dd[class='dd-item source']").get(0);
					if(sources.select("span").hasAttr("class")){
						Element source=sources.select("span[class='f-m10']").get(0);
						System.out.println("中介公司："+source.text());
						housesbean.setAgency(source.text());
					}else{
						System.out.println("这是个人房租出租++++++++++++++++++++++++++++");
					}
					
					Element info=list_items.select("dd[class='dd-item info']>div[class='price']>span[class='num']").get(0);
					System.out.println("价格："+info.text());
					housesbean.setPrice(info.text());
					
					Element times=list_items.select("dd[class='dd-item info']>div[class='time']").get(0);
					String timenow=times.text();
					System.out.println("出租房发布时间："+timenow);
					Calendar calendar=Calendar.getInstance();
//					System.out.println("发布的时间start------------------");
					if(timenow.contains("小时")||timenow.contains("刚刚")||timenow.contains("今天")){
						calendar.add(Calendar.DATE,0);
						Date time=calendar.getTime();
						String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
						System.out.println("发布时间："+day);
						housesbean.setTime(day);
					}
					else if(timenow.contains("昨天")){
						calendar.add(Calendar.DATE,-1);
						Date time=calendar.getTime();
						String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
						housesbean.setTime(day);
						System.out.println("发布时间："+day);
					}
					else if(timenow.contains("前天")){
						calendar.add(Calendar.DATE,-2);
						Date time=calendar.getTime();
						String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
						System.out.println("发布时间："+day);
						housesbean.setTime(day);
					}else if(timenow.contains("天前")){
						int index=timenow.indexOf("天");
						if(index!=-1){
							int t=Integer.parseInt(timenow.substring(0, index));
							calendar.add(Calendar.DATE,-t);
							Date time=calendar.getTime();
							String day=new SimpleDateFormat("yyyy-MM-dd").format(time);
							System.out.println("发布时间："+day);
							housesbean.setTime(day);
						}
					}
					else{
						calendar.add(Calendar.DATE,0);
						Date time=calendar.getTime();
						String day=new SimpleDateFormat("yyyy").format(time);
						System.out.println("发布时间："+day+"-"+timenow);
						housesbean.setTime(day+"-"+timenow);
					}
//					System.out.println("发布的时间end------------------");		
					k++;
					System.out.println("这是第"+k+"个房屋的信息===================================================================");
					
					
					houses.add(housesbean);
					
					
				}
				
//			}
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		return houses;
	}

}
