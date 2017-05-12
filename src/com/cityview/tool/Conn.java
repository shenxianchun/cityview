package com.cityview.tool;

import java.net.URL;
import java.lang.Exception;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Conn{
	public static int flag=0;
	public static Document getConn(String url){
		Document doc=null;
		try {
			doc = Jsoup.parse(new URL(url), 2000);
		}
		catch (Exception e) {
			flag++;
			if(flag==5){
				flag=0;
				return null;
			}
			System.out.println("第"+flag+"次获取数据失败");
			getConn(url);//出现异常继续执行这个方法
			e.printStackTrace();
		}
		return doc;
	}
	
}
