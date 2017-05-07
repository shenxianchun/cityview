package com.cityview.spider;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
* <p>Title: AOI.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class AOI {
	
	public static void main(String[] args) {
		String url="https://www.aqistudy.cn/historydata/monthdata.php?city=北京";
		String u="https://www.aqistudy.cn/historydata/daydata.php?city=北京&month=201312";
		try {
			Document doc=Jsoup.parse(new URL(u), 2000);
			Elements el=doc.select("tbody").get(0).select("tr");
			for(int i=1;i<el.size();i++){
				Elements tds=el.get(i).select("td");
				for(int j=0;j<tds.size();j++){
					Element td=tds.get(j);
					if(j==0){
						System.out.print("月份："+td.text()+"\t");
					}else if(j==1){
						System.out.print("AQI："+td.text()+"\t");
					}else if(j==2){
						System.out.print("范围："+td.text()+"\t");
					}else if(j==3){
						System.out.print("质量等级："+td.text()+"\t");
					}else if(j==4){
						System.out.print("pm2.5："+td.text()+"\t");
					}else if(j==5){
						System.out.print("pm10："+td.text()+"\t");
					}else if(j==6){
						System.out.print("so2："+td.text()+"\t");
					}else if(j==7){
						System.out.print("co："+td.text()+"\t");
					}else if(j==8){
						System.out.print("no2："+td.text()+"\t");
					}else if(j==9){
						System.out.print("o3："+td.text()+"\t");
					}else{
						System.out.print("排名："+td.text()+"\t");
					}
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
