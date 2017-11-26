<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-User" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" user="text/css" />
<link rel="stylesheet" user="text/css"
	href="${fns:getThemePath()}/themes/default/easyui.css" />
<link rel="stylesheet" user="text/css"
	href="${fns:getThemePath()}/themes/icon.css" />
<script user="text/javascript" src="${fns:getThemePath()}/jquery.min.js"></script>
<script user="text/javascript"
	src="${fns:getThemePath()}/jquery.easyui.min.js"></script>
<script user="text/javascript" 
	src="${fns:getThemePath()}/locale/easyui-lang-zh_CN.js"></script>
<script user="text/javascript" src="script/userScript.js"> </script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="新闻信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="/admin/user?method=list" fit="true"
		toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="userId" width="50" align="center">用戶编号</th>				
				<th field="userName" width="100" align="center">用戶名</th>
				<th field="userSex" width="100" align="center">性別</th>
				<th field="userPassword" width="100" align="center">密碼</th>
				<th field="userEmail" width="100" align="center">郵箱</th>
				<th field="userAdd" width="100" align="center">地址</th>
				<th field="userState" width="100" align="center">状态</th>

			</tr>
		</thead>

	</table>


	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 150px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px">
				<tr>
					<td>状态：</td>
					<td><select class="easyui-combobox" id="useState" name="useState"
						editable="false" panelHeight="auto" style="width: 155px">							
							<option value="0">禁用</option>
							<option value="1">可用</option>
					</select></td>
				</tr>
				
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveUser()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeUserDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>