<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../admin/head.jsp"%>
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
            function getContext() {
                var test=document.getElementById("mytext").innerHTML;
                console.log("-------load-----"+test);
				alert(test);
            }

		</script>
	</head>

	<body bgcolor="" onload="getContext()">
	<p style="margin-left: 25%" id="mytext"> test iframe ！</p>
		<iframe src="/admin/newsAdd.jsp" style="width: 1000px;height: 800px ;float: inherit; margin-left: 25%" >
		</iframe>
	<image src=${log} ></image>
	<input value=${ids}/>
	</body>
	<%@ include file="../admin/foot.jsp"%>
</html>


