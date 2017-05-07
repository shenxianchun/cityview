package com.cityview.iptool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class IpTest {
	
	public static void main(String[] args) {
		String ip="124.88.67.32";
		int port=83;
		createIPAddress(ip,port);
	}
	
public static void createIPAddress(String ip,int port) {
	URL url = null;
	try {
		url = new URL("http://www.baidu.com");
	} catch (MalformedURLException e) {
		System.out.println("url invalidate");
	}
		InetSocketAddress addr = null;
		addr = new InetSocketAddress(ip, port);
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http proxy
		InputStream in = null;
	try {
		URLConnection conn = url.openConnection(proxy);
		conn.setConnectTimeout(1000);
		in = conn.getInputStream();
	} catch (Exception e) {
		System.out.println("ip " + ip + "不可用");//异常IP
	}
		String s = convertStreamToString(in);
		System.out.println(s);
		// System.out.println(s);
		if (s.indexOf("baidu") > 0) {//有效IP
			System.out.println(ip + ":"+port+ "有效");
	}
}
	
public static String convertStreamToString(InputStream is) {
        if (is == null)
        	return "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
	try {
	    while ((line = reader.readLine()) != null) {
	    sb.append(line + "/n");
	        }
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } finally {
		        try {
		        	is.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
	        }
        return sb.toString();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//判断ip、端口是否可连接
	public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
         //   isHostConnectable(host,port);
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
	//判断ip是否可以连接 timeOut是超时时间
	public static boolean isHostReachable(String host, Integer timeOut) {
        try {
            return InetAddress.getByName(host).isReachable(timeOut);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	
}
