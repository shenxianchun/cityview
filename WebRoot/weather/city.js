$(function(){
	$.ajax({
		type:'post',
		url:'/cityview/city/city.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		success:function(data){//返回json结果
			for(var i=0;i<data.length;i++){
				$("#citylist").append("<div class='item' data-value='"+data[i].cityname+"'>"+data[i].cityname+"</div>");
			}
		}
	});
	
	 $("#city").change(function(){
		 $("#province").val('');
		 $("#province").next(".text").text('选择市区');
		 $("#provincelist").empty();
		 var cityname=$("#city").val();
		// alert(city);
		 $.ajax({
				type:'post',
				url:'/cityview/city/province.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串，市区
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					for(var i=0;i<data.length;i++){
						$("#provincelist").append("<div class='item' data-value='"+data[i].cityname+"'>"+data[i].cityname+"</div>");
					}
				}
			});
	 });
})