

var url;	
	function deleteType(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].typeId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("/admin/type?method=del",{delIds:ids},function(result){
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

	
	function openTypeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加新闻类型信息");
		url="/admin/type?method=save";
	}

	function openTypeModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑新闻信息");
		$("#fm").form("load",row);
		url="/admin/type?method=save&typeId="+row.typeId;
	}
	
	function saveType(){
		$("#fm").form("submit",{
			url:url,
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
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#typeId").val("");
		$("#typeName").val("");
			
		
	}
	
	function closeTypeDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
