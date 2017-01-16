<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>demo基本表单数据</title>
  </head>
<body>
    
<form action="${pageContext.servletContext.contextPath}/demo/show11.mvc" method="post">
	<div>姓名:</div>
	<div><input name="name" value="传智播客"/></div>
	<div class="clear"></div>
	<div>年龄:</div>
	<div><input name="age" value="20"/></div>
	<div class="clear"></div>
	<div>性别:</div>
	<div>
	<input type="radio" name="gender" value="true" checked="checked"/>男
	<input type="radio" name="gender" value="false"/>女</div>
	<div class="clear"></div>
	<div>兴趣:</div>
	<div>
	<input type="checkbox" name="interests" value="Java" checked="checked"/>Java
	<input type="checkbox" name="interests" value="Android" checked="checked"/>Android
	<input type="checkbox" name="interests" value="IOS" checked="checked"/>IOS
	</div>
	<div class="clear"></div>
	<div><input type="submit" value="提交表单"/></div>
</form>
  </body>
</html>

