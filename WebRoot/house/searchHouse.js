$(function(){
	$("#search").click(function(){
		 var cityname=$("#province").val();
		 if(cityname==""){
			 alert("请选择市区");
			 return ;
		 }
		 $("#agency").empty();
		 $("#face").empty();
		 $("#renovation").empty();
		 $("#type").empty();
		 $("#area").empty();
		 $(".chr").removeAttr("_echarts_instance_");$(".chr").removeAttr("style");
		 
		 
		 
		 $.ajax({
				type:'post',
				url:'/cityview/houses/findAgencytotal.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					//统计城市中的房屋中介公司
					if(data==""){
						alert("该城市数据为空，请前往数据更新");
						return ;
					}
					var total=[];
					var agency=[];
					for(var i=0;i<data.length;i++){
						agency.push(data[i].agency);
						total.push(data[i].total);
					}
					
					agencyoption = {
							title : {
						        text: '房屋中介公司',
						        subtext: '赶集网',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'axis'
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
						            data : agency
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'出现次数:',
						            type:'bar',
						            data:total
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("agency"),"macarons");
					mychart.setOption(agencyoption);
				}
			});
//-------------------------------------------------------------------------------
			$.ajax({
				type:'post',
				url:'/cityview/houses/findFacePrice.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					if(data==""){
						return ;
					}
					//统计房子的朝向出现的次数和价格的关系
					var total=[],price=[],face=[];
					for(var i=0;i<data.length;i++){
						total.push(data[i].total);
						price.push(data[i].price);
						face.push(data[i].face);
					}
					
					faceoption = {
						    title : {
						        text: '朝向和租金关系',
						        subtext: '赶集网',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						    legend: {
						    	orient : 'vertical',
						        x : 'left',
						        data:['次数','租金']
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
						            data : face
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value',
						            axisLabel : {
						                formatter: '{value}'
						            }
						        }
						    ],
						    series : [
						        {
						            name:'次数',
						            type:'line',
						            data:total,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        },
						        {
						            name:'租金',
						            type:'line',
						            data:price,
						            markLine : {
						                data : [
						                    {type : 'average', name : '平均值'}
						                ]
						            }
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("face"),"macarons");
					mychart.setOption(faceoption);
				}
			});
//=======================================================================================
			$.ajax({
				type:'post',
				url:'/cityview/houses/findRenovationPrice.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					if(data==""){
						return ;
					}
					//统计房子的装修风格和价格的关系
					var renovation=[],name=[];
					for(var i=0;i<data.length;i++){
						var iteam={
								value:data[i].price,
								name:data[i].renovation
						}
						name.push(data[i].renovation);
						renovation.push(iteam);
					}
					renovationoption = {
						    title : {
						        text: '装修风格和价格的关系',
						        subtext: '赶集网',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    legend: {
						        orient : 'vertical',
						        x : 'left',
						        data:name
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
						            name:'装修风格',
						            type:'pie',
						            radius : '55%',
						            center: ['50%', '60%'],
						            data:renovation
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("renovation"),"macarons");
					mychart.setOption(renovationoption);
				}
			});
//=========================================================================================
			$.ajax({
				type:'post',
				url:'/cityview/houses/findTypePrice.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					if(data==""){
						return ;
					}
					//租房类型和租金的关系
					var price=[],type=[];
					for(var i=0;i<data.length;i++){
						type.push(data[i].type);
						price.push(data[i].price);
						
					}
					typeoption = {
						    title : {
						        text: '租房类型和租金的关系',
						        subtext: '赶集网',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType: {show: true, type: ['line', 'bar']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						    xAxis : [
						        {
						            type : 'value',
						            boundaryGap : [0, 0.01]
						        }
						    ],
						    yAxis : [
						        {
						            type : 'category',
						            data : type
						        }
						    ],
						    series : [
						        {
						            name:'价格',
						            type:'bar',
						            data:price
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("type"),"macarons");
					mychart.setOption(typeoption);
				}
			});
//==========================================================================================
			$.ajax({
				type:'post',
				url:'/cityview/houses/findAreaPrice.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					if(data==""){
						return ;
					}
					//工作经验和用人需求的关系
					var price=[],area=[];
					for(var i=0;i<data.length;i++){
						area.push(data[i].area);
						price.push(data[i].price);
						
					}
					areaoption = {
						    title : {
						        text: '区域租房和价格关系',
						        subtext: '赶集网',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType: {show: true, type: ['line', 'bar']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						    xAxis : [
						        {
						            type : 'value',
						            boundaryGap : [0, 0.01]
						        }
						    ],
						    yAxis : [
						        {
						            type : 'category',
						            data : area
						        }
						    ],
						    series : [
						        {
						            name:'价格',
						            type:'bar',
						            data:price
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("area"),"macarons");
					mychart.setOption(areaoption);
				}
			})
		 
		 
		 
		 
		 
	})
})