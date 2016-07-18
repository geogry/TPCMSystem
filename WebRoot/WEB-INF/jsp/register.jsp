<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="设备与耗材管理,大学生科技创新园">
	<meta http-equiv="description" content="用户注册页面">
	
	<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css"/>
	<link rel="stylesheet" type="text/css" href="css/icon.css"/>
	
	<script type="text/javascript" src="ext4/bootstrap.js"></script>
	<script type="text/javascript" src="ext4/locale/ext-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="app/model/Post.js"></script>
	<script type="text/javascript" src="app/store/Posts.js"></script>
	<script type="text/javascript" src="app/controller/form4RegisterCl.js"></script>
	<script type="text/javascript" src="app/view/form4Register.js"></script>
	
	<style type="text/css">
		label {
			text-align:left;
		}
	</style>
  </head>
  
  <body>
    <div id="register" align="center"></div>
  </body>
</html>
