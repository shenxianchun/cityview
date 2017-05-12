package cn.com.webxml;

import java.util.List;

public class IpTest {

	public static List<String> iptest(String ip) {
		IpAddressSearchWebService ipaddress=new IpAddressSearchWebService();
		IpAddressSearchWebServiceSoap ips=ipaddress.getIpAddressSearchWebServiceSoap();
		List<String> iplist=ips.getCountryCityByIp(ip).getString();
//		for(String s:iplist){
//			System.out.println(s.toString());
//		}
		return iplist;
	}

}
