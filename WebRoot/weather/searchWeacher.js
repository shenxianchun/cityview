$(function(){
	$("#search").click(function(){
		 var cityname=$("#province").val();
		 if(cityname==""){
			 alert("请选择市区");
			 return ;
		 }
		 $("#weathercount").empty();
		 $("#container").empty();
		 $("#aqimonthcount").empty();
		 $(".chr").removeAttr("_echarts_instance_");$(".chr").removeAttr("style");
		 $("#ahref").attr("href","weatherday.jsp?cityname="+cityname+"&date=2013-07");
		 $.ajax({
				type:'post',
				url:'/cityview/weather/queryCountWeather.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(response){//返回json结果
					console.log(response)
					var weatherKey=[],weatherVal=[];
					var directionKey=[],directionVal=[];
					var powerKey=[],powerVal=[];
//					alert(response[0][1].count+":"+response[0][1].weather);
//					alert(response[1].length);
					for(var i=0;i<response.length;i++){
						for(var j=0;j<response[i].length;j++){
							if(i==0){
								weatherKey.push(response[i][j].weather);
								weatherVal.push(response[i][j].count);
							}else if(i==1){
								directionKey.push(response[i][j].direction);
								directionVal.push(response[i][j].count);
							}else if(i==2){
								powerKey.push(response[i][j].power);
								powerVal.push(response[i][j].count);
							}
						}
					}
					/*alert(weatherKey+"-->:"+weatherVal);
					alert(directionKey+"-->:"+directionVal);
					alert(powerKey+"-->:"+powerVal);*/
					
					optionweather = {
					    tooltip : {
					        trigger: 'axis'
					    },
					    legend: {
					        data:['天气']
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataZoom : {show: true},
					            dataView : {show: true},
					            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    calculable : true,
					    dataZoom : {
					        show : true,
					        realtime : true,
					        start : 20,
					        end : 80
					    },
					    xAxis : [
					        {
					            type : 'category',
					            boundaryGap : false,
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
					            name:'天气',
					            type:'bar',
					            data:weatherVal
					        }
					    ]
					};
					var mychart=echarts.init(document.getElementById("weathercount"),"macarons");
					mychart.setOption(optionweather);
		//------------------------end--------------------------------------------------------------------------------
					optiondirection = {
						    
						    tooltip : {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['风向统计']
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
						            data : directionKey
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'风向统计',
						            type:'bar',
						            data:directionVal,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
						                    
					var mychart=echarts.init(document.getElementById("container"),"macarons");
					mychart.setOption(optiondirection);
		//------------------------end--------------------------------------------------------------------------------

					optionpower = {
						    tooltip : {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['风力统计']
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
						            data : powerKey
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'风力统计',
						            type:'bar',
						            data:powerVal,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("aqimonthcount"),"macarons");
					mychart.setOption(optionpower);
				}
			})
		 
		 
		 
		 
		 
		 
	})
})