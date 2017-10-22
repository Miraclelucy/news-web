

var url;	
	function deleteNews(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].newId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("newsDelete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.errorMsg);
					}
				},"json");
			}
		});
	}

	
	function openNewsAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加新闻信息");
		url="newsSave";
	}
	
	function saveNews(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
//				if($('#sex').combobox("getValue")==""){
//					$.messager.alert("系统提示","请选择性别");
//					return false;
//				}				
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#newTitle").val("");
		$("#newContent").val("");
		$("#newType").combobox("setValue","");
		$("#newTime").datebox("setValue","");		
		
	}
	
	function closeNewsDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openNewsModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑新闻信息");
		$("#fm").form("load",row);
		url="newsSave?newId="+row.newId;
	}