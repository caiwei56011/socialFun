<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="org.jfree.chart.StandardChartTheme" %>
<%@ page import="java.awt.*" %>
<%@ page import="org.jfree.data.category.DefaultCategoryDataset" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation" %>
<%@ page import="org.jfree.chart.plot.CategoryPlot" %>
<%@ page import="org.jfree.chart.axis.CategoryAxis" %>
<%@ page import="org.jfree.chart.renderer.category.BarRenderer3D" %>
<%@ page import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>传统竞赛成绩评定方法</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

  <link id="themeUrl" rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
  <script type="text/javascript" src="js/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
  <style type="text/css">
    body{
      font-family: "Microsoft YaHei"
    }
  </style>
  <script type="text/javascript">
    $(document).ready(function(){
      
    });
  </script>

</head>

<body>
<%--<%

  //创建主题样式
  StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
//设置标题字体
  standardChartTheme.setExtraLargeFont(new Font("黑体",Font.BOLD,20));
//设置图例的字体
  standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));
//设置轴向的字体
  standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
//应用主题样式
  ChartFactory.setChartTheme(standardChartTheme);
    DefaultPieDataset dpd = new DefaultPieDataset();

    dpd.setValue("管理人员", 25);
    dpd.setValue("市场人员", 25);
    dpd.setValue("开发人员", 45);
    dpd.setValue("其他人员", 10);

    JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",dpd, true, false, false);

    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session);
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）

    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%>--%>

<%

  //创建主题样式
  StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
//设置标题字体
  standardChartTheme.setExtraLargeFont(new Font("黑体",Font.BOLD,20));
//设置图例的字体
  standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));
//设置轴向的字体
  standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
//应用主题样式
  ChartFactory.setChartTheme(standardChartTheme);
  DefaultCategoryDataset dataset     =   new  DefaultCategoryDataset();
  dataset.addValue( 150 ,  " 北京 " ,  " 苹果 " );
  dataset.addValue( 530 ,  " 上海 " ,  " 苹果 " );
  dataset.addValue( 160 ,  " 广州 " ,  " 苹果 " );
  dataset.addValue( 120 ,  " 北京 " ,  " 梨子 " );
  dataset.addValue( 230 ,  " 上海 " ,  " 梨子 " );
  dataset.addValue( 360 ,  " 广州 " ,  " 梨子 " );
  dataset.addValue( 600 ,  " 北京 " ,  " 葡萄 " );
  dataset.addValue( 430 ,  " 上海 " ,  " 葡萄 " );
  dataset.addValue( 560 ,  " 广州 " ,  " 葡萄 " );
  dataset.addValue( 400 ,  " 北京 " ,  " 香蕉 " );
  dataset.addValue( 530 ,  " 上海 " ,  " 香蕉 " );
  dataset.addValue( 660 ,  " 广州 " ,  " 香蕉 " );
  dataset.addValue( 500 ,  " 北京 " ,  " 荔枝 " );
  dataset.addValue( 630 ,  " 上海 " ,  " 荔枝 " );
  dataset.addValue( 430 ,  " 广州 " ,  " 荔枝 " );

  JFreeChart chart  =  ChartFactory.createBarChart3D( " 水果销量图统计-By Alpha " , " 水果种类-http://www.blogjava.net/Alpha/ " , " 销量 " ,dataset, PlotOrientation.VERTICAL, true , false , false );
  chart.setBackgroundPaint(Color.WHITE);
  CategoryPlot plot  =  chart.getCategoryPlot();

  CategoryAxis domainAxis  =  plot.getDomainAxis();
  // domainAxis.setVerticalCategoryLabels( false );
  plot.setDomainAxis(domainAxis);

  BarRenderer3D renderer  =   new  BarRenderer3D();
  renderer.setBaseOutlinePaint(Color.BLACK);

  // 设置每个地区所包含的平行柱的之间距离
  renderer.setItemMargin( 0.1 );
  // 显示每个柱的数值，并修改该数值的字体属性
  renderer.setItemLabelGenerator( new StandardCategoryItemLabelGenerator());
  renderer.setItemLabelsVisible( true );
  plot.setRenderer(renderer);

  //  设置柱的透明度
  plot.setForegroundAlpha( 0.8f);

  String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session);
  //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）

  String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
  //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%>

<img src="<%= url %>" width="800" height="600">
</body>
</html>