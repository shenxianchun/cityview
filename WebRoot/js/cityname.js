$(function(){
	$.ajax({
		type:'post',
		url:'city/IpgetCityname.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		success:function(cityname){//返回json结果
//			alert(cityname);
			/*location.reload();*/
		}
	})
})