package com.cityview.iptool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtils {
	
	/**
	 * 通过地址得到document对象
	 * @param url
	 */
	public static Document getDocument(String url) {
			try {

				Document document = Jsoup.connect(url).timeout(1000).get();

				if(document == null || document.toString().trim().equals("")) {// 表示ip被拦截或者其他情况
					System.out.println("出现ip被拦截或者其他情况");
					HttpsetIp.setProxyIp();
					getDocument(url);
				}
				return document;
			} catch (Exception e) { // 链接超时等其他情况
				System.out.println("出现链接超时等其他情况");
				HttpsetIp.setProxyIp();// 换代理ip
				getDocument(url);// 继续爬取网页
			}
			return getDocument(url);
		}
	
	
	public static void main(String[] args) {
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/42/4201.html";
		System.out.println(getDocument("https://www.zhihu.com/people/yao-cheng-46/"));
	}
}
