<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>历史天气详情统计</title>
	<link rel="stylesheet" href="../css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<style type="text/css">
	/*============修饰图标*/
	 .ico{ width: 20px; height: 20px; display:block;   position: absolute; left: 20px; top: 10px; background-repeat: no-repeat; background-image: url(../images/ico1.png); }
	 /*============小箭头*/
	 .level1 i{ width: 20px; height: 10px; background-image:url(../images/arrow.png); background-repeat: no-repeat; display: block; position: absolute; right: 20px; top: 20px; }
	</style>
</head>
<body>
	<div class="login"></div>
	<div class="line">
		<div class="top">宜居城市可视化平台</div>
		<!--导航栏start-->
		<div class="t_navigation">
			<div id="topmenu" class="ui inverted  menu">
				<a href="" class="item">首页</a>
				<a href="" class="item">招聘信息</a>
				<a href="" class="item">房租信息</a>
				<a href="" class="item">城市气候</a>
				<a href="/cityview/monthaqi.html" class="item">空气质量指数</a>
				<a href="" class="item">城市旅游景点</a>
				<a href="" class="item">城市美食</a>
			</div>
		</div>
		<!--导航栏end-->
	</div>
	<!--二级导航栏start-->
	<div class="treebox">
	<ul class="menu">
		<li class="level1">
			<a href="#none" style="border-bottom:none;"></a>
		</li>
		<li class="level1">
			<a href="#none"></a>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico1"></em>招聘信息<i class="down"></i></a>
			<ul class="level2">
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico2"></em>房租信息<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico3"></em>城市气候<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">历史天气统计</a></li>
				<li><a href="javascript:;">历史风向统计</a></li>
				<li><a href="javascript:;">风力统计</a></li>
				<li><a href="javascript:;">历史天气详情</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico4"></em>空气质量指数<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">表格月统计数据</a></li>
				<li><a href="javascript:;">图表月统计数据</a></li>
				<li><a href="javascript:;">月变化趋势</a></li>
				<li><a href="javascript:;">等级变化趋势</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico5"></em>旅游景点<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico5"></em>城市美食<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
				<li><a href="javascript:;">导航选项</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--二级导航栏end-->
<div class="search">
			<table class="ui table">
				<tr align="center">
					<td width="200px" style="color:red;text-align:left;">当前的位置>>历史天气详情</td>
					<td style="font-size:24px;color:rgba(18, 222, 17, 0.67); width:200px;">历史天气详情数据</td>
					<td width="240px">
						<div class="ui dropdown">
							<input type="hidden" id="information" value=""/>
							<div class="default text">选择查看的日期</div>
							<i class="dropdown icon"></i><!-- 向下的箭头 -->
							<div class="menu">
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2012-07'>2012-07</a></div>
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2013-07'>2013-07</a></div>
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2013-02'>2013-02</a></div>
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2014-07'>2014-07</a></div>
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2015-07'>2015-07</a></div>
								<div class="item"><a href='weatherday.jsp?cityname=<%=request.getParameter("cityname") %>&date=2016-07'>2016-07</a></div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
<!--内容栏start-->
	<div class="content">
		<img src="../images/logo.png">
		<div class="online">
			<!--AQI月统计start-->
			<div>
			<div id="wendu" style="width:800px;height:300px;margin:0 auto;margin-top:20px;">
				<!-- 温度趋势 -->
			</div>
				<div class="title">
					<span class="cityname">
						<span id="cityname_city"><%=request.getParameter("cityname") %></span>
						<span id="date"><%=request.getParameter("date") %></span>
					</span>天气详情
				</div>
				<div class="monthaqi">
					<table width="900px" class="ui selectable celled table" style="text-align: center;">
						<thead >
							<tr>
								<th width="70px" height="50px" style="background-color:#38C19B;">日期</th>
								<th width="70px" style="background-color:#38C19B;">最高气温</th>
								<th width="70px" style="background-color:#38C19B;">最低气温</th>
								<th width="70px" style="background-color:#38C19B;">天气</th>
								<th width="70px" style="background-color:#38C19B;">风向</th>
								<th width="70px" style="background-color:#38C19B;">风力</th>
							</tr>
						</thead>
						<tbody id="weachermonth-table">
							<!--天气状况月详情列表 -->
							
						</tbody>
					</table>
				</div>
			</div>
			<!--AQI月统计start-->
			
			<!--AQT月变化趋势start-->
			 <div id="monthchart">
			 	<div class="title2" style="margin-left:450px;">
			 		<span class="cityname">
						<span><%=request.getParameter("cityname") %></span>
						<span><%=request.getParameter("date") %></span>
			 		</span>月天气统计</div>
			 	<div id="weathercount" style="background:#333;width:800px;height:300px;margin:0 auto;" class="chr"></div>
			 </div>
			<!--AQT月变化趋势end-->
			
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

<script type="text/javascript" src="../js/echarts-all.js"></script>
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>

<script type="text/javascript" src="Monthweather.js"></script>

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