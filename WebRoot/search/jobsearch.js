$(function(){
	$("#search").click(function(){
		 var cityname=$("#province").val();
		 if(cityname==""){
			 alert("请选择市区");
			 return ;
		 }
		 $("#companynature").empty();
		 $("#scale").empty();
		 $("#industry").empty();
		 $(".chr").removeAttr("_echarts_instance_");$(".chr").removeAttr("style");
		 
		 
		 $.ajax({
				type:'post',
				url:'job/findCompanynatureTotal.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					if(data==""){
						alert("数据为空，请更新");
						$("#companynature").append("数据为空，请更新");
						$("#scale").append("数据为空，请更新");
						$("#industry").append("数据为空，请更新");
						return;
					}
					//统计不同公司类型的总数
//					alert(data[0].companynature+":"+data[0].total);
					var companynature=[],total=[];
					for(var i=0;i<data.length;i++){
//						alert(data[i].companynature+""+data[i].total);
						companynature.push(data[i].companynature);
						total.push(data[i].total);
					}
					
					option = {
						    title : {
						        text: '公司类型',
						        subtext: '数据来自智联招聘',
						        x: 'center'
						    },
						    tooltip : {
						        trigger: 'axis'
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
						            data :companynature 
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'公司数',
						            type:'bar',
						            data:total,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("companynature"),"macarons");
					mychart.setOption(option);
				}
			})
//----------------------------------------------------------------------
			$.ajax({
				type:'post',
				url:'job/findScaleTotal.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					//统计不同公司类型的总数
//					alert(data[0].scale+":"+data[0].total);
					var scale=[],total=[];
					for(var i=0;i<data.length;i++){
//						alert(data[i].companynature+""+data[i].total);
						scale.push(data[i].scale);
						total.push(data[i].total);
					}
					
					option = {
						    title : {
						        text: '公司规模',
						        subtext: '数据来自智联招聘',
						        x: 'center'
						    },
						    tooltip : {
						        trigger: 'axis'
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
						            data :scale 
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'公司数',
						            type:'bar',
						            data:total,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("scale"),"macarons");
					mychart.setOption(option);
				}
			})
//----------------------------------------------------------------------
			$.ajax({
				type:'post',
				url:'job/findindustry.action',
				contentType:'application/json;charset=utf-8',
				//数据格式是json串
				data:'{"cityname":"'+cityname+'"}',
				success:function(data){//返回json结果
					//统计不同公司类型的总数
					var industry=[],total=[];
					for(var i=0;i<data.length;i++){
//						alert(data[i].companynature+""+data[i].total);
						industry.push(data[i].industry);
						total.push(data[i].total);
					}
					
					option = {
						    title : {
						        text: '公司行业',
						        subtext: '数据来自智联招聘',
						        x: 'center'
						    },
						    tooltip : {
						        trigger: 'axis'
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
						            data :industry 
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'公司数',
						            type:'bar',
						            data:total,
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
					var mychart=echarts.init(document.getElementById("industry"),"macarons");
					mychart.setOption(option);
				}
			})
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	})
});