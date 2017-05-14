$(function(){
	var date=$("#date").text();
	var cityname=$("#cityname_city").text();
//	alert("值为"+day+cityname);
	$.ajax({
		type:'post',
		url:'/cityview/weather/queryWeatherMonthAll.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"'+cityname+'","date":"'+date+'"}',
		success:function(response){//返回json结果
			var max=[],min=[],date=[];
			for(var i=0;i<response.length;i++){
				$("#weachermonth-table").append("<tr>" +
						"<td>"+response[i].date+"</td>" +
						"<td>"+response[i].maxtemperature+"</td>" +
						"<td>"+response[i].mintemperature+"</td>" +
						"<td>"+response[i].weather+"</td>" +
						"<td>"+response[i].direction+"</td>" +
						"<td>"+response[i].power+"</td>" +
						"</tr>");
				date.push(response[i].date);
				max.push(response[i].maxtemperature);
				min.push(response[i].mintemperature);
			}
			
			option = {
				    title : {
				        text: '气温变化',
				        subtext: '来自历史天气网',
				        x:'center',
				        y:'top'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				    	x: 'left',
				        data:['最高气温','最低气温']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {show: true, type: ['line', 'bar']},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'category',
				            boundaryGap : false,
				            data : date
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            axisLabel : {
				                formatter: '{value} °C'
				            }
				        }
				    ],
				    series : [
				        {
				            name:'最高气温',
				            type:'line',
				            data:max,
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            }
				        },
				        {
				            name:'最低气温',
				            type:'line',
				            data:min,
				            markPoint : {
				                data : [
				                    {name : '最低', value : -2, xAxis: 1, yAxis: -1.5}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name : '平均值'}
				                ]
				            }
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("wendu"),"macarons");
			mychart.setOption(option);
		}
	});
	$.ajax({
		type:'post',
		url:'/cityview/weather/queryCountMonthWeather.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"'+cityname+'","date":"'+date+'"}',
		success:function(response){//返回json结果
			console.log(response)
			var weatherKey=[],weatherVal=[];
			var directiondata=[],directionKey=[];
			var powerdata=[],powerKey=[];
//			alert(response[0][1].count+":"+response[0][1].weather);
//			alert(response[1].length);
			for(var i=0;i<response.length;i++){
				for(var j=0;j<response[i].length;j++){
					if(i==0){
						weatherKey.push(response[i][j].weather);
						weatherVal.push(response[i][j].count);
					}else if(i==1){
						var item1={
								value:response[i][j].count, 
								name:response[i][j].direction
						}
						directiondata.push(item1);
						directionKey.push(response[i][j].direction);
						
					}else if(i==2){
						var item2={
								value:response[i][j].count, 
								name:response[i][j].power	
						}
						powerdata.push(item2);
						powerKey.push(response[i][j].power);
					}
				}
			}
			optionweather = {
				    
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['天气统计']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            magicType : {show: true, type: ['line', 'bar']},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'category',
				            data : weatherKey
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'天气统计',
				            type:'bar',
				            data:weatherVal,
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            }
				        }
				    ]
				};
				var mychart=echarts.init(document.getElementById("weathercount"),"macarons");
				mychart.setOption(optionweather);
			//=============================================================================
				optiondirection = {
					    title : {
					        text: '风向统计',
					        subtext: '历史天气网',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} 天({d}%)"
					    },
					    legend: {
					        orient : 'vertical',
					        x : 'left',
					        data:directionKey
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {
					                show: true, 
					                type: ['pie', 'funnel'],
					                option: {
					                    funnel: {
					                        x: '25%',
					                        width: '50%',
					                        funnelAlign: 'left',
					                        max: 1548
					                    }
					                }
					            },
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    series : [
					        {
					            name:'风向',
					            type:'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data:directiondata
					        }
					    ]
					};
					                    
				var mychart=echarts.init(document.getElementById("monthcount"),"macarons");
				mychart.setOption(optiondirection);
//==============================================================================
				optionpower = {
					    title : {
					        text: '风力统计',
					        subtext: '历史天气网',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} 天({d}%)"
					    },
					    legend: {
					        orient : 'vertical',
					        x : 'left',
					        data:powerKey
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {
					                show: true, 
					                type: ['pie', 'funnel'],
					                option: {
					                    funnel: {
					                        x: '25%',
					                        width: '50%',
					                        funnelAlign: 'left',
					                        max: 1548
					                    }
					                }
					            },
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    series : [
					        {
					            name:'风力',
					            type:'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data:powerdata
					        }
					    ]
					};
				
				
				
				var mychart=echarts.init(document.getElementById("daycount"),"macarons");
				mychart.setOption(optionpower);
		}
	})
	
	
	
	
})