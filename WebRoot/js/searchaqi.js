$(function(){
	$("#search").click(function(){
		 var cityname=$("#province").val();
		 if(cityname==""){
			 alert("请选择市区");
			 return ;
		 }
		 $("#aqimonth-table").empty();
		 $("#container").empty();
		 $("#aqimonthcount").empty();
		 $("#monthcount").empty();
		 $("#daycount").empty();
		 $(".cityname").empty();
		 $.ajax({
				type:'post',
				url:'aqimonth/table.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(response){//返回json结果
					var month=[];
					var datamin=[];
					var datamax=[];
					var dataver=[];
					$(".cityname").append(response[0].cityname);
					for(var i=0;i<response.length;i++){
						$("#aqimonth-table").append("<tr>"+
								"<td><a href='"+response[i].aqiurl+"'>"+response[i].month+"</a></td>"+
								"<td>"+response[i].aqi+"</td>"+
								"<td>"+response[i].minaqi+"~"+response[i].maxaqi+"</td>" +
								"<td><div style='width:65px;height:20px;color:black;'>"+response[i].grade+"</div></td>" +
								"<td>"+response[i].pm+"</td>" +
								"<td>"+response[i].pmo+"</td>" +
								"<td>"+response[i].so+"</td>" +
								"<td>"+response[i].co+"</td>" +
								"<td>"+response[i].no+"</td>" +
								"<td>"+response[i].o+"</td>" +
								"</tr>");
						month.push(response[i].month);
						datamin.push(response[i].minaqi);
						datamax.push(response[i].maxaqi);
						dataver.push(response[i].aqi);
					}
					option = {
						    tooltip : {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['最大值','平均值','最小值']
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						    xAxis : [
						        {
						            type : 'category',
						            boundaryGap : false,
						            data : month
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'最大值',
						            type:'line',
						            stack: '总量',
						            itemStyle: {normal: {areaStyle: {type: 'default'}}},
						            data:datamax
						        },
						        {
						            name:'平均值',
						            type:'line',
						            stack: '总量',
						            itemStyle: {normal: {areaStyle: {type: 'default'}}},
						            data:dataver
						        },
						        {
						            name:'最小值',
						            type:'line',
						            stack: '总量',
						            itemStyle: {normal: {areaStyle: {type: 'default'}}},
						            data:datamin
						        }
						    ]
						};             
						var mychart=echarts.init(document.getElementById("container"),"helianthus");
						mychart.setOption(option);
						
						var chart=echarts.init(document.getElementById("aqimonthcount"),"helianthus");
						chart.setOption(option);
				}
			});
	 });
})