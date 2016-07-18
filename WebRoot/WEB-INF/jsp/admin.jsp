<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>创新园设备与耗材管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="大学生科技创新园,设备与耗材管理系统">
	<meta http-equiv="description" content="管理员页面">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/icon.css"/>
	<link rel="stylesheet" type="text/css" href="ext4/resources/css/ext-all.css"/>
	
	<script type="text/javascript" src="ext4/bootstrap.js"></script>
	<script type="text/javascript" src="ext4/locale/ext-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="app/model/User.js"></script>
	<script type="text/javascript" src="app/store/Users.js"></script>
	<script type="text/javascript" src="app/model/PassBorrow.js"></script>
	<script type="text/javascript" src="app/store/PassBorrows4Admin.js"></script>
	<script type="text/javascript" src="app/model/RefuseBorrow.js"></script>
	<script type="text/javascript" src="app/store/RefuseBorrows4Admin.js"></script>
	<script type="text/javascript" src="app/model/PassPor.js"></script>
	<script type="text/javascript" src="app/store/PassPors4Admin.js"></script>
	<script type="text/javascript" src="app/model/RefusePor.js"></script>
	<script type="text/javascript" src="app/store/RefusePors4Admin.js"></script>
	<script type="text/javascript" src="app/model/TempBorrow.js"></script>
	<script type="text/javascript" src="app/store/TempBorrows4Admin.js"></script>
	<script type="text/javascript" src="app/model/TempPor.js"></script>
	<script type="text/javascript" src="app/store/TempPors4Admin.js"></script>
	<script type="text/javascript" src="app/model/Message.js"></script>
	<script type="text/javascript" src="app/store/Messages.js"></script>
	<script type="text/javascript" src="app/store/NewMessages.js"></script>
	<script type="text/javascript" src="app/controller/adminCl.js"></script>
	<script type="text/javascript" src="app/view/admin/adminMenu.js"></script>
	<script type="text/javascript" src="app/view/admin/adminPanel.js"></script>
  </head>
  
  <body>
  	<div id="top">
	  	<div id="logo">
	    </div>
	    <div id="information">
	        <div id="user">
	            <font color="#000000" size="-1">
	            	当前登录用户：<font color="#FF0000"><strong>${username}</strong></font>
	            </font>
	        </div>
	        <div id="operation">
	            <a href="javascript:;" id="newMessage"><font size="-1">新消息(<font color="#FF0000">${messageSize }</font>)</font></a>
	            <a href="exit"><font size="-1">注销</font></a>
	        </div>
	    </div>
    </div>
    <div id="main">
    	<h1>欢迎登录大学生科技创新园设备与耗材管理系统</h1>
    </div>
  </body>
</html>
