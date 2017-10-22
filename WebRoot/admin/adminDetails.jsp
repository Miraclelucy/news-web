<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Admin" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" admin="text/css" />
<link rel="stylesheet" admin="text/css"
	href="jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" admin="text/css"
	href="jquery-easyui-1.3.3/themes/icon.css" />
<script admin="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script admin="text/javascript"
	src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script admin="text/javascript" 
	src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script admin="text/javascript" src="script/adminScript.js"> </script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="新闻信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="adminList" fit="true"
		toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="adminId" width="50" align="center">编号</th>				
				<th field="adminName" width="100" align="center">名称</th>
				<th field="adminPwd" width="100" align="center">密码</th>
				
			</tr>
		</thead>

	</table>
<div id="tb">
		<div>
			<a href="javascript:openAdminAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openAdminModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改密码</a> <a
				href="javascript:deleteAdmin()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 150px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px">
				<tr>
					<td>名称：</td>
					<td><input type="text" name="adminName" id="adminName"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="adminPwd" id="adminPwd"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveAdmin()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeAdminDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>