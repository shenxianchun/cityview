$(function(){
	
	$(".jobupdate").css("display","none");
	$(".houseupdate").css("display","none");
	$(".weatherupdate").css("display","none");
	$(".aqiupdate").css("display","none");
	$(".viewupdate").css("display","none");
	$(".foodupdate").css("display","none");
	
	//工作数据更新---------------------------------
	$("#jobupdate").click(function(){
		var cityname=$("#province").val();
		
		var jobname=$("#position").val();
		
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		 if(jobname==""){
			 alert("输入您要更新的职位");
		 }
		 $("#jobupdate").css("display","none");
		 $(".jobupdate").css("display","block");
		 
		 $.ajax({
				type:'post',
				url:'job/insertJob.action',
				//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
				contentType:'application/json;charset=utf-8',
				//数据格式是json串，商品信息
				data:'{"cityname":"'+cityname+'","name":"'+jobname+'"}',
				success:function(data){
					alert(data);
					$("#jobupdate").css("display","block");
					$(".jobupdate").css("display","none");
				}
			})
	})
	
	//更新房屋数据---------------------------------
	$("#houseupdate").click(function(){
		var cityname=$("#province").val();
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		$("#houseupdate").css("display","none");
		 $(".houseupdate").css("display","block");
		$.ajax({
			type:'post',
			url:'houses/insertHouses.action',
			//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，商品信息
			data:'{"cityname":"'+cityname+'"}',
			success:function(data){
				alert(data);
				$("#houseupdate").css("display","block");
				$(".houseupdate").css("display","none");
			}
		})
		
	})
	
	//更新城市气候数据
	$("#weatherupdate").click(function(){
		var cityname=$("#province").val();
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		$("#weatherupdate").css("display","none");
		 $(".weatherupdate").css("display","block");
		$.ajax({
			type:'post',
			url:'weather/insertWeatherMonth.action',
			//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，商品信息
			data:'{"cityname":"'+cityname+'"}',
			success:function(data){
				alert(data);
				$("#weatherupdate").css("display","block");
				$(".weatherupdate").css("display","none");
			}
		})
		
		
	})
	
	
	//更新空气质量指数数据
	$("#aqiupdate").click(function(){
		var cityname=$("#province").val();
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		$("#aqiupdate").css("display","none");
		 $(".aqiupdate").css("display","block");
		$.ajax({
			type:'post',
			url:'aqimonth/insert.action',
			//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，商品信息
			data:'{"cityname":"'+cityname+'"}',
			success:function(data){
				alert(data);
				$("#aqiupdate").css("display","block");
				$(".aqiupdate").css("display","none");
			}
		})
		
	})
	
	//更新旅游景点数据
	$("#viewupdate").click(function(){
		var cityname=$("#province").val();
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		$("#viewupdate").css("display","none");
		 $(".viewupdate").css("display","block");
		$.ajax({
			type:'post',
			url:'view/insertView.action',
			//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，商品信息
			data:'{"cityname":"'+cityname+'"}',
			success:function(data){
				$("#viewupdate").css("display","block");
				$(".viewupdate").css("display","none");
				alert(data);
			}
		})
		
	})
	
	//更新美食数据
	$("#foodupdate").click(function(){
		var cityname=$("#province").val();
		if(cityname==""){
			 alert("请选择更新的城市");
			 return ;
		 }
		$("#foodupdate").css("display","none");
		 $(".foodupdate").css("display","block");
		$.ajax({
			type:'post',
			url:'food/insertFood.action',
			//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
			contentType:'application/json;charset=utf-8',
			//数据格式是json串，商品信息
			data:'{"cityname":"'+cityname+'"}',
			success:function(data){
				$("#foodupdate").css("display","block");
				$(".foodupdate").css("display","none");
				alert(data);
			}
		})
	})
	
	
})