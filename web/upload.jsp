<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>上传文件</title>
   </head>
  
  <body>
   <form action="${pageContext.servletContext.contextPath}/demo/upload.mvc" method="post" enctype="multipart/form-data">
   	<input type ="file" name="file"/>
   	<input type="submit" value="上传">
   </form>
   <form action="${pageContext.servletContext.contextPath}/demo/upload2.mvc" method="post" enctype="multipart/form-data">
   	<input type ="file" name="files"/></br>
   	<input type ="file" name="files"/></br>
   	<input type ="file" name="files"/></br>
   	<input type="submit" value="上传多个文件">
   </form>
  </body>
</html>

