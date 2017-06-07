<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>空气质量数统计</title>
	<link rel="stylesheet" href="css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="main">
	<div class="login" style="color:#fff;">当前所在的城市：<span id="cityname"><%=session.getAttribute("cityname") %></span></div>
	<!--导航栏start-->
	<div class="line">
		<div class="top">宜居城市信息可视化平台</div>
		<div id="topmenu" class="ui inverted red menu">
			<a href="index.jsp" class="item">首页</a>
			<a href="job/job.jsp" class="item">招聘信息</a>
			<a href="house/house.jsp" class="item">房租信息</a>
			<a href="weather/weather.jsp" class="item">城市气候</a>
			<a href="monthaqi.jsp" class="item">空气质量指数</a>
			<a href="view.jsp" class="item">城市旅游景点</a>
			<a href="food.jsp" class="item">城市美食</a>
			<a href="update.jsp" class="item right">数据更新</a>
		</div>
	</div>
	<!--导航栏end-->

	<div class="search">
		<table class="ui table" style="background:rgba(228, 241, 221, 0.26);">
			<tr align="center">
				<td width="250px" style="color:red;text-align:left;">空气质量指数查看</td>
				<td width="90px">选择城市:</td>
				<td width="100px">
					  <div class="ui dropdown">
						<input type="hidden" id="city" value=""/>
						<div class="default text">选择城市</div>
						<i class="dropdown icon"></i><!-- 向下的箭头 -->
						<div class="menu" id="citylist">
							<!--省份列表  -->
						</div>
					</div>
				</td>
				<td width="80px">选择市区:</td>
				<td width="120px">
					<div class="ui dropdown">
						<input type="hidden" id="province" value=""/>
						<div class="default text">先选择市区</div>
						<i class="dropdown icon"></i><!-- 向下的箭头 -->
						<div class="menu" id="provincelist">
							<!--市区列表  -->
						</div>
					</div>
				</td>
				<td align="right">
					<button class="ui primary button" id="search">搜索</button>
				</td>
			</tr>
		</table>
	</div>

<!--内容栏start-->
	<div class="content">
		<div class="online">
			<!--AQI月统计start-->
			<div>
				<div class="title"><span class="cityname"></span>空气质量指数月统计历史数据</div>
				<div class="monthaqi">
					<table width="900px" class="ui selectable celled table" style="text-align: center;">
						<thead >
							<tr>
								<th width="70px" height="50px" style="background-color:#38C19B;">月份</th>
								<th width="70px" style="background-color:#38C19B;">AQI</th>
								<th width="70px" style="background-color:#38C19B;">范围</th>
								<th width="70px" style="background-color:#38C19B;">质量等级</th>
								<th width="70px" style="background-color:#38C19B;">PM2.5</th>
								<th width="70px" style="background-color:#38C19B;">PM10</th>
								<th width="70px" style="background-color:#38C19B;">SO2</th>
								<th width="70px" style="background-color:#38C19B;">CO</th>
								<th width="70px" style="background-color:#38C19B;">NO2</th>
								<th width="70px" style="background-color:#38C19B;">O3</th>
							</tr>
						</thead>
						<tbody id="aqimonth-table">
							<!-- 空气质量指数月全量指数统计列表 -->
						</tbody>
					</table>
				</div>
			</div>
			<!--AQI月统计start-->
			
			<!--AQT月变化趋势start-->
			 <div id="monthchart">
			 	<div class="title2"><span class="cityname"></span>空气质量指数（AQI）月变化趋势</div>
			 	<div id="container" class="chr"></div>
			 </div>
			<!--AQT月变化趋势end-->
				
			<div class="count">
				<div class="title3"><span class="cityname"></span>空气质量指数（AQI）等级月变化趋势</div>
				<div id="aqimonthcount" class="chr"></div>
			</div>
			<!-- 饼图统计start -->
			<div class="countday">
				<!--AQI月统计数据start-->
				<div id="monthcount" class="chr"></div> 
				<!--AQI月统计数据end-->
				
				<!--AQI日统计数据start-->
				<div id="daycount" class="chr"></div> 
				<!--AQI日统计数据end-->
			</div>
			<!-- 饼图统计end -->
		</div>
	</div>
<!--内容栏end-->
<!-- 底部开始 -->
	<div class="bottom">
      <ul class="bottom-left">
        <li>
          <ul>
            <li class="titles">关于可视化</li>
            <li><a href="#">联系我们</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="#">友情链接</a></li>
          </ul>
        </li>
        <li>
          <ul>
            <li class="titles">帮助中心</li>
            <li><a href="#">意见反馈</a></li>
            <li><a href="#">投诉中心</a></li>
            <li><a href="#">服务说明</a></li>
          </ul>
        </li>
        <li>
          <ul>
            <li class="titles">平台特色</li>
            <li><a href="#">安全可靠</a></li>
            <li><a href="#">数据真实</a></li>
            <li><a href="#">数据统计</a></li>
          </ul>
        </li>
        <li>
          <ul>
            <li class="titles">关注我们</li>
            <li><a href="#">官方微信</a></li>
            <li><a href="#">新浪微博</a></li>
            <li><a href="#">腾讯微博</a></li>
          </ul>
        </li>
      </ul>
      <p>Copyright ©2017-2018 宜居城市可视化平台网版权所有 - <a href="http://www.miitbeian.gov.cn/" target="blank_">辽ICP备16019394号</a></p>
    </div><!-- 底部结束 -->
</div>
<script type="text/javascript" src="js/echarts-all.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>

<!-- 查询省对应的市区 -->
<script type="text/javascript" src="js/city.js"></script>
<!-- 以下为统计图 -->
<script type="text/javascript" src="js/aqimonth-table.js"></script>
<script type="text/javascript" src="js/searchaqi.js"></script>

<script type="text/javascript">
$(function(){
	$(".ui.dropdown").dropdown();//下拉框生效
	$(".treebox .level1>a").click(function(){
		$(this).addClass('current')   //给当前元素添加"current"样式
		.find('i').addClass('down')   //小箭头向下样式
		.parent().next().slideDown('slow','easeOutQuad')  //下一个元素显示
		.parent().siblings().children('a').removeClass('current')//父元素的兄弟元素的子元素去除"current"样式
		.find('i').removeClass('down').parent().next().slideUp('slow','easeOutQuad');//隐藏
		 return false; //阻止默认时间
	});
})
</script>
</body>
</html>