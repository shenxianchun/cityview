$(function(){

	$.ajax({
		type:'post',
		url:'aqimonth/table.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"北京"}',
		success:function(response){//返回json结果
			var month=[];
			var datamin=[];
			var datamax=[];
			var dataver=[];
			$(".cityname").append(response[0].cityname);
			for(var i=0;i<response.length;i++){
				$("#aqimonth-table").append("<tr>"+
						"<td><a href=/cityview/aqi/dayaqi.jsp?cityname="+response[i].cityname+"&month="+response[i].month+">"+response[i].month+"</a></td>"+
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
				    tooltip: {//鼠标提示框
				    	show: true,
				    	z: 8,
				    	showContent: true,
				    	trigger: 'axis',//显示y轴的内容，为item显示x轴
//				    	formatter: '{a1}:{c1}, {a2}, {b2}, {c2},{a3}, {b3}, {c3}',
				    	//islandFormatter: '{a} < br/>{b} : {c}',
				    	showDelay: 20,
				    	hideDelay: 100,
				    	transitionDuration: 0.4,
				    	backgroundColor: '#FF0F46',//背景颜色
				    	borderColor: '#FF0F46',
				    	borderRadius: 4,
				    	borderWidth: 0,
				    	padding: 5,
				    	textStyle: {
//				    		color: 'blue',//文本的颜色
				    		decoration: 'none',
				    		fontFamily: 'Arial, Verdana, sans...',
				    		fontSize: 12
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
				            type : 'value',
			            	 axisLabel : {
					                formatter: '{value}μg/m3'
					            }
				        }
				    ],
				    
				    series : [
				        {
				            name:'最大值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:datamax
				        },
				        {
				            name:'平均值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:dataver
				        },
				        {
				            name:'最小值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:datamin
				        }
				    ]
				};
			
			var mychart=echarts.init(document.getElementById("container"),"shine");
			mychart.setOption(option);
//------------------------------------------------------------------------------------------------				
			
			option1 = {
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
				    tooltip: {//鼠标提示框
				    	show: true,
				    	z: 8,
				    	showContent: true,
				    	trigger: 'axis',//显示y轴的内容，为item显示x轴
//				    	formatter: '{a1}:{c1}, {a2}, {b2}, {c2},{a3}, {b3}, {c3}',
				    	//islandFormatter: '{a} < br/>{b} : {c}',
				    	showDelay: 20,
				    	hideDelay: 100,
				    	transitionDuration: 0.4,
				    	backgroundColor: '#FF0F46',//背景颜色
				    	borderColor: '#FF0F46',
				    	borderRadius: 4,
				    	borderWidth: 0,
				    	padding: 5,
				    	textStyle: {
//				    		color: 'blue',//文本的颜色
				    		decoration: 'none',
				    		fontFamily: 'Arial, Verdana, sans...',
				    		fontSize: 12
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
				            type : 'value',
			            	 axisLabel : {
					                formatter: '{value}天'
					            }
				        }
				    ],
				    
				    series : [
				        {
				            name:'最大值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:datamax
				        },
				        {
				            name:'平均值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:dataver
				        },
				        {
				            name:'最小值',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:datamin
				        }
				    ]
				};
				var chart=echarts.init(document.getElementById("aqimonthcount"),"helianthus");
				chart.setOption(option1);
		}
	});
})