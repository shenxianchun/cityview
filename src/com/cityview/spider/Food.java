package com.cityview.spider;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
* <p>Title: Food.java<／p>
* <p>Description:城市美食 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class Food {

	public static void main(String[] args) {
		String url="http://chengdu.cncn.com/meishi/";//美食链接
		//http://beijing.cncn.com/techan/			//特产链接
		
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element ms=doc.select(".a").get(0);
			Elements mses=ms.select("a");
			for(Element mss:mses){
				//输出链接
				System.out.println(mss.attr("abs:href"));
				
				//得到图片
				Element img=mss.select("img").get(0);
				System.out.println(img.attr("data-original"));
				
				//美食名称
				Element name=mss.select("div>span").get(0);
				System.out.println(name.text());
				
				
				//美食热度
				Element rd=mss.select("div>font").get(0);
				System.out.println(rd.text());
				
				//美食简介
				Element content=mss.select("div>p").get(0);
				System.out.println(content.text());
				System.out.println("-----------------------------------------------------");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
