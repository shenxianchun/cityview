$(function(){
	$.ajax({
		type:'post',
		url:'view/findViewAll.action',
		data:'{"cityname":"北京"}',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		success:function(reponse){//返回json结果
			//alert(reponse);
			for(var i=0;i<reponse.length;i++){
				$("#viewlist").append("<li class=''>" +
						"<a href='"+reponse[i].viewurl+"' class='pic'><div class='icon'><sup class='t2'>NO."+(i+1)+"</sup></div> " +
								"<img class='lazy' data-original='"+reponse[i].imageurl+"' src='"+reponse[i].imageurl+"' width='287' height='190' alt='"+reponse[i].title+"' style='display: block;'>" +
										"<div class='title'> <b>"+reponse[i].title+"</b> " +
												"<span>"+reponse[i].peoplenum+"人想去</span></div></a><div class='text_con'> " +
														"<p>"+reponse[i].introduction+"</p><div class='num'>" +
																"<span class='price'>¥<b>"+reponse[i].price+"</b>起</span></div></div></li>");
			}
		}
	});
})