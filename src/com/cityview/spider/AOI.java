package com.cityview.spider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cityview.po.Aqiday;
import com.cityview.po.Aqimonth;

/**
* <p>Title: AOI.java<／p>
* <p>Description:描述 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年4月27日
* @version 1.0cityview
*/
public class AOI {
	private static final boolean Aqimonth = false;
	public static void main(String[] args) throws Exception {
		
		List<Aqimonth> list=new AOI().insertAqimonth("北京");
		for(Aqimonth li:list){
			System.out.println(new AOI().insertAqiday(li.getCityname(),li.getMonth()));
			
		}
		/*new AOI().insertAqiday("北京","2013-12");*/
		
	}
	public List<Aqiday> insertAqiday(String cityname,String month) {
		//String aqiurl="https://www.aqistudy.cn/historydata/daydata.php?city=北京&month=2013-12";
		String aqiurl="https://www.aqistudy.cn/historydata/daydata.php?city="+cityname+"&month="+month;
		List<Aqiday> aqidayList=new ArrayList<Aqiday>();
		try {
			
			Connection con = Jsoup.connect(aqiurl);
			con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");// --指浏览器能接收的Content-type
			con.header("Accept-Encoding", "gzip, deflate");//  --接收编码
			con.header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");//  ---接收语言
			con.header("Connection", "keep-alive");//是否须要持久连接
			con.header("Host", aqiurl);// 主机和port，在互联网上一般指域名
			con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");// 本机的相关系信息。包含浏览器类型、操作系统信息等，非常多站点能够显示出你所使用的浏览器和操作系统版本号，就是由于能够从这里获取到这些信息。
			Document doc=con.get();//---请求方式
			
			
			
			Elements el=doc.select("tbody").get(0).select("tr");
			for(int i=1;i<el.size();i++){
				Elements tds=el.get(i).select("td");
				Aqiday aqidaybean=new Aqiday();
				for(int j=0;j<tds.size();j++){
					Element td=tds.get(j);
					String content=td.text();
					if(j==0){
						aqidaybean.setCityname(cityname);
						aqidaybean.setDay(content);
						System.out.print("日期："+td.text()+"\t");
					}else if(j==1){
						aqidaybean.setAqi(content);
						System.out.print("AQI："+td.text()+"\t");
					}/*else if(j==2){
						System.out.print("范围："+td.text()+"\t");
						String rangeaqi=td.text();
						int index=rangeaqi.indexOf("~");
						String min=rangeaqi.substring(0, index);
						String max=rangeaqi.substring(index+1, rangeaqi.length());
						aqidaybean.setMinaqi(min);
						aqidaybean.setMaxaqi(max);
						System.out.print("最小值："+min+"最大值："+max+"\t");
					}*/else if(j==2){
						aqidaybean.setGrade(content);
						System.out.print("质量等级："+td.text()+"\t");
					}else if(j==3){
						aqidaybean.setPm(content);
						System.out.print("pm2.5："+td.text()+"\t");
					}else if(j==4){
						aqidaybean.setPmo(content);
						System.out.print("pm10："+td.text()+"\t");
					}else if(j==5){
						aqidaybean.setSo(content);
						System.out.print("so2："+td.text()+"\t");
					}else if(j==6){
						aqidaybean.setCo(content);
						System.out.print("co："+td.text()+"\t");
					}else if(j==7){
						aqidaybean.setNo(content);
						System.out.print("no2："+td.text()+"\t");
					}else if(j==8){
						aqidaybean.setO(content);
						System.out.print("o3："+td.text()+"\t");
					}else{
						//System.out.print("排名："+td.text()+"\t");
					}
				}
				System.out.println("");
				aqidayList.add(aqidaybean);
			}
			
		}
		catch (IOException e) {
			//insertAqiday(aqiurl,cityname);
			e.printStackTrace();
		}
		return aqidayList;
	}
	
	/**插入空气质量月全量
	 * @param cityname
	 * @return
	 * @throws Exception
	 */
	public List<Aqimonth> insertAqimonth(String cityname) throws Exception {
		String url="https://www.aqistudy.cn/historydata/monthdata.php?city="+cityname;
		List<Aqimonth> aqiList=new ArrayList<Aqimonth>();
		//String u="https://www.aqistudy.cn/historydata/daydata.php?city=北京&month=201312";
		try {
			Document doc=Jsoup.parse(new URL(url), 4000);
			Elements el=doc.select("tbody").get(0).select("tr");
			System.out.println("有条数："+(el.size()-1));
			for(int i=1;i<el.size();i++){
				Elements tds=el.get(i).select("td");
				Aqimonth aqibean=new Aqimonth();
				for(int j=0;j<tds.size();j++){
					Element td=tds.get(j);
					if(j==0){
					//	System.out.print("月份："+td.text()+"\t"+td.select("a").attr("abs:href")+"\t");
						aqibean.setCityname(cityname);
						aqibean.setMonth(td.text());
						aqibean.setAqiurl(td.select("a").attr("abs:href"));
					}else if(j==1){
						//System.out.print("AQI："+td.text()+"\t");
						aqibean.setAqi(td.text());
					}else if(j==2){
						//System.out.print("范围："+td.text()+"\t");
						String rangeaqi=td.text();
						int index=rangeaqi.indexOf("~");
						String min=rangeaqi.substring(0, index);
						String max=rangeaqi.substring(index+1, rangeaqi.length());
						//System.out.print("最小值："+min+"最大值："+max+"\t");
						aqibean.setMinaqi(min);
						aqibean.setMaxaqi(max);
					}else if(j==3){
						//System.out.print("质量等级："+td.text()+"\t");
						aqibean.setGrade(td.text());
					}else if(j==4){
						//System.out.print("pm2.5："+td.text()+"\t");
						aqibean.setPm(td.text());
					}else if(j==5){
					//	System.out.print("pm10："+td.text()+"\t");
						aqibean.setPmo(td.text());
					}else if(j==6){
					//	System.out.print("so2："+td.text()+"\t");
						aqibean.setSo(td.text());
					}else if(j==7){
					//	System.out.print("co："+td.text()+"\t");
						aqibean.setCo(td.text());
					}else if(j==8){
						//System.out.print("no2："+td.text()+"\t");
						aqibean.setNo(td.text());
					}else if(j==9){
						//System.out.print("o3："+td.text()+"\t");
						aqibean.setO(td.text());
					}else{
						//System.out.print("排名："+td.text()+"\t");
					}
				}
				//if(aqimonthService.findAqi(aqibean.getAqiurl())==0){
					aqiList.add(aqibean);
				//}
			//	System.out.println("");
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aqiList;
	}
}
