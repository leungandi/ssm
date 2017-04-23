<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	request.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx }/static/js/echarts-2.2.7/echarts-2.2.7/build/dist/echarts.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="echatsId" style="height:400px"></div>
</body>
<script type="text/javascript">
	//路径配置
	require.config({
	    paths: {
	        echarts: '${ctx }/static/js/echarts-2.2.7/build/dist'
	    }
	});
    //使用
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('echatsId')); 
            
            var option = {
            	title : {
            		text : '这是主标题',
            		subtext:'这是副标题',
            		link:'http://www.baidu.com',
            		show:true,
            		x:'100'
            	},
            	toolbox: {
            	        show : true,
            	        orient: 'horizontal',      // 布局方式，默认为水平布局，可选为：
            	                                   // 'horizontal' ¦ 'vertical'
            	        x: 'right',                // 水平安放位置，默认为全图右对齐，可选为：
            	                                   // 'center' ¦ 'left' ¦ 'right'
            	                                   // ¦ {number}（x坐标，单位px）
            	        y: 'top',                  // 垂直安放位置，默认为全图顶端，可选为：
            	                                   // 'top' ¦ 'bottom' ¦ 'center'
            	                                   // ¦ {number}（y坐标，单位px）
            	        color : ['#1e90ff','#22bb22','#4b0082','#d2691e'],
            	        backgroundColor: 'rgba(0,0,0,0)', // 工具箱背景颜色
            	        borderColor: '#ccc',       // 工具箱边框颜色
            	        borderWidth: 0,            // 工具箱边框线宽，单位px，默认为0（无边框）
            	        padding: 5,                // 工具箱内边距，单位px，默认各方向内边距为5，
            	        showTitle: true,
            	        feature : {
            	            mark : {
            	                show : true,
            	                title : {
            	                    mark : '辅助线-开关',
            	                    markUndo : '辅助线-删除',
            	                    markClear : '辅助线-清空'
            	                },
            	                lineStyle : {
            	                    width : 1,
            	                    color : '#1e90ff',
            	                    type : 'dashed'
            	                }
            	            },
            	            dataZoom : {
            	                show : true,
            	                title : {
            	                    dataZoom : '区域缩放',
            	                    dataZoomReset : '区域缩放-后退'
            	                }
            	            },
            	            dataView : {
            	                show : true,
            	                title : '数据视图',
            	                readOnly: true,
            	                lang : ['数据视图', '关闭', '刷新'],
            	                optionToContent: function(opt) {
            	                    var axisData = opt.xAxis[0].data;
            	                    var series = opt.series;
            	                    var table = '<table style="width:100%;text-align:center"><tbody><tr>'
            	                                 + '<td>时间</td>'
            	                                 + '<td>' + series[0].name + '</td>'
            	                                 + '<td>' + series[1].name + '</td>'
            	                                 + '</tr>';
            	                    for (var i = 0, l = axisData.length; i < l; i++) {
            	                        table += '<tr>'
            	                                 + '<td>' + axisData[i] + '</td>'
            	                                 + '<td>' + series[0].data[i] + '</td>'
            	                                 + '<td>' + series[1].data[i] + '</td>'
            	                                 + '</tr>';
            	                    }
            	                    table += '</tbody></table>';
            	                    return table;
            	                }
            	            },
            	            magicType: {
            	                show : true,
            	                title : {
            	                    line : '动态类型切换-折线图',
            	                    bar : '动态类型切换-柱形图',
            	                    stack : '动态类型切换-堆积',
            	                    tiled : '动态类型切换-平铺'
            	                },
            	                type : ['line', 'bar', 'stack', 'tiled']
            	            },
            	            restore : {
            	                show : true,
            	                title : '还原',
            	                color : 'black'
            	            },
            	            saveAsImage : {
            	                show : true,
            	                title : '保存为图片',
            	                type : 'jpeg',
            	                lang : ['点击本地保存'] 
            	            },
            	            myTool : {
            	                show : true,
            	                title : '自定义扩展方法',
            	                icon : 'image://../asset/ico/favicon.png',
            	                onclick : function (){
            	                    alert('myToolHandler')
            	                }
            	            }
            	        }
            	},
                tooltip: {
                    show: true
                },
                legend: {
                    data:['销量','测试']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"销量",
                        "type":"line",
                        "data":[5, 20, 40, 10, 10, 20]
                    },
                    {
                        "name":"测试",
                        "type":"line",
                        "data":[5, 5, 5, 5, 5, 5]
                    }
                ]
            };
    
            // 为echarts对象加载数据 
            myChart.setOption(option); 
        }
    );

</script>
</html>