package com.cityview.iptool;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 给出一种代理ip解决方案
 */
public class HttpsetIp {
	/**
	 * 设置代理ip
	 * @throws IOException
	 */
	public static void setProxyIp() {
		try {
			List<String> ipList = new ArrayList<>();
			BufferedReader proxyIpReader = new BufferedReader(new InputStreamReader(HttpsetIp.class.getResourceAsStream("/proxyip.txt")));
			
			String ip = "";
			while((ip = proxyIpReader.readLine()) != null) {
				ipList.add(ip);
			}
			
			Random random = new Random();
			int randomInt = random.nextInt(ipList.size());
			String ipport = ipList.get(randomInt);
			String proxyIp = ipport.substring(0, ipport.lastIndexOf(":"));
			String proxyPort = ipport.substring(ipport.lastIndexOf(":") + 1, ipport.length());
			
			System.setProperty("http.maxRedirects", "50");  
	        System.getProperties().setProperty("proxySet", "true");   
	        System.getProperties().setProperty("http.proxyHost", proxyIp);  
	        System.getProperties().setProperty("http.proxyPort", proxyPort);
	        
	        System.out.println("设置代理ip为：" + proxyIp + "端口号为：" + proxyPort);
		} catch (Exception e) {
			System.out.println("重新设置代理ip");
			setProxyIp();
		}
		  
		
	}
}
