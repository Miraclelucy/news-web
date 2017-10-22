<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.bean.News"%>
<%@ include file="head.jsp"%>
<%@page import="com.lucy.service.Newsservice"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>站内搜索</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function check()
{    

     var str=document.from.search.value;
     if(str=="")
     {
      
       text.innerHTML="<font color=red >***请输入关键字<font/>";
       return false;
     }
     return true;
}
</script>
	</head>

	<body>
	<form action="searchs.jsp" name="from" method="post">
	<center>
	<span id="text"></span>
    <table>
       <tr><td>
                <input type="text" name="search"  />
                <input type="submit" value="搜索" onclick="return check()" /> 
       </td></tr>
       <tr><td><br/></td></tr>
        <tr><td><br/></td></tr>
         <tr><td><br/></td></tr>
    </table>
   </center>
    </form>
    
	</body>
	<%@ include file="foot.jsp"%>
</html>
