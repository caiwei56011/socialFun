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
      
    });
  </script>

</head>

<body>
偏好排序结果
选手数量：<span style="color: red;">${playerNum }</span>
裁判数量：<span style="color: red;">${refereeNum }</span>
<table border="0">

  <c:forEach items="${excelLists }" var="var" varStatus="vs1">
    <tr>
      <td>裁判${vs1.count }：</td>
        <c:forEach items="${var }" var="var2" varStatus="vs2">
            <c:if test="${vs2.count } == 2">
              111
            </c:if>
            <td style="width:100px">${var2 }&nbsp;&nbsp;&nbsp;&gt;</td>
        </c:forEach>
    </tr>
  </c:forEach>

</table>
</body>
</html>