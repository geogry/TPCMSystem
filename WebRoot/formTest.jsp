<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'formTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script>
		var userid = '<%=session.getAttribute("id")%>';
	</script>
	
	<script type="text/javascript" src="ext4/bootstrap.js"></script>
	<script type="text/javascript" src="ext4/locale/ext-lang-zh_CN.js"></script>

	<script type="text/javascript" src="app/controller/modifyUserCl.js"></script>
	<script type="text/javascript" src="app/model/User.js"></script>
	<script type="text/javascript" src="app/view/user/showUser.js"></script>

  </head>
  	
  <body>
  	<div id="formTest">
  	
  	</div>
  </body>
</html>
