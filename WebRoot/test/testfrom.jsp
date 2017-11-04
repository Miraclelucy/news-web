<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.lucy.bean.*"%>
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
				var username=document.getElementById("username").value;
				if(username==null||username==""){
				    alert("null username ");
				    return false;
				}
            }

                function whichButton(event)
                {
                    if (event.button==2)
                    {
                        alert("You clicked the right mouse button!")
                    }
                    else  if (event.button==13)
                    {
                        alert("You clicked the left mouse button!")
                    }
                    else {
                        alert("You clicked the left mouse button!")
                    }
                }

		</script>
	</head>

	<body bgcolor=""  >
	 <form onsubmit="return getContext()" method="post">
		 <input name="username" id="username" value="">
		 <input name="password" id="password" value="">

		 <input name="btn" type="submit" value="提交">
	 </form>
	 <input name="btn" type="button" value="提交2222" onmousedown="whichButton(event)">
<%
String title="hello JSTL!";

%>
	<div>   <%=title%></div>
	 <%
		 String[]  arrfile=new String[]{"abc","123"};
			Comment com=new Comment();
			com.setCommentname("hahhaha,EL表达式");
			application.setAttribute("com",com);
	 %>
	 <% for (int i=0;i<arrfile.length;i++){

	     out.print(arrfile[i]);
	     out.print("<br>");
	 }%>
	 <p>${com.commentname}     <%=com.getCommentname() %><p>

	 <input  id="mailno"  type="hidden" value=${header["user-agent"]}/>

	 <div width="177" height="37" id="bcTarget2"></div>
	</body>
	<%@ include file="../admin/foot.jsp"%>
</html>

<script type="text/javascript" src="../admin/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../admin/jquery-easyui-1.3.3/jquery-barcode.js"></script>
<script>
    var mailno=$("#mailno").val();
    $("#bcTarget1").barcode("123456789963","code128");
    $("#bcTarget2").barcode("123456789963","code128");

</script>

