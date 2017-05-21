package com.cityview.bloomFilter;

/**
 * Created by Administrator on 2017/1/14.
 */
public class Test {

    private final static String[] URLS = {
            "http://www.csdn.net/",
            "http://www.baidu.com/",
            "http://www.google.com.hk",
            "http://www.cnblogs.com/",
            "http://www.zhihu.com/",
            "https://www.shiyanlou.com/",
            "http://www.google.com.hk",
            "https://www.shiyanlou.com/",
            "http://www.csdn.net/"
    };

   
        

    public static void main(String[] args) {
    	BloomFilter filter = BloomFilter.getIstance();
        for (int i = 0; i < URLS.length; i++) {
            if (filter.contains(URLS[i])) {
//                System.out.println("contain: " + URLS[i]);
            	System.out.println("已存在"+URLS[i]);
                continue;
            }
            filter.add(URLS[i]);
            System.out.println("add:"+URLS[i]);
        }
        
        BloomFilter filter2 = BloomFilter.getIstance();
    	String[] url2={
                "http://www.csdn.net/",
                "http://www.baidu.com/",
                "http://www.google.com.hk",
                "http://www.cnblogs.com/",
                "http://www.zhihu.com/",
                "https://www.shiyanlou.com/",
                "http://www.google.com.hk",
                "https://www.shiyanlou.com/",
                "https://www.keshun.com/",
                "http://www.shenxianchun.net/"
        };
    	System.out.println("==================================");
    	for (int i = 0; i < url2.length; i++) {
            if (filter2.contains(url2[i])) {
            	System.out.println("已存在"+url2[i]);
                continue;
            }
            filter2.add(url2[i]);
            System.out.println("add-----:"+url2[i]);
        }
    	
    	
    	 BloomFilter filter3 = BloomFilter.getIstance();
     	String[] url3={
                 "http://www.csdn.net/",
                 "http://www.baidu.com/",
                 "http://www.google.com.hk",
                 "http://www.cnblogs.com/",
                 "http://www.zhihu.com/",
                 "https://www.shiyanlou.com/",
                 "http://www.google.com.hk",
                 "https://www.shiyanlou.com/",
                 "https://www.keshun.com/",
                 "http://www.shenxianchun.net/"
         };
     	System.out.println("==================================");
     	for (int i = 0; i < url3.length; i++) {
             if (filter3.contains(url3[i])) {
             	System.out.println("已存在"+url3[i]);
                 continue;
             }
             filter3.add(url3[i]);
             System.out.println("add===:"+url3[i]);
         }
    	
    	
    	
//    	BloomFilter a=BloomFilter.getIstance();
//    	
//    	BloomFilter b=BloomFilter.getIstance();
//    	BloomFilter c=BloomFilter.getIstance();
//    	System.out.println((a==b)+":"+(a==c));
//        Test t = new Test();
//        t.testBloomFilter();
//        System.out.println("------------------------------------------");
//        Test tt = new Test();
//        tt.testBloomFilter();

    	
//    	SingletonTest te1=SingletonTest.getIstance();
//    	
//    	SingletonTest te2=SingletonTest.getIstance();
//    	
//    	System.out.println(te1==te2);
    	
    }
}
