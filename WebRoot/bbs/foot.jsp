<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String pathft = request.getContextPath();
String basePathft = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathft+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePathft%>">

		<title>My JSP 'foot.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="images/css.scc" type="text/css" rel="stylessheet">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<hr color="blue" />
		<table align="center" width="45%">
			<tr>
				<td>
					<a href="index.jsp">回到首页</a>
				</td>
				<td>
					<a href="index.jsp">友情链接</a>
				</td>
				<td>
					<a href="index.jsp">公司地图</a>
				</td>
				<td>
					<a href="index.jsp">联系我们</a>
				</td>
				<td>
					<a href="bbs/bbs.jsp">留言中心</a>
				</td>
				<td>
					<a href="search.jsp">站内搜索</a>
				</td>
				<td>		
					<a href="admin/login.jsp">管理登录</a>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="7" width="45%">
					建议请使用IE6.0以上的版本 ICP 88888888
				</td>
			</tr>
		</table>
	</body>
</html>
