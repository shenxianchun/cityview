option = {
    title : {					//标题
        text: '某站点用户访问来源',
        x:'center',				//位置
        subtext: '纯属虚构'		//副标题
    },
    tooltip : {						//提示框，鼠标悬浮交互时的信息提示
        trigger: 'axis'
    },
    legend: {
        data:['报名量','学员量','开班量'],
    	x:'right'
    },
//    toolbox: {			//工具箱，每个图表最多仅有一个工具箱
//        show : true,
//        feature : {
//            mark : {show: true},
//            dataView : {show: true, readOnly: false},//当数据视图readOnly为false时，会出现刷新按钮，如果是自主编排的显示内容，如何翻转也请自理
//            magicType : {show: true, type: ['line', 'bar']},//图列切换， line : '折线图切换', bar : '柱形图切换',
//            restore : {show: true},
//            saveAsImage : {show: true}//保存图片（IE8-不支持），上图icon最右，可设置更多属性
//        }
//    },
    calculable : true,//拖拽重计算特性
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value',
            position:'left',
            	name:'人数',
            	splitNumber: 6 ,// // 数值轴用，分割段数，默认为5
            	axisLabel:{
            		formatter:'{value}人'
            	}
        },
        {
            type : 'value',
            name:'班级数',
            axis:1,
            show:true ,
            position:'right',
            	axisLabel:{
            		formatter:'{value}个'
            	}
        }
    ],
    
         
    series : [
        {
            name:'报名量',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ],
                effect:{					//标注图形炫光特效: 
				    show: true,
				    type: 'scale',		//type 特效类型，默认为'scale'（放大），可选还有'bounce'（跳动） 
				    loop: true,			//loop 循环动画，默认开启,
				    period: 15,			//period 运动周期，无单位，值越大越慢，默认为15 
				    scaleSize : 1,		//scaleSize 放大倍数，以markPoint symbolSize为基准，type为scale时有效
				    bounceDistance: 10,	//跳动距离，单位为px，type为bounce时有效 
				    color : null,		//炫光颜色，默认跟随markPoint itemStyle定义颜色, 
				    shadowColor : null,	//shadowColor 光影颜色，默认跟随color 
				    shadowBlur : 0		//shadowBlur 光影模糊度，默认为0 
				}
	       
            }
           
        },
        {
            name:'学员量',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            }
        },
        {
            name:'开班量',
            type:'line',
            yAxisIndex: 1,
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            }
        }
    ]
};
var mychart=echarts.init(document.getElementById("piechart"),"macarons");
mychart.setOption(option);