<%@ page import="com.lucy.until.CookieUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${fns:getThemePath()}/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${fns:getThemePath()}/themes/icon.css" />
<script type="text/javascript" src="${fns:getThemePath()}/jquery.min.js"></script>
<script type="text/javascript"
	src="${fns:getThemePath()}/jquery.easyui.min.js"></script>
<script type="text/javascript" 
	src="${fns:getThemePath()}/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="script/newsScript.js"> </script>
</head>
<%
	Cookie cookie= CookieUtils.getCookieByName("lastJsp",request.getCookies());
	if(cookie!=null){
		cookie.setValue("newsDetail.jsp");
		cookie.setMaxAge(60*60*1000);
		response.addCookie(cookie);
		System.out.println("----更新lastJsp---");
	}else{
		Cookie cookienew=new Cookie("lastJsp","newsDetail.jsp");
		cookienew.setMaxAge(60*60*1000);
		response.addCookie(cookienew);
	}
%>
<body style="margin: 5px;">
	<table id="dg" title="新闻信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="/admin/news?method=list" fit="true"
		toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="newId" width="50" align="center">编号</th>
				<th field="newTitle" width="100" align="center">标题</th>
				<th field="newContent" width="100" align="center">内容</th>
				<th field="newType" width="100" align="center">类型</th>
				<th field="newTypeId" width="100" align="center" hidden="true">类型ID</th>
				<th field="newTime" width="100" align="center">发布时间</th>

			</tr>
		</thead>

	</table>

	<div id="tb">
		<div>
			<a href="javascript:openNewsAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openNewsModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteNews()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>标题：</td>
					<td><input type="text" name="newTitle" id="newTitle"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><textarea rows="7" cols="50" name="newContent" 
							id="newContent"></textarea></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input class="easyui-combobox" id="newTypeId" name="newTypeId"  
					data-options="panelHeight:'auto',editable:false,valueField:'typeId',textField:'typeName',
					url:'/admin/type?method=getComlist'"/></td>
				</tr>
				<tr>
					<td>发布时间：</td>
					<td><input class="easyui-datetimebox" name="newtTime" id="newTime"
						required="true" editable="false" value="2014-6-6 09:09"/></td>
				</tr>

			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveNews()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeNewsDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>