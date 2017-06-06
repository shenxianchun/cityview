<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>美食统计</title>
	<link rel="stylesheet" href="css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
	/*美食css start*/
	.food_li{ overflow:hidden; padding-right:0;}
	.food_li .a{ margin-left:22px;}
	.food_li .a a{ float:left; width:210px; height:270px; margin:20px 0 0 46px; -webkit-transition: all .3s linear; transition: all .3s linear;}
	.food_li .a img{ width:210px; display:block; height:140px;}
	.food_li .a span{ font-size:16px; line-height:41px; display:inline-block; max-width:105px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap; vertical-align:top;}
	.food_li .a font{ float:right; font-size:12px; color:#999; line-height:41px;}
	.food_li .a p{ border-top:#ddd dotted 1px; padding-top:6px; color:#666; height:84px; overflow:hidden;}
	.food_li .a div{ border:#ddd solid 1px; border-top:0; padding:5px; padding-top:0; height:124px;}
	.food_li .a i{ margin:11px 5px 0 0;}
	.food_li .a a:hover{ box-shadow:0px 0 6px rgba(0, 0, 0, 0.2); -webkit-transform: translate3d(0, -3px, 0); transform: translate3d(0, -3px, 0);text-decoration: none;}

	.food_li .t{ margin-bottom:20px; background:#f4f4f4; line-height:40px; height:40px; border-bottom:#ddd solid 1px; font-size:16px; color:#666; padding-left:20px;margin-right:0; margin-bottom:0;text-align: center;}

	/*美食css end*/

	#bottommenu{background-color: #6d6363;}
	</style>
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
			<a href="" class="item right">数据更新</a>
		</div>
	</div>
	<!--导航栏end-->

	<!-- 搜索start -->
	<div class="search">
		<table class="ui table" style="background:rgba(228, 241, 221, 0.26);">
			<tr align="center">
				<td width="250px" style="color:red;text-align:left;">美食城</td>
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
	<!-- 搜索end -->

<!--内容栏start-->
	<div class="content">
		<div class="online">
			<div class="food_li">
				<div class="t"><%=session.getAttribute("cityname") %>美食</div>
				<div class="a" id="foodlist">
					<!-- 美食列表 -->
				</div>
			</div>
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
<script type="text/javascript" src="js/food.js"></script>

<script type="text/javascript" src="js/SearchFood.js"></script>


<script type="text/javascript">
$(function(){
	$(".treebox .level1>a").click(function(){
		$(this).addClass('current')   //给当前元素添加"current"样式
		.find('i').addClass('down')   //小箭头向下样式
		.parent().next().slideDown('slow','easeOutQuad')  //下一个元素显示
		.parent().siblings().children('a').removeClass('current')//父元素的兄弟元素的子元素去除"current"样式
		.find('i').removeClass('down').parent().next().slideUp('slow','easeOutQuad');//隐藏
		 return false; //阻止默认时间
	});
})
$(document).ready(function(){
	$(".ui.dropdown").dropdown();
});
</script>
</body>
</html>