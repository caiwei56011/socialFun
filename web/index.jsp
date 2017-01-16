<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>社会选择函数</title>
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

    #menu {
      width:200px;
    }

    #menu ul{
      width:100%;
      list-style: none;
      margin: 0px;
      padding: 0;
    }
    #menu ul li{
      border-bottom: 1px solid #fff;
    }
    #menu ul li a{
      width:100%;
      display:block;
      background-color: #285295;
      text-decoration: none;
      color:#fff;
      padding:3px;
    }
    #menu ul li a:hover{
      background-color: #4CBCFF;
    }
  </style>
  <script type="text/javascript">
    $(document).ready(function(){
      $("#menu a[name]").click(function(){
        //选项卡名称
        var tabTitle = $(this).text();
        var linkUrl =  $(this).attr("name");

        if($("#tt").tabs("exists",tabTitle)){
          //1、存在选项卡，打开
          $('#tt').tabs("select", tabTitle);
          //刷新
          var currentTab = $('#tt').tabs('getSelected');
          RefreshTab(currentTab,linkUrl);
        } else {
          //2、不存在选项卡，则新增选项卡
          //链接地址

          $('#tt').tabs('add',{
            title: tabTitle,
            selected: true,//设置选中
            closable: true,//关闭按钮
            content: "<iframe width='100%' height='100%' src='${pageContext.request.contextPath }" + linkUrl + "' frameborder='0'></iframe>",
          });
        }
      });
    });
    //刷新当前标签Tabs
    function RefreshTab(currentTab,linkUrl) {
      $('#tt').tabs('update', {
        tab: currentTab,
              options: {
                content: "<iframe width='100%' height='100%' src='${pageContext.request.contextPath }" + linkUrl + "' frameborder='0'></iframe>",
              }
      });
        currentTab.panel('refresh');
      }

  </script>

</head>

<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
  <!-- ---------------------顶部开始--------------------------- -->
  <div data-options="region:'north'" style="height:100px;">
    <h1 align="center" style="font-size: 30px">社会选择函数</h1>
  </div>
  <!-- ---------------------顶部结束--------------------------- -->

  <!-- ---------------------底部开始--------------------------- -->
  <div data-options="region:'south'" style="height:50px;text-align: center">
    2016 版权所有©社会选择函数
  </div>
  <!-- ---------------------底部结束--------------------------- -->

  <!-- ---------------------左边功能菜单开始--------------------------- -->
  <div data-options="region:'west',title:'Schulze社会选择函数'" style="width:200px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true" >
      <div id="menu" title="在线商品评价" data-options="iconCls:'icon-reload',selected:true">
        <ul>
          <li><a name="${pageContext.request.contextPath }/socialFun/uploadExcel52" href="#">52</a></li>
          <li><a name="${pageContext.request.contextPath }/socialFun/uploadExcel105" href="#">105</a></li>
          <li><a name="${pageContext.request.contextPath }/socialFun/uploadExcel210" href="#">210</a></li>
          <li><a name="${pageContext.request.contextPath }/socialFun/uploadExcel416" href="#">416</a></li>
          <li><a name="${pageContext.request.contextPath }/socialFun/uploadExcel827" href="#">827</a></li>
        </ul>
      </div>
      <div title="竞赛成绩评定" data-options="iconCls:'icon-reload'">
        content2
      </div>
      <div title="其他" data-options="iconCls:'icon-reload'">
        content3
      </div>
    </div>
  </div>
  <!-- ---------------------左边功能菜单结束--------------------------- -->

  <!-- ---------------------中间主显示区开始--------------------------- -->
  <div data-options="region:'center'" style="padding:2px;background:#eee;">

    <div id="tt" class="easyui-tabs"  data-options="fit:true" style="width:500px;height:250px;">
      <div title="欢迎页" style="padding:5px;">
        <h3>本系统的功能是实现基于Schulze社会选择算法的排序。</h3>
        <h3>请选择右方的排序方法</h3>
      </div>
    </div>

  </div>
  <!-- ---------------------中间主显示区结束--------------------------- -->
</div>
</body>
</html>