<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>demo接受集合数据</title>
  </head> 
<body>   
	<form action="${pageContext.servletContext.contextPath}/demo/show12.mvc" method="post">
		用户1：<input type="text" name="users[0].name" /></br>
		用户2：<input type="text" name="users[1].name" /></br>
		用户3：<input type="text" name="users[2].name" /></br>
		<div class="clear"></div>
		<div><input type="submit" value="提交表单"/></div>
	</form>
</body>
</html>
