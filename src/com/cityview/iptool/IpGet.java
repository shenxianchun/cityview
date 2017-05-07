package com.cityview.iptool;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IpGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ipurl="http://www.xicidaili.com/";
		int a=0;	
		for(int j=1;j<=10;j++){
			String url="http://www.xicidaili.com/nn/"+j;
			try {
				Document doc=Jsoup.connect(url).userAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)")
						.timeout(2000).get();
				
				Elements iplists=doc.select("table[id='ip_list']>tbody>tr");
				for(int i=1;i<iplists.size();i++){
					String ip=iplists.get(i).select("td").get(1).text();
					String port=iplists.get(i).select("td").get(2).text();
					String position=iplists.get(i).select("td").get(3).text();
					String anonymity=iplists.get(i).select("td").get(4).text();
					String iptype=iplists.get(i).select("td").get(5).text();
					String responsetime=iplists.get(i).select("td").get(8).text();//相应时间/存活时间
					//if(IpTest.isHostReachable(ip,2000)){
						System.out.println(ip+":"+port+"\t"+position+"\t"+anonymity+"\t"+iptype+"\t"+responsetime);
						a++;
					//}
					
				}
				
				System.out.println("----------------本页有"+a+"个ip------------------------------------------");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
