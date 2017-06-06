$(function(){
	var day=$("#month").text();
	var cityname=$("#cityname_city").text();
//	alert("值为"+day+cityname);
	$.ajax({
		type:'post',
		url:'/cityview/aqimonth/queryAqidayAll.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"'+cityname+'","day":"'+day+'"}',
		success:function(response){//返回json结果
//			alert("哈哈"+response[0].cityname);
			var day=[];
			var datamin=[];
			var datamax=[];
			var dataver=[];
			var pm=[],pmo=[],so=[];
			for(var i=0;i<response.length;i++){
				$("#aqimonth-table").append("<tr>"+
						"<td>"+response[i].day+"</td>"+
						"<td>"+response[i].aqi+"</td>"+
						"<td><div style='width:65px;height:20px;color:black;'>"+response[i].grade+"</div></td>" +
						"<td>"+response[i].pm+"</td>" +
						"<td>"+response[i].pmo+"</td>" +
						"<td>"+response[i].so+"</td>" +
						"<td>"+response[i].co+"</td>" +
						"<td>"+response[i].no+"</td>" +
						"<td>"+response[i].o+"</td>" +
						"</tr>");
				day.push(response[i].day);
				dataver.push(response[i].aqi);
				pm.push(response[i].pm);
				pmo.push(response[i].pmo);
				so.push(response[i].so);
			}
			
			option = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['AQI']
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
				            data : day
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
				            name:'AQI',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:dataver
				        }
				    ]
				};
			
			var mychart=echarts.init(document.getElementById("container"),"shine");
			mychart.setOption(option);
//--------------------------------------------------------------------------------------------------
			option1 = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['pm2.5','pm10','so2']
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
				            data : day
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
				            name:'pm2.5',
				            type:'line',
				            data:pm
				        },
				        {
				            name:'pm10',
				            type:'line',
				            data:pmo
				        },
				        {
				            name:'so2',
				            type:'line',
				            data:so
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("aqimonthcount"),"default");
			mychart.setOption(option1);
//--------------------------------------------------------------------------------------------------		
		}
	})
	$.ajax({
		type:'post',
		url:'/cityview/aqimonth/queryAqidayCountGrade.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"'+cityname+'","day":"'+day+'"}',
		success:function(response){//返回json结果
			//alert(response[0].numGrade+":"+response[0].grade)
			var numGrade=[],grade=[];
			var datanum=[];
			for(var i=0;i<response.length;i++){
				var item={
						value:response[i].numGrade,
						name:response[i].grade
				}
				grade.push(response[i].grade);
				datanum.push(item);
			}
			optionnum = {
				    title : {
				        text: 'AQI'+day+'统计',
				        subtext: '数据网',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} 天({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:grade
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
				            name:'AQI质量等级',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:datanum
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("monthcount"),"default");
			mychart.setOption(optionnum);
//------------------------------------------------------------------------------------------------
			optionnum2 = {
					 title : {
					        text: 'AQI'+day+'统计',
					        subtext: '数据网',
					        x:'center'
					    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} 天({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        data:grade
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
				                        funnelAlign: 'center',
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
				            name:'AQI质量等级',
				            type:'pie',
				            radius : ['50%', '70%'],
				            itemStyle : {
				                normal : {
				                    label : {
				                        show : false
				                    },
				                    labelLine : {
				                        show : false
				                    }
				                },
				                emphasis : {
				                    label : {
				                        show : true,
				                        position : 'center',
				                        textStyle : {
				                            fontSize : '30',
				                            fontWeight : 'bold'
				                        }
				                    }
				                }
				            },
				            data:datanum
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("daycount"),"green");
			mychart.setOption(optionnum2);
		}
	})
})