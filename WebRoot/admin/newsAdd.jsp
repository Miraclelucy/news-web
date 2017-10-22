<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.3/themes/icon.css" />
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" 
	src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="script/newsScript.js"> </script>
<script type="text/javascript">
function saveNews(){
	$("#fm").form("submit",{
		url:"newsSave",
		onSubmit:function(){				
			return $(this).form("validate");
		},
		success:function(result){
			if(result.errorMsg){
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}else{
				$.messager.alert("系统提示","保存成功");
				resetValue();
			}
		}
	});
}
</script>
</head>
<body>

<form action="resolveNews" method="post" onsubmit="">
	请输入URL地址：&nbsp;&nbsp;
	<input name="URLString" type="text" id="URLString" style="width:300px"/>
	<input type="submit" value="解析网页"  />
</form>

<form   id="fm" method="post">
   <table id="main" border="0" cellspacing="0" cellpadding="8" >
   <tr>
   <td >类型：</td>
   <td><input class="easyui-combobox" id="newTypeId" name="newTypeId"  
		data-options="panelHeight:'auto',editable:false,valueField:'typeId',textField:'typeName',
		url:'typeComboList'"/></td>           
   </tr>
    <tr>
    <td >标题：</td>
    <td> <input name="newTitle" type="text" id="newTitle" style="width:520px" value="${newTitle}" /></td>   
   </tr>
   <tr>
    <td >内容：</td>
    <td ><textarea cols="100" rows="20" name="newContent" id="newContent">${newContent}
  </textarea></td>   
   </tr>  
   <tr>
	<td>发布时间：</td>
	<td><input class="easyui-datetimebox" name="newtTime" id="newTime"
		required="true" editable="false" value="2014-6-6 09:09"/></td>
  </tr>
   <tr>
    <td><a href="javascript:saveNews()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a></td>
    <td ><a href="javascript:closeNewsDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">重置</a></td>   
   </tr>
  </table>
</form>
</body>
</html>