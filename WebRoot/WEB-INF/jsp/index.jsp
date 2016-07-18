<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<base href="<%=basePath%>">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="设备与耗材管理,大学生科技创新园">
	<meta http-equiv="description" content="首页">
	
	<title>创新园设备与耗材管理系统</title>
	
	<link rel="stylesheet" href="css/style.css" >
	<link rel="stylesheet" href="css/jquery.bxslider.css" >
	<link rel="stylesheet" href="css/reset.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
	
	<style type="text/css">
	<!--
	#apDiv1 {
		position:absolute;
		visibility:inherit;
		width:184px;
		height:54px;
		z-index:1;
		left: 552px;
		top: 6px;
	}
	-->
	</style>
</head>

<body>

<!--头部-->
	<div class="big_logo">
			<ul>
            	<li>:</li>
            	<li></li>
            </ul>
</div>
<div id="big_wrapper">
  <div id="big_wrapper2">
    <!--轮换图调用-->
    <div class="top_luhuan">
      <div id="banner">
        <ul class="bxslider1">
        	<s:iterator value="images">
        		<li><img  src="image/<s:property value="imagename"/>" alt=""  /></li>
        	</s:iterator>
          <%--<li><img  src="image/1.png" alt=""  /></li>
          <li><img  src="image/2.png" alt=""  /></li>
          <li><img  src="image/3.png" alt=""  /></li>
          <li><img  src="image/4.png" alt=""  /></li>
          <li><img  src="image/5.png" alt=""  /></li>
        --%></ul>
      </div>
    </div>
    <!--新闻动态-->
    <div class="top_xinwen">
      <div class="xw_xinwen">
        <div class="xw_xw1">
          <div class="newstop">
            <ul>
              <li class="xw_Name">最新公告</li>
            </ul>
          </div>
          <div class="newsdetails">
            <table width="800" border="0" cellpadding="0" cellspacing="0" style="font-size:16px;">
              <s:iterator value="notices">
	              <tr>
	                <td width="5" height="18"><img src="image/xxp.png" width="5" height="7" /></td>
	                <td width="715" align="left">&nbsp;<s:property value="content" escape="false"/></td>
	                <td width="80" align="right"><s:property value="time"/></td>
	              </tr>
	              <tr>
	                <td class="line" colspan="3"></td>
	              </tr>
              </s:iterator>
            </table>
          </div>
          <div class="pageindex" align="center"></div>
        </div>
      </div>
    </div>
  </div>
</div>
    
<!--底部-->   

<!--<include file="Public:footer"/> -->   
    
    
    <div class="Under" align="center">
    		<ul style="color:#fff;font-size:12px;padding-top:7px;">
         版权所有&copy;&nbsp;2014&nbsp;计算机与通信工程系大学生科技创新园
         &nbsp;&nbsp;&nbsp;<a href="loginInput">登录</a>
         &nbsp;&nbsp;&nbsp;<a href="registerInput">注册</a>
      </ul>
    </div>

<script language="JavaScript" type="text/JavaScript">
 function toggle(targetid){
 	document.getElementById("div"+targetid).style.display="block";        
 	for(var i =1;i<=4;i++){
		if(targetid != i){
			document.getElementById("div"+i).style.display="none";
		}
	}
 }
 </script>	
<script type="text/javascript">
var timeout         = 500;
var closetimer		= 0;
var ddmenuitem      = 0;

function jsddm_open()
{	jsddm_canceltimer();
	jsddm_close();
	ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
	
	}

function jsddm_close()
{	if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');
}

function jsddm_timer()
{	closetimer = window.setTimeout(jsddm_close, timeout);
   
}

function jsddm_canceltimer()
{	if(closetimer)
	{	window.clearTimeout(closetimer);
		closetimer = null;}}

$(document).ready(function()
{	$('#jsddm > li').bind('mouseover', jsddm_open);
	$('#jsddm > li').bind('mouseout',  jsddm_timer);});

document.onclick = jsddm_close;
  </script>
<script type="text/javascript"> 
	function blurtitle(v){ //鼠标滑过显示内容方法
		for(var i=0;i<5;i++){ //以3个标题举例
			if("title"+i == v.id){ //当前循环的i如果是正确的标题，将内容的display设为block，即显示
				document.getElementById("content"+i).style.display = "block";
			}else{ //当前循环的i是其他标题，将内容设为none，即隐藏
				document.getElementById("content"+i).style.display = "none"; 
			}
		}
	}
	
	
</script>
<SCRIPT src="js/jquery.bxslider.min.js" type=text/javascript></SCRIPT>
<script type="text/javascript">
$('.bxslider1').bxSlider({
  auto:true,
  infiniteLoop: true,
  hideControlOnEnd: true
});
</script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
