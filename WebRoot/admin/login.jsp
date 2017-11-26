<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/user/head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<base href="<%=basePath%>">

		<title>登陆</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="../images/css.css" type="text/css" rel="stylesheet">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
		function check()
		{
		   if(document.from.name.value=="")
		   {
			 txt.innerHTML="用户名不为空";
			 return false;
		   }
		   if(document.from.pwd.value=="")
		   {
			 txt.innerHTML="密码不为空";
			 return false;
		   }
			return true;
		}

		</script>
	</head>

	<body bgcolor="">
		<center>
			<span id="txt">${Msg2} </span>
			<form action="/admin?method=login" method="post" name="from">
				<table width="50%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td >
							&nbsp;名称：
						</td>
						<td  >
							&nbsp;
							<input type="text" name="adminName" value="${cookie.rememberMeName.value}">
						</td>
					</tr>
					<tr>
						<td >
							&nbsp;密码：
						</td>
						<td >
							&nbsp;
							<input type="password" name="adminPwd" value="${cookie.rememberMePwd.value}">
						</td>
					</tr>
					<tr>
						<td >
							&nbsp;验证码：<image src="/validateCode"/>
						</td>
						<td >
							&nbsp;
							<input type="text" name=validateCode>
						</td>
					</tr>
					<tr>
						<td >
							&nbsp;记住我
						</td>
						<td >
							&nbsp;
							<input type="checkbox" name=rememberMe>
						</td>
					</tr>
					<tr>
						<td >
							&nbsp;下次自动登录
						</td>
						<td >
							&nbsp;
							<input type="checkbox" name=autologin>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="提交" onClick="return check()">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="返回"
								onClick="javascript: window.location.href='<%=basePath %>index.jsp'">
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
	<%@ include file="/user/foot.jsp"%>
</html>


