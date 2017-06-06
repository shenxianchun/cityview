<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>风景统计</title>
	<link rel="stylesheet" href="css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
	/*风景css start*/
	.city_spots{ padding:70px; border:1px solid #ddd;overflow:hidden;}
	.city_spots ul{ width:960px; }
	.city_spots li{ width:287px; float:left; height:290px; margin:20px 15px 0px 0; -webkit-transition: all .3s linear; transition: all .3s linear;}
	.city_spots li a.pic{ position:relative; display:block;}
	
	.city_spots li .pic .icon{ position:absolute; top:0; left:15px;}
	.city_spots li .pic sub{ display:inline-block; width:31px; height:31px; line-height:24px; text-align:center; font-size:12px; vertical-align:top; color:#fff; background:url(mj/icon_index.png) no-repeat -93px -131px;}
	.city_spots li .pic sup{ display:inline-block; width:56px; height:36px; margin-right:5px; line-height:30px; font-size:16px; text-align:center; vertical-align:top; color:#fff; background:url(mj/icon_index.png) no-repeat 0 -164px;}
	.city_spots li .pic sup.t2{ background-position:-56px -164px; }
	.city_spots li .pic sup.t3{ background-position:-112px -164px; }
	.city_spots li .pic img{ display:block; }
	.city_spots li .pic .title{ position:absolute; bottom:0; left:0; height:40px; line-height:40px; width:256px; padding:0 15px; color:#fff; background-color:#000; background:rgba(0,0,0,0.5);filter:alpha(opacity=50);}
	.city_spots li .pic .title b{ font-size:18px; font-weight:normal;}
	.city_spots li .pic .title span{ float:right; }
	.city_spots li .text_con{ height:90px; border:1px solid #e6e6e6; padding:5px 10px; line-height:18px; color:#555;}
	.city_spots li .text_con p{ height:40px; padding-bottom:8px; margin-bottom:10px; line-height:20px; border-bottom:1px dotted #e6e6e6; overflow:hidden;}
	.city_spots li .text_con .num{ line-height:26px;}
	.city_spots li .text_con .num span.price{ display:inline-block; color:#999; vertical-align:middle;}
	.city_spots li .text_con .num span.price b{ display:inline-block; padding:0 3px; color:#f30; font-size:20px; font-weight:normal;}
	.city_spots li .text_con .num span.sale{ display:inline-block; height:12px; padding:0 3px 0 16px; margin:0 0 0 10px; line-height:12px; border:1px solid #ff8d30; color:#ff8d30; vertical-align:-2px; font-family:"simsum"; text-decoration:none; background:url(mj/icon_index.png) no-repeat -300px -24px}
	.city_spots li .text_con .num a.btn{ display:inline-block; float:right; padding:0 10px; color:#fff; border-radius:2px; background:#ff9911;}
	.city_spots li .text_con .num a.btn:hover{ color:#fff; background:#f70; }
	.city_spots li .text_con .num a.btn2{ color:#666; background:#eee;}
	.city_spots li.first{ display:block; width:887px; height:auto; margin:0;}
	.city_spots li.first .pic{ float:left; }
	.city_spots li.first .text_con{ display:block; padding:0; margin-left:306px; border:none; }
	.city_spots li.first .text_con p{ height:auto; line-height:24px; }
	.city_spots li.first .type{ display:inline-block; width:410px; float:left;}
	.city_spots li.first .type dl{ display:block; line-height:26px; }
	.city_spots li.first .type dt{ float:left; font-weight:bold; color:#333;}
	.city_spots li.first .type dd{ display:block; height:26px; margin-left:60px; text-overflow:ellipsis; white-space:nowrap; overflow:hidden;}
	.city_spots li.first .type dd b{ color:#f91; font-size:14px;}
	.city_spots li.first .num{ width:170px; float:right; padding-top:10px; text-align:right;}
	.city_spots li.first .num a.btn{ padding:0 15px; line-height:34px; font-size:14px;}
	.city_spots_list{
		margin-top:-60px;
		margin-left:50px;
	}
	.city_spots li:hover{ position:relative; box-shadow:0px 0 6px rgba(0, 0, 0, 0.2); -webkit-transform: translate3d(0, -3px, 0); transform: translate3d(0, -3px, 0);}
	.city_spots li.first:hover{ box-shadow:none; -webkit-transform:none; transform:none;}
	/*风景css end*/
	.t{
		margin-bottom: 20px;
	    background: #f4f4f4;
	    line-height: 40px;
	    height: 40px;
	    border-bottom: #ddd solid 1px;
	    font-size: 16px;
	    color: #666;
	    padding-left: 20px;
	    margin-right: 0;
	    margin-bottom: 0;
	    text-align: center;
	}
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
				<td width="250px" style="color:red;text-align:left;">旅游景点</td>
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
		<div class="t">北京景点大全</div>
			<div class="city_spots">
				<div class="city_spots_list">
					<ul id="viewlist">
						
					</ul>
				</div>
				<div class="first_con"> </div>
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
<script src="js/easing.js"></script>
<!-- 查询省对应的市区 -->
<script type="text/javascript" src="js/city.js"></script>

<script type="text/javascript" src="js/view.js"></script>

<script type="text/javascript" src="js/SearchView.js"></script>


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