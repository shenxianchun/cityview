package com.cityview.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cityview.po.Houses;
import com.cityview.service.HousesService;
import com.cityview.spider.HouseSpider;
import com.cityview.tool.pingying;

/**
* <p>Title: HousesController.java<／p>
* <p>Description:描述:租房信息 <／p>
* <p>Copyright:版权 2017<／p>
* @author 沈先春
* @date 2017年5月23日
* @version 1.0cityview
*/
@Controller
@RequestMapping("/houses")
public class HousesController {
	@Autowired
	private HousesService housesService;
	
	/**
	 * 批量插入房租数据信息
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertHouses")
	public @ResponseBody String insertHouses(@RequestBody Houses houses)throws Exception{
		String cityname=houses.getCityname();
		String url="http://"+pingying.getFirstSpell(cityname)+".ganji.com/fang1/";
	//	List<Houses> houseslist=new ArrayList<Houses>();
		try {
			Document doc=Jsoup.parse(new URL(url), 2000);
			Element fangs=doc.select(".num").get(0);
			//得到满足房子的总数
			String num=fangs.text().substring(0, fangs.text().length()-1);
			int nums=Integer.parseInt(num);
			//计算一共有多少页
			int pages=nums/83;
			int page=0;
			if(pages>40){
				page=40;
			}else{
				page=pages;
			}
			System.out.println("房子的页数:"+page);
			for(int i=1;i<=page;i++){
				List<Houses> houseslist=HouseSpider.getHouses(page,cityname);
				if(houseslist.size()>0){
					housesService.insertHouseslist(houseslist);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "插入成功";
	}
	
	/**
	 * 统计房子的朝向和价格的关系
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findFacePrice")
	public @ResponseBody List<Houses> findFacePrice(@RequestBody Houses houses)throws Exception{
		
		List<Houses> facelist=housesService.findFaceprice(houses.getCityname());
		
		return facelist;
	}
	
	/**
	 * 统计房子的装修风格和价格的关系
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findRenovationPrice")
	public @ResponseBody List<Houses> findRenovationPrice(@RequestBody Houses houses)throws Exception{
		
		List<Houses> renovationlist=housesService.findFaceRenovation(houses.getCityname());
		
		return renovationlist;
	}
	
	/**
	 * 统计城市中的房屋中介公司
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAgencytotal")
	public @ResponseBody List<Houses> findAgencytotal(@RequestBody Houses houses)throws Exception{
		
		List<Houses> agencylist=housesService.findAgencytotal(houses.getCityname());
		
		return agencylist;
	}
	
	/**
	 *统计区域哪块租房最贵
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAreaPrice")
	public @ResponseBody List<Houses> findAreaPrice(@RequestBody Houses houses)throws Exception{
		
		List<Houses> arealist=housesService.findAreaPrice(houses.getCityname());
		
		return arealist;
	}
	
	/**
	 *	统计不同户型的价格关系
	 * @param houses
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAreaPrice")
	public @ResponseBody List<Houses> findTypePrice(@RequestBody Houses houses)throws Exception{
		
		List<Houses> arealist=housesService.findTypePrice(houses.getCityname());
		
		return arealist;
	}
	
	
}
