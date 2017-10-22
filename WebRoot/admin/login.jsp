<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
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
			<span id="txt"></span>
			<form action="adminLogin" method="post" name="from">
				<table width="50%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td >
							&nbsp;名称：
						</td>
						<td  >
							&nbsp;
							<input type="text" name="name">
						</td>
					</tr>
					<tr>
						<td >
							&nbsp;密码：
						</td>
						<td >
							&nbsp;
							<input type="password" name="pwd">
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
	<%@ include file="foot.jsp"%>
</html>


