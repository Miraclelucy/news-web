<%@ page import="com.lucy.until.StringUtil" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="/admin/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>欢迎访问新闻发布后台系统</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${fns:getThemePath()}/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${fns:getThemePath()}/themes/icon.css" />
    <script type="text/javascript" src="${fns:getThemePath()}/jquery.min.js"></script>
    <script type="text/javascript" src="${fns:getThemePath()}/jquery.easyui.min.js"></script>
	<script type="text/javascript" src='js/outlook2.js'> </script>
    <script type="text/javascript" src='js/menu.js'> </script>


</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"></div></noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 50px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px; padding-top:10px;" >
            <%
             ServletContext servletContext=config.getServletContext();
             // application 是一个ServletContext实例
                // config 是一个ServletConfig实例
                //request  是一个httpServletRequest实例
                //response  是一个httpServletResponse实例
                //session 是一个httpSession实例 管理会话
                //page  代表JSP页面本身， 对JSP页面创建者通常不可访问，所以一般很少用
                //pageContext  是一个PageContext
                //exception
                //out  是一个JspWriter 用来向客户端输出数据

             String count2= StringUtil.null2String(application.getAttribute("count"));
            %>
        在线人数：<%=count2%>人 &nbsp;
           <c:set var="now" value="<%=new Date()%>"></c:set>
            <fmt:formatDate type="time" value="${now}"></fmt:formatDate>
        </span>
        <span style="float:right; padding-right:20px; padding-top:10px;" class="head" > <%=request.getSession().getAttribute("adminName") %>，欢迎来到新闻管理后台！！<a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 28px; "><img src="images/blocks.gif" width="40" height="40" align="absmiddle" />后台管理系统</span>


    </div>
    
    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
     <div id="nav" class="easyui-accordion" fit="true" border="false">		
	 </div>
    </div>
    
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;" >
				
                <h1 style="font-size:24px; text-align:center">系统功能介绍</h1>
				<div style="font-size:24px; margin-left:100px;">
                   
                    <dl>
                    <dt style="font-size:18px; font-weight:300px; ">新闻类型管理</dt>
                    <dd>├ 类型编辑</dd>
                    <dd>├ 类型添加</dd>
                    <dd>├ 类型删除</dd>
                    </dl>
                  
                    <dl>
                       <dt style="font-size:18px; font-weight:300px">新闻管理</dt>
                        <dd>├ 新闻编辑</dd>
	                    <dd>├ 新闻添加</dd>
	                    <dd>├ 新闻删除</dd>
	                    <dd>├ 新闻采集</dd>             
                    </dl>
                    <dl>
                       <dt style="font-size:18px; font-weight:300px"> 用户管理 </dt>
                        <dd>├ 用户查询</dd>
	                    <dd>├ 封号管理（用户状态可用，禁用）</dd>
                    </dl>
                    <dl>
                       <dt style="font-size:18px; font-weight:300px"> 系统管理</dt>
                       <dd>├ 管理员设置</dd>
                       <dd>├ 网站参数配置</dd>
                       <dd>├ 系统日志</dd>
                    </dl>
                </div>
			</div>
		</div>
    </div>
       
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

	<div id="mm" class="easyui-menu"  title="刷新"  style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>

</body>
</html>