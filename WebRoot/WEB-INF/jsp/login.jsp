<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="大学生科技创新园,设备与耗材管理系统">
	<meta http-equiv="description" content="登录页面">
	
	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	<!--
	#apDiv1 {
		position:absolute;
		visibility:inherit;
		width:508px;
		height:71px;
		z-index:1;
		left: 664px;
		top: 471px;
	}
	#apDiv2 {
		position:absolute;
		visibility:inherit;
		width:200px;
		height:29px;
		z-index:2;
		left: 816px;
		top: 362px;
	}
	-->
	input.smallInput{border:0px; border-color:#FFF; background:url(image/z.jpg); color:#fff; FONT-SIZE: 9pt; FONT-STYLE: normal; FONT-VARIANT: normal; FONT-WEIGHT: normal; HEIGHT: 26px; LINE-HEIGHT: 18px;}
	input.smallInput1{border:0px; border-color:#FFF; background:url(image/z1.jpg); color:#fff; FONT-SIZE: 9pt; FONT-STYLE: normal; FONT-VARIANT: normal; FONT-WEIGHT: normal; HEIGHT: 26px; LINE-HEIGHT: 18px;}
	
	</style>
  </head>
  <body>
  	<div id="apDiv2" style="color:#FFF; font-weight:600; font-size:16px; line-height:24px;" align="center">${loginError }</div>
  	<div id="box">
		<div id="apDiv1">
		<form action="login" method="post">
			<div class="bt1">
				<input type="submit" class="myButton" style="width:82px;height:27px;border:0;" value=""/>
			</div>
			<div class="jx1"></div>
			<div class="user">用户名：</div>
			<div class="usert"><img src="image/textz.jpg" width="8" height="27" /></div>
			<div class="usert1"><input name="user.username" type="text" size="9" class="smallInput" /></div>
			<div class="usert2"><img src="image/ty.jpg" width="9" height="27" /></div>
			<div class="password">密码：</div>
			<div class="passwordt"><img src="image/textz1.jpg" width="8" height="27" /></div>
			<div class="passwordt1">
			  <input name="user.password" type="password" size="9" class="smallInput1" />
			</div>
			<div class="passwordt2"><img src="image/ty1.jpg" width="9" height="27" /></div>
			<div class="jx2"></div>
			<div class="bt2">
				<input type="button" class="myButton1" style="width:82px;height:27px;border:0;" value="" onClick="window.location.href='listNotices'"/>
			</div>
		</form>
		</div>
	</div>
  </body>
</html>