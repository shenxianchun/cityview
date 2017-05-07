package com.cityview.spider;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
* <p>Title: House.java<／p>
* <p>Description:房租信息、二手房信息<／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class House {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://dl.ganji.com/fang1/o2/";//租房
		String twourl="http://dl.ganji.com/fang5/o1/";//二手房
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element fangs=doc.select(".num").get(0);
			//得到满足房子的总数
			String num=fangs.text().substring(0, fangs.text().length()-1);
			int nums=Integer.parseInt(num);
			//计算一共有多少页
			int d=nums/83;
			System.out.println("房子的页数:"+d);
			int i=0;
			Elements list_itemss=doc.select(".f-list-item");
			System.out.println(list_itemss.size());
			for(Element list_items:list_itemss){
				//得到标题
				Element title=list_items.select("dd[class='dd-item title']").get(0);
				Element fwurl=title.select("a").get(0);
				System.out.println("本出租房链接是："+fwurl.attr("abs:href"));
				
				System.out.println("房屋标题："+title.text());
				
				Elements sizes=list_items.select("dd[class='dd-item size']>span");
				for(Element size:sizes){
					if(!"item-line".equals(size.attr("class"))){
						System.out.println(size.text());
						System.out.println("--------房屋情况分割线-------------");
					}
				}
				
				Element address=list_items.select("dd[class='dd-item address']>span[class='area']").get(0);
				System.out.println("出租房地址："+address.text());
				
				Element sources=list_items.select("dd[class='dd-item source']").get(0);
				if(sources.select("span").hasAttr("class")){
					Element source=sources.select("span[class='f-m10']").get(0);
					System.out.println("中介公司："+source.text());
				}else{
					System.out.println("这是个人房租出租++++++++++++++++++++++++++++");
				}
				
				Element info=list_items.select("dd[class='dd-item info']>div[class='price']>span[class='num']").get(0);
				System.out.println("价格："+info.text());
				
				
				Element time=list_items.select("dd[class='dd-item info']>div[class='time']").get(0);
				System.out.println("出租房发布时间："+time.text());
				i++;
				System.out.println("这是第"+i+"个房屋的信息===================================================================");
			}
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
