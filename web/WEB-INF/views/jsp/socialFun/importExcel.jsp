<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>上传excel数据</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

  <link id="themeUrl" rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
  <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
  <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">

    $(document).ready(function(){
      $('#btn').click(function(){
        if(checkData()){
          $.ajax({
            type : "POST",  //提交方式
            url : "${pageContext.request.contextPath}/uploadExcel/ajaxUpload",//路径
            data : {
              "org.id" : "${org.id}"
            },//数据，这里使用的是Json格式进行传输
            success : function(result) {//返回数据根据结果进行相应的处理
              if ( result.success ) {
                $("#tipMsg").text("导入数据成功");
                tree.deleteItem("${org.id}", true);
              } else {
                $("#tipMsg").text("导入数据失败");
              }
            }
          });
        }
      });
    });

    //JS校验form表单信息
    function checkData(){
      var fileDir = $("#upfile").val();
      var suffix = fileDir.substr(fileDir.lastIndexOf("."));
      if("" == fileDir){
        alert("选择需要导入的Excel文件！");
        return false;
      }
      /*if(".xls" != suffix && ".xlsx" != suffix ){
        alert("选择Excel格式的文件导入！");
        return false;
      }*/
      return true;
    }
  </script>
</head>

<body>
</br>
</br>
<form method="POST"  enctype="multipart/form-data" id="form1" action="uploadExcel/formUpload">
  <table>
    <tr>
      <td>上传文件: </td>
      <td>
        <input id="upfile" name="upfile"  type="file" <%--class="easyui-filebox"--%>  data-options="prompt:'请选择文件...'">
      </td>
    </tr>
    <tr>
      <td><input type="submit"  class="easyui-linkbutton" value="提交" onclick="checkData()"></td>
      <td><input type="button" class="easyui-linkbutton" value="ajax方式提交" id="btn" name="btn" ></td>
    </tr>
  </table>
</form>
  <div>
    <h3>1.选择要上传的数据文件</h3>
    <h3>2.目前支持03版本的excel数据</h3>
  </div>
</body>
</html>