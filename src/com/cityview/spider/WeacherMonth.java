package com.cityview.spider;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WeacherMonth {
	public static void main(String[] args) {
		String url="http://lishi.tianqi.com/beijing/201310.html";
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Elements uls=doc.select(".tqtongji2>ul");
			for(Element ul:uls){
				Elements lis=ul.select("li");
				for(Element li:lis){
					System.out.print(li.text()+"\t");
				}
				System.out.println("");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
