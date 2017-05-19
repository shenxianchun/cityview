package com.cityview.spider;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 城市历史天气（网站自己统计好的数据）
 * 暂时废弃，不用
* <p>Title: Weather.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月14日
* @version 1.0cityview
*/
public class Weather {
	public final static String weatherUrl="http://lishi.tianqi.com/beijing/index.html";//北京历史天气
	
	public static void main(String[] args){
		
		Document doc;
		try {
			doc = Jsoup.parse(new URL(weatherUrl),200);
		
			Elements tqtj=doc.select("div[class='tqtongji']>p");
			System.out.println(tqtj.outerHtml());
			System.out.println("天气统计结束=========================");
			
			Elements fxtj=doc.select("div[class='tqtongji']>ul");
			System.out.println(fxtj.size());
			for(int i=0;i<fxtj.size();i++){
				Element w=fxtj.get(i);
				System.out.println(w.select("li").outerHtml()+"============");
			}
			//System.out.println(fxtj.outerHtml());
		
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("网络超时");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("连接超时");
			e.printStackTrace();
		}finally{
			System.out.println("出来了");
		}
		
	}
}
