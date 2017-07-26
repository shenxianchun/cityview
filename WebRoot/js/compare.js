$(function(){
	
	$("#compare").click(function(){
		
		var cityname=$("#province").val();
		var cityname02=$("#province02").val();
		if(cityname==""){
			alert("请选择第一座城市");
			return;
		}
		if(cityname02==""){
			alert("请选择第二座城市");
			return;
		}
		
		if(cityname==cityname02){
			alert("请选择不同的数据");
			return;
		}
		
		
		
		
	})
})