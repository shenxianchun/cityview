<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>宜居城市信息可视化平台</title>
	<link rel="stylesheet" href="css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
	/*============修饰图标*/
	 .ico{ width: 20px; height: 20px; display:block;   position: absolute; left: 20px; top: 10px; background-repeat: no-repeat; background-image: url(images/ico1.png); }
	 /*============小箭头*/
	 .level1 i{ width: 20px; height: 10px; background-image:url(images/arrow.png); background-repeat: no-repeat; display: block; position: absolute; right: 20px; top: 20px; }
	#companynature,#scale{
		width:700px;
		height:300px;
		margin:0 auto;
		background-color:#948;
	}
	#industry{
		width:1000px;
		height:300px;
		margin:0 auto;
		background-color:#948;
	}
	</style>
</head>
<body>
	<div class="login" style="color:#fff;">当前所在的城市：<span id="cityname"></span></div>
	<div class="line">
		<div class="top">宜居城市信息可视化平台</div>
		<!--导航栏start-->
		<div class="t_navigation">
			<div id="topmenu" class="ui inverted  menu">
				<a href="index.jsp" class="item">首页</a>
				<a href="" class="item">招聘信息</a>
				<a href="" class="item">房租信息</a>
				<a href="" class="item">城市气候</a>
				<a href="" class="item">空气质量指数</a>
				<a href="" class="item">城市旅游景点</a>
				<a href="" class="item">城市美食</a>
				<a href="" class="item">数据更新</a>
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
				<li><a href="index.jsp">公司相关统计</a></li>
				<li><a href="javascript:;">需求关系</a></li>
				<li><a href="javascript:;">工资关系</a></li>
			</ul>
		</li>
		<li class="level1">
			<a href="#none"><em class="ico ico2"></em>房租信息<i></i></a>
			<ul class="level2">
				<li><a href="javascript:;">中介统计</a></li>
				<li><a href="javascript:;">租金关系</a></li>
				<li><a href="javascript:;">区域统计</a></li>
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
	</ul>
</div>
<!--二级导航栏end-->
<div class="search">
			<table class="ui table">
				<tr align="center">
					<td width="250px" style="color:red;text-align:left;">首页</td>
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
		<img src="images/logo.png">
		<div class="online">
			<div id="companynature">
				<!-- 公司类型 -->
			</div>
			<div id="scale">
				<!-- 公司规模 -->
			</div>
			<div id="industry">
				<!-- 公司行业 -->
			</div>
		</div>
	</div>
<!--内容栏end-->
<!--底边start-->
<!-- <div class="bottom">
      <ul class="bottom-left">
        <li>
          <ul>
            <li class="titles">可视化平台</li>
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
            <li><a href="#">统计图表</a></li>
            <li><a href="#">数据展示</a></li>
            <li><a href="#">数据处理</a></li>
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
      <ul class="bottom-right">
        <li class="phone"></li>
        <li class="code">4008-310-100</li>
        <li>周一至周日 9:00-23:00</li>
        <li>（仅收市话费）</li>
      </ul>
      <p>Copyright ©2017-2018 宜居城市可视化平台版权所有 - <a href="http://www.miitbeian.gov.cn/" target="blank_">辽ICP备16019394号</a></p>
    </div> --><!-- 底部结束 -->
<!--底边start-->

<script type="text/javascript" src="js/echarts-all.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<!-- 招聘统计 -->
<script type="text/javascript" src="js/index.js"></script>


<!-- 查询省对应的市区 -->
<script type="text/javascript" src="js/city.js"></script>



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