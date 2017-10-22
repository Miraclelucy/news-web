<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String patha = request.getContextPath();
String basePatha = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+patha+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePatha%>">

		<title>首页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePatha %>images/css.css" type="text/css"
			rel="stylesheet">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<body bgcolor="#ffffff" text="#000000" leftmargin="0" topmargin="0">
		<center>
			<table width="735" height="163" border="0" cellpadding="0"
				cellspacing="0">
				<%-- 注册提示  --%>
				<tr>
					<td height="20" colspan="3"></td>
				</tr>
				<tr>
					<td width="324" height="30" bgcolor="">
						【
						<a href="<%=basePatha %>user/login.jsp">会员登录</a>】 【
						<a href="<%=basePatha %>user/zhuce.jsp">免费注册</a>】
						<%if(request.getSession().getAttribute("userName")!=null){%>
						<%=request.getSession().getAttribute("userName") %>,欢迎访问网站！
						<%} %> 
					</td>
					<%-- 时间显示  --%>
					<td width="240">
						<SCRIPT>setInterval("time.innerHTML=new   Date().toLocaleString();",1000)     </SCRIPT>
						<SPAN id="time"></SPAN>
					</td>
					<%-- 加入收藏 --%>
					<td width="180">
						<a href="shoucang.jsp"> 加入收藏</a> &nbsp;&nbsp;
						<a
							onClick="this.style.behavior='url(#default#homepage)';
          this.setHomePage('<%=basePatha %>');"
							href="http://localhost/#">设为首页</a>
					</td>
				</tr>


				<tr>
					<td height="30" colspan="3" align="center" bgcolor="">
						<center>
							<a href="<%=basePatha %>">首页|&nbsp;</a>		
							<a href="<%=basePatha %>money.jsp">财经|&nbsp;</a>
							<a href="<%=basePatha %>sport.jsp">体育|&nbsp;</a>
							<a href="<%=basePatha %>yule.jsp">娱乐|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">社区|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">财经|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">国际|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">军事|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">法治|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">港澳|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">金融|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">房地产|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">游戏|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">汽车|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">文化|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">健康|&nbsp;</a>
							<a href="<%=basePatha %>money.jsp">图片|&nbsp;</a>
						</center>
					</td>
				</tr>
				<tr>
					<td height="75" colspan="3">
						<img src="<%=basePatha %>/images/775.jpg" width="728" height="75">
					</td>
				</tr>

			</table>

		</center>

	</body>
</html>
