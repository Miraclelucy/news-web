<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>注册页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">

var data=new Array(
new Array("北京","海淀","朝阳","宣武","密云"),
new Array("上海","浦东","徐家汇","松江"),
new Array("天津","天津"),
new Array("山东","济南","青岛","淄博","德州","烟台"),
new Array("广东","广州","深圳","珠海","汕头","中山"),
new Array("山西","太原","大同")
)

function initPro()
{ 
	var pro=document.form1.province;
	for(i=0;i<data.length;i++)
	{
	pro.options.add(new Option(data[i][0],i))
	}
}
function initCity()
{   
    
	var pro=document.form1.province;
	var city=document.form1.city;
	var proid=pro.options[pro.selectedIndex].value;
	city.length=1;
	for(i=1;i<data[proid].length;i++)
	{
		city.options.add(new Option(data[proid][i],data[proid][i]));
	}
}
function  check()
{
    var name=document.form.name.value;
     var pwd=document.form.pwd.value;
      var pwd1=document.form.pwd1.value;
       var email=document.form.email.value;
       var add=document.form.add.value;
       if(pwd!=pwd1)
       {
         alert("密码不一致");
         return false;
       }
       if(name=="")
       {
         alert("用户名不为空");
         return false; 
       }
       if(pwd=="")
       {
         alert("密码不为空");
         return false; 
       }
        if(email=="")
       {
         alert("邮箱不为空");
         return false; 
       }
       if(add=="")
       {
         alert("地址不为空");
         return false;  
       }
       return true;
}
</script>
	</head>

	<body>
		<form action="user/userSave" method="post" id="form" name="form">
			<center>
				<table>
					<tr>
						<td >
							用户名：
						</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
					<tr>
						<td width="80">
							密 &nbsp;码：
						</td>
						<td>
							<input type="password" name="pwd" />
						</td>
					</tr>
					<tr>
						<td width="80">
							确认密码：
						</td>
						<td>
							<input type="password" name="pwd1" />
						</td>
					</tr>
					<tr>
						<td>
							性 &nbsp;别：
						</td>
						<td colspan="0">
							<input type="radio" name="sex" checked="checked" value="男">
							男
							<input type="radio" name="sex" value="女">
							女
						</td>
					</tr>
					<tr>
						<td colspan="0">
							邮箱地址：
						</td>
						<td>
							<input type="text" name="email" />
						</td>
					</tr>
					<tr>
						<td>
							住 &nbsp;址： 
						</td>
						<td>
							<input type="text" name="add" />
						</td>
										
					<tr>
						<td colspan="2">
							<input type="submit" value="提交" onClick="return check()">
							&nbsp; &nbsp;
							<input type="button" value="返回"
							onClick="javascript: window.location.href='<%=basePath %>index.jsp'">
						</td>
					</tr>

				</table>
			</center>
		</form>
	</body>
	<%@ include file="foot.jsp"%>
</html>
