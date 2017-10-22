<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.service.Bbsservice"%>
<%@page import="com.lucy.bean.Bbs"%>
<%@ include file="head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>BBS</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function  check()
{
    var   title=document.form.title.value;
    var   text=document.form.text.value;
    if(text=="") 
    {
          alert("内容不可以为空");
          return false;
    }
    if(title=="")
    {
       alert("标题不为空");
       return false;
    }
    return true;
}
</script>
	</head>
	<body>	
	<center>
	   <%
	   	ArrayList<Bbs> bbs=new Bbsservice().getbbs(); 
 	       Iterator<Bbs> it=bbs.iterator();
 	         while(it.hasNext()){
 	             Bbs bb=it.next();
	   %>
	               <table width="50%" border="1">
	                 <tr><td><%=bb.getBbsUsername()%></td></tr>
	                  <tr><td><%=bb.getBbsTime() %></td></tr>
	                   <tr><td><%=bb.getBbsContent() %></td></tr>
	                     <tr><td><%=bb.getBbsId() %>楼</td></tr>
	                      <tr><td><br/></td></tr>
	               </table>
	             <% 
	         }
	    %>
	   <form action="bbs" name="form">
		<table width="35%">
		<tr><td colspan="3">用  户：</td><td colspan="11"><input type="text" name="name"/></td></tr>
		 <tr><td colspan="3">标  题：</td><td colspan="11"><input type="text" name="title"/></td></tr>
		  <tr><td valign="top" colspan="3">内  容：</td><td colspan="11"><textarea rows="5" cols="40%" name="text"></textarea></td></tr>
		  <tr><TD   style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=1 height=20  src="<%=basePath %>images/face/1.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=2 height=20 src="<%=basePath %>images/face/2.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=3 height=20 src="<%=basePath %>images/face/3.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=4 height=20 src="<%=basePath %>images/face/4.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=5 height=20 src="<%=basePath %>images/face/5.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=6 height=20 src="<%=basePath %>images/face/6.gif" width=20></TD>
                      <TD style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=7 height=20 src="<%=basePath %>images/face/7.gif" width=20></TD>
                      <TD style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=8 height=20 src="<%=basePath %>images/face/8.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=9 height=20 src="<%=basePath %>images/face/9.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=10 height=20 src="<%=basePath %>images/face/10.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=11 height=20 src="<%=basePath %>images/face/11.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=12 height=20 src="<%=basePath %>images/face/12.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=13 height=20 src="<%=basePath %>images/face/13.gif" width=20></TD>
                      <TD  style="CURSOR: hand" onclick=icon(this)>
                      <IMG id=14 height=20 src="<%=basePath %>images/face/14.gif" width=20></TD>
                      <TD vAlign=top ><INPUT type=hidden value=1 name=face> </TD>
                     </tr>
		   <tr><td colspan="6"><input type="submit" value="发表"  onclick="return check()"/></td><td><input type="reset" value="重写"/></td></tr>
		</table>
		</form>
	</center>	
	</body>
	<%@ include file="foot.jsp"%>
</html>
