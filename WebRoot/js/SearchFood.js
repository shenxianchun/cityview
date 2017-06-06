$(function(){
	$("#search").click(function(){
		 var cityname=$("#province").val();
		 if(cityname==""){
			 alert("请选择市区");
			 return ;
		 }
		 $("#foodlist").empty();
		 
		 
		 $.ajax({
				type:'post',
				url:'food/findFoodAll.action',
				data:'{"cityname":"'+cityname+'"}',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				success:function(reponse){//返回json结果
					///alert(reponse);
					for(var i=0;i<reponse.length;i++){
						$("#foodlist").append("<a href='"+reponse[i].foodurl+"' target='_blank'>" +
								"<img class='lazy' data-original='"+reponse[i].imageurl+"' src='"+reponse[i].imageurl+"' width='210' height='140' style='display: block;'><div>" +
										"<span>"+reponse[i].title+"</span><font><i class='icon_huo'>" +
												"</i>热度 "+reponse[i].heat+"</font>" +
														"<p>"+reponse[i].introduction+"</p></div></a>");
					}
				}
			});
	})
})