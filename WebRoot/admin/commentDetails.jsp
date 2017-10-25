<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css" />
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="script/commentScript.js"> </script>
</head>
<body style="margin: 5px;"> 
	<table id="dg" title="评论信息" class="easyui-datagrid" fitColumns="true"
		pagination="true" rownumbers="true" url="commentList" fit="true"
		toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="commentid" width="50" align="center">编号</th>	
				<th field="commenttext" width="100" align="center">评论内容</th>
				<th field="commentname" width="100" align="center">评论人</th>
				<th field="commentnewid" width="100" align="center">所属新闻id</th>

			</tr>
		</thead>

	</table>

	<div id="tb">
		<div>
			<a href="javascript:openCommentAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openCommentModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteComment()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 150px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px">
				<tr>
					<td>评论内容：</td>
					<td><input type="text" name="commenttext" id="commenttext"
						class="easyui-validatebox" required="true" /></td>
				</tr>
				
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveComment()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeCommentDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>