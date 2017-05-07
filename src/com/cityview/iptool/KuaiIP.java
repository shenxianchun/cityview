package com.cityview.iptool;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KuaiIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://www.kuaidaili.com/free/intr/";
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Elements tbody=doc.select("tbody>tr");
			for(Element tr:tbody){
				Elements tds=tr.select("td");
				for(Element td:tds){
					System.out.println(td.text());
				}
				System.out.println("------------------------ip分割------------------------");
			}
			
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
