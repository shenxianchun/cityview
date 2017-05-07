$(function(){
	$.ajax({
		type:'post',
		url:'aqimonth/table.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"北京"}',
		success:function(data){//返回json结果
			for(var i=0;i<data.length;i++){
				$("#aqimonth-table").append("<tr>"+
						"<td><a href='"+data[i].aqiurl+"'>"+data[i].month+"</a></td>"+
						"<td>"+data[i].aqi+"</td>"+
						"<td>"+data[i].minaqi+"~"+data[i].maxaqi+"</td>" +
						"<td><div style='width:65px;height:20px;color:black;'>"+data[i].grade+"</div></td>" +
						"<td>"+data[i].pm+"</td>" +
						"<td>"+data[i].pmo+"</td>" +
						"<td>"+data[i].so+"</td>" +
						"<td>"+data[i].co+"</td>" +
						"<td>"+data[i].no+"</td>" +
						"<td>"+data[i].o+"</td>" +
						"</tr>");
			}
		}
	});
	
})