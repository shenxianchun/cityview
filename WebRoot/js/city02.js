$(function(){
	$.ajax({
		type:'post',
		url:'city/city.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		success:function(data){//返回json结果
			for(var i=0;i<data.length;i++){
				$("#citylist02").append("<div class='item' data-value='"+data[i].cityname+"'>"+data[i].cityname+"</div>");
			}
		}
	});
	
	 $("#city02").change(function(){
		 $("#province02").val('');
		 $("#province02").next(".text").text('选择市区');
		 $("#provincelist02").empty();
		 var cityname=$("#city02").val();
		// alert(city);
		 $.ajax({
				type:'post',
				url:'city/province.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串，市区
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					for(var i=0;i<data.length;i++){
						$("#provincelist02").append("<div class='item' data-value='"+data[i].cityname+"'>"+data[i].cityname+"</div>");
					}
				}
			});
	 });
})