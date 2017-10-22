<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.service.Newsservice"%>
<%@page import="com.lucy.bean.News"%>
<%@ include file="head.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>详细新闻</title>

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
			<%
				int newsid = Integer.parseInt(request.getParameter("newsid"));
				if (!request.getParameter("newsid").equals("")) {
					ArrayList<News> news = new Newsservice().getnews(newsid);
					Iterator<News> it = news.iterator();
					if (it.hasNext()) {
						News nw = it.next();
			%>
			<tr>
				<td align="center"><%=nw.getNewTitle()%></td>
			</tr>
			<tr>
				<td>时间： <%=nw.getNewTime().substring(0, 10)%></td>
			</tr>
			<tr>
				<td><%=nw.getNewType()%></td>
			</tr>
			<tr>
				<td><%=nw.getNewContent()%></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<%
				}
				} else {
					response.sendRedirect("index.jsp");
				}
			%>
		</table>

	</center>
</body>
<%@ include file="foot.jsp"%>
</html>
