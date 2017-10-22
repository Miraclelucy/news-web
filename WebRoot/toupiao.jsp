<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.service.Commentservice"%>
<%@ include file="head.jsp"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>投票</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
	<center>
	   <table width="45%">
	     <tr><td>投票新闻</td><td>满意度投票</td></tr>
	    				<%
	    					ArrayList<String>  comments=new Commentservice().getcommtitle();
	    				              Iterator<String> it2=comments.iterator();
	    				              while(it2.hasNext()){
	    				                 String  comment=(String)it2.next();
	    				%>
							<tr>
								<td><%=comment %></td>
								<td>&nbsp;&nbsp;满意</td>
							</tr>
							<% 
              }
            %>
	   </table>
	</center>	
	</body>
	<%@ include file="foot.jsp"%>
</html>
