package com.cityview.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtractTianqi {

	public static void main(String[] args)throws Exception {
        String str = "自2011-01-01到2017-03-01，北京共出现：多云731天，晴693天，雨428天，阴168天，99天，雪71天，沙尘6天。关注北京历史天气，关注天气网！";
        int x=str.indexOf("：");
        int y=str.indexOf("。");
        String s=str.substring(x+1, y);
       // System.out.println(s);
        String[] a=s.split("，");
        for(int k=0;k<a.length;k++){
        	//System.out.println(a[k]);
        	Map<String,String> map=strs(a[k]);
        	Set<String> set = map.keySet();
    		Iterator<String> it = set.iterator();
    		while (it.hasNext()) {
    			String key = it.next();
				String value = map.get(key);
    			System.out.println("天气:"+key+";一共："+value+"天");
    		}
        }
    }
	public static Map<String,String> strs(String s){
		Map<String,String> map=new HashMap<String, String>();		
        StringBuffer sb = new StringBuffer();
        StringBuffer key=new StringBuffer();
        boolean find = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                find = true;
            }else{
                find = false;
            }
            if(find){
                sb.append(ch);
            }else{
            	if(ch!='天'){
            		key.append(ch);
            	}
            }
        }
        if(!"".equals(key.toString())){
    	  map.put(key.toString(), sb.toString());
        }
		return map;
	}
}
