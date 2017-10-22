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
    <title>查询结果</title>    
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
     <table cellpadding="5" cellspacing="5" width="61%" align="center">
  			 <%
   				String str=request.getParameter("search");
                 if(str.equals("")||str==null){
                         response.sendRedirect("search.jsp");
                 }else { 
                         
      	         ArrayList<News>  news=new Newsservice().chuaxun(str);
      	           if(news.isEmpty()) {
      	            out.print("<font color=red >***查无结果<font/>");
      	            
      	           }else{
   				%>   
                  <tr><td align="center">标题</td></tr>             
				<%	
               	Iterator<News> it=news.iterator(); 
                 while(it.hasNext()){
                 News nw=it.next();
                 %>
                 <tr><td><a href="news.jsp?newsid=<%=nw.getNewId() %>">
                 <%=nw.getNewTitle() %></a></td></tr>
                  <% 
                }	                 
           }
         }  
    %>
        </table>
        </center>
  </body>
  <%@ include file="foot.jsp"%>
</html>
