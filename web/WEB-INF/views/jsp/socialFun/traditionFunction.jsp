<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<span style="color: #00bbee"> 传统竞赛成绩评定方法结果:</span><br>
player7   > 	player2   > 	player6   > 	player10   > 	player1   > 	player5   > 	player3   > 	player4   > 	player9   > 	player8

</body>
</html>