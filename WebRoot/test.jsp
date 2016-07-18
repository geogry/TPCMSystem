<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="测试页面">

	<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css"/>
	
	<script type="text/javascript" src="ext4/bootstrap.js"></script>
	<script type="text/javascript" src="ext4/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="app/view/UserPage.js"></script>
  </head>
  
  <body>
    <div id="top" style="width:100%;height:170px;">
    	
    </div>
    <div id="main" style="width:100%;text-align:center;height:500px;background:#DFE9F5;line-height:300px;">
    	<font size="+7">欢迎登录创新园设备与耗材管理系统！</font>
    </div>
  </body>
</html>
