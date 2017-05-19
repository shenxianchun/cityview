package com.cityview.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageDownload {

	public static String imgname(String imgurl,String filename) throws Exception {
		String path=System.getProperty("user.dir").replace('\\','/');
		//String imgurl="http://p1.cncnimg.cn/eat/1/1362.jpg";
		System.out.println(path);
		int index=imgurl.lastIndexOf("/");
		String imgname=imgurl.substring(index+1, imgurl.length());
		
		System.out.println(imgname);
		
		URL url=new URL(imgurl);
		
		URLConnection con=url.openConnection();
		InputStream in=con.getInputStream();
		
		File file=new File(path+"/workspace/cityview/WebRoot/"+filename+"/"+imgname);
		
		FileOutputStream out=new FileOutputStream(file);
		int i=0;
		while((i=in.read())!=-1){
			out.write(i);
		}
		System.out.println("图片"+imgname+"下载成功");
		out.close();
		in.close();
		return imgname;
	}
}
