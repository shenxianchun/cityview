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
			//alert(month);
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
//			var chart=echarts.init(document.getElementById("aqimonthcount"),"helianthus");
//			chart.setOption(option);
		}
	});
	$.ajax({
		type:'post',
		url:'aqimonth/queryAqiMonthCountGrade.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"深圳"}',
		success:function(response){//返回json结果
			var month=[];//月份
			var seriousdata=[];//严重污染
			var severedata=[];//重度污染
			var moderatedata=[];//中度污染
			var lightdata=[];//轻度污染
			var gooddata=[];//良
			var excellentdata=[];//优
			//var seriesdata=[];//指标
//			alert(response[0].monthday);
//			alert(response[0].aqimonthCustoms[0].grade+":"+response[0].aqimonthCustoms[0].numGrade);
			for(var i=0;i<response.length;i++){
				month.push(response[i].monthday);
				//alert(response[i].monthday);
				for(var j=0;j<response[i].aqimonthCustoms.length;j++){
					//alert(response[i].aqimonthCustoms[j].grade+":"+j+":"+response[i].aqimonthCustoms[j].numGrade);
					var strkey=response[i].aqimonthCustoms[j].grade;
					var strvalue=response[i].aqimonthCustoms[j].numGrade;
					//alert(strkey+":->"+strvalue);
					var str1="严重污染";
					var str2="重度污染";
					var str3="中度污染";
					var str4="轻度污染";
					var str5="良";
					var str6="优";
					if(strkey==str1){
						seriousdata.push(strvalue);
					}
					if(strkey==str2){
						severedata.push(strvalue);
					}
					if(strkey==str3){
						moderatedata.push(strvalue);
					}
					if(strkey==str4){
						lightdata.push(strvalue);
					}
					if(strkey==str5){
						gooddata.push(strvalue);
					}
					if(strkey==str6){
						excellentdata.push(strvalue);
					}
				}
			}
//			alert(seriousdata);
//			alert(severedata);
//			alert("中度：{"+moderatedata+"}");
//			alert(lightdata);
//			alert(gooddata);
//			alert(excellentdata);
//			alert(lightdata);
			optioncount = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				    	data:['严重污染','重度污染','轻度污染','良','优']
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
				            data :month
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				        	name:'严重污染',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:seriousdata
				        },
				        {
				            name:'重度污染',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:severedata
				        },
				        {
				            name:'中度污染',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:moderatedata
				        },
				        {
				            name:'轻度污染',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:lightdata
				        },
				        {
				            name:'良',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:gooddata
				        },
				        {
				            name:'优',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {areaStyle: {type: 'default'}}},
				            data:excellentdata
				        }
				    ]
				};
				var chart=echarts.init(document.getElementById("aqimonthcount"),"helianthus");
				chart.setOption(optioncount);
		}
	});
//-----------------------------------------------------------------------------------------------------
	$.ajax({
		type:'post',
		url:'aqimonth/queryCountGradeMonth.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"北京"}',
		success:function(response){//返回json结果
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
				        text: '月统计数据',
				        subtext: '数据网',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} 月({d}%)"
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
				            name:'质量等级',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:datanum
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("monthcount"),"default");
			mychart.setOption(optionnum);
		}
	});
//-------统计历史以来不同质量等级的天数start------------------------------------------------------------------------------------------
	$.ajax({
		type:'post',
		url:'aqimonth/queryCountGradeDay.action',
		contentType:'application/json;charset=utf-8',
		//数据格式是json串
		data:'{"cityname":"深圳"}',
		success:function(response){//返回json结果
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
			optiodaynnum = {
				    title : {
				        text: '历史天数统计数据',
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
				            name:'质量等级',
				            type:'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:datanum
				        }
				    ]
				};
			var mychart=echarts.init(document.getElementById("daycount"),"default");
			mychart.setOption(optiodaynnum);
		}
	});
//-------统计历史以来不同质量等级的天数end------------------------------------------------------------------------------------------

	
})