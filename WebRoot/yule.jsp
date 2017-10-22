<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.bean.News"%>
<%@page import="com.lucy.service.Newsservice"%>
<%@ include file="head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>娱乐</title>

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
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td align="center" class="tt" colspan="4">
					<a href="index.jsp"><font size="2" color="black">新闻中心&nbsp;&nbsp;</font></a>
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>							 							  
			<%
			ArrayList<News>  v=null;
              v=new Newsservice().getnews();
              News  news=null;
              Iterator<News> it=v.iterator();
              while(it.hasNext()){
                  news=(News)it.next();
			 %>
			<td colspan="3" >
			<a href="news.jsp?newsid=<%=news.getNewId() %>">
			<%=news.getNewTitle() %></a><br/></td>
			<td> <%=news.getNewTime().substring(0,10) %></td>		
			</tr>
			
			<% 
               }
             %>
		</table>
		</center>
		<br>
	</body>
	<%@ include file="foot.jsp"%>
</html>
