<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$.ajax({
	/* type:'post', */
	/* url:'${pageContext.request.contextPath }/aqimonth/insert.action', */
	//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
	//contentType:'application/json;charset=utf-8',
	//数据格式是json串，商品信息
	/* data:'cityname=手机', */
	/* success:function(data){//返回json结果
		alert(data);
	} */
});
$.ajax({
	type:'post',
	url:'${pageContext.request.contextPath }/aqimonth/queryAqiDay.action?month=2016-10&cityname=深圳',
	//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
	//contentType:'application/json;charset=utf-8',
	//数据格式是json串，商品信息
	/* data:'cityname=手机', */
	success:function(data){//返回json结果
		alert(data);
	}
});


//请求json，输出是json
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/aqi/requestJson.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"北京"}',
		success:function(data){//返回json结果
			alert(data.cityname);
		}
	});
}
//请求key/value，输出是json
function responseJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/aqi/responseJson.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		//contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'cityname=手机',
		success:function(data){//返回json结果
			
			alert(data.cityname);
		}
	});
	
}


function responseip(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/aqi/responseip.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		//contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		/* data:'cityname=手机', */
		success:function(data){//返回json结果
			alert(data);
		}
	});
}
function responseday(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/aqimonth/queryAqiMonthCountGrade.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"深圳"}',
		success:function(data){
			alert(data);
		}
	});
	
}

function weather(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/weather/insertWeatherMonth.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"大连"}',
		success:function(data){
			alert(data);
		}
	});
	
}

function food(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/food/insertFood.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"上海"}',
		success:function(data){
			alert(data);
		}
	});
	
}
function view(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/view/insertView.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"上海"}',
		success:function(data){
			alert(data);
		}
	});
}

function job(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/job/insertJob.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"北京","name":"java"}',
		success:function(data){
			alert(data);
		}
	});
}

function houses(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/houses/insertHouses.action',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data:'{"cityname":"上海"}',
		success:function(data){
			alert(data);
		}
	});
}

</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
<input type="button" onclick="responseip()" value="访问者ip测试"/>
<input type="button" onclick="responseday()" value="每月统计天数测试"/>

<input type="button" onclick="weather()" value="插入历史天气"/>


<input type="button" onclick="food()" value="插入美食"/>
<input type="button" onclick="view()" value="插入风景"/>
<input type="button" onclick="job()" value="插入职位信息"/>
<input type="button" onclick="houses()" value="插入房租信息"/>
</body>
</html>