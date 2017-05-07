option = {
    title : {
    	text: '质量等级',
        subtext: '数据来自历史数据平台',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
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
            name:'访问来源',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'良'},
                {value:310, name:'轻度污染'},
                {value:234, name:'中度污染'},
                {value:135, name:'重度污染'}
            ]
        }
    ]
};
var mychart=echarts.init(document.getElementById("daycount"),"macarons");
mychart.setOption(option);