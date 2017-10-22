<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.lucy.service.Newsservice"%>
<%@page import="com.lucy.bean.News"%>
<%@page import="com.lucy.dao.Getcontext"%>
<%@page import="com.lucy.bean.Comment"%>
<%@page import="com.lucy.service.Commentservice"%>
<%@ include file="head.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
<STYLE type="text/css">
.tt 
{
	background-image: url("images/headbg4.gif") ;
	 background-repeat:repeat-x;
}
</STYLE>
		<base href="<%=basePath%>">

		<title>网站首页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="texy/css" href="images/css.css">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

<body background="">
	<center >
	<table  width="709" border="0" cellspacing="0" cellpadding="0">

		<tr>
			<td height="420" colspan="1" align="center" >
				<table height="200"  cellpadding="5" cellspacing="5">
					<tr>
						<td align="center" class="tt" colspan="4">
							<a href="index.jsp"><font size="3" color="blue">新闻中心</font></a>
						</td>
					</tr>
					<tr> 
					<%
 						ArrayList<News>  v=null;
					              v=new Newsservice().getnews();
					              News  news=null;
					              Iterator<News> it=v.iterator();
					              while(it.hasNext()){
					              news=(News)it.next();
 					%>
					<td colspan="3" >
					<a href="news.jsp?newsid=<%=news.getNewId()%>">
					<%=news.getNewTitle()%></a><br/></td>
					<td> <%=news.getNewTime().substring(0,16)%></td>	       		
				</tr>
				
				<%
									}
								%>
				</table>
				<table height="200"  cellpadding="5" cellspacing="5">
					<tr>
						<td align="center" class="tt" colspan="4">
							<a href="index.jsp"><font size="3" color="blue">热门搜索&nbsp;&nbsp;</font></a>
						</td>
					</tr>
					<tr> 
						<%
 							ArrayList<News>  v1=null;
 							              v=new Newsservice().getnews();
 							              News  news1=null;
 							              Iterator<News> it1=v.iterator();
 							              while(it1.hasNext()){
 							              news1=(News)it1.next();
 						%>
						<td colspan="3" >
						<a href="news.jsp?newsid=<%=news1.getNewId()%>">
						<%=news1.getNewTitle()%></a><br/></td>
						<td> <%=news1.getNewTime().substring(0,16)%></td>		
					</tr>								
					<%
														}
													%>
				</table>
			</td>
			
			<td width="16">
				<img src="images/c2.jpg" width="16" height="385" />
			</td>
			<td align="center">
				<table cellspacing="5" cellpadding="5">									
					<tr>					
						<td align="center">
						<!--主图flash start -->
							<div>
							<div id="ifocus">
								<div id="ifocus_pic">
									<div id="ifocus_piclist" style="left:0; top:0;">
										<ul>
								<li><a href="money.jsp"><img src="images/img1.jpg" alt="成都高三学生剥洋葱催泪 让眼泪冲走高考压力" width="330" height="245" /></a></li>
								<li><a href="money.jsp"><img src="images/img2.jpg" alt="四川一家长中考前收短信：教师礼物费100元" width="330" height="245"/></a></li>
								<li><a href="money.jsp"><img src="images/img3.jpg" alt="高校文艺范男生寝室蹿红网络 女生怒喊：换寝室" width="330" height="245"/></a></li>
								<li><a href="money.jsp"><img src="images/img4.jpg" alt="高校教务处主页现美女学霸照片 访问量翻番" width="330" height="245"/></a></li>
										</ul>
									</div>
									<div id="ifocus_opdiv"></div>
									<div id="ifocus_tx">
									  <ul>
											<li class="current">成都高三学生剥洋葱催泪 让眼泪冲走高考压力</li>
											<li class="normal">四川一家长中考前收短信：教师礼物费100元</li>
											<li class="normal">高校文艺范男生寝室蹿红网络 女生怒喊：换寝室</li>
											<li class="normal">高校教务处主页现美女学霸照片 访问量翻番</li>
									  </ul>
								  </div>
								</div>
								<div id="ifocus_btn">
									<ul>
										<li class="current"><img src="images/img1.jpg" alt="" /></li>
										<li class="normal"><img src="images/img2.jpg" alt="" /></li>
										<li class="normal"><img src="images/img3.jpg" alt="" /></li>
										<li class="normal"><img src="images/img4.jpg" alt="" /></li>
								  </ul>
							  </div>
							</div>
						</div>
					<!--主图flash end -->
						</td>						
					</tr>					
				</table>
			</td>
		</tr>
		<tr>
			<td width="207" height="106" align="center">
				<table>
					<tr>
						<td class="tt" colspan="2" align="center">
							<a href="toupiao.jsp"><font size="2" color="blue">热点投票</font></a>
						</td>
						<!-- 投票内表格 -->
					</tr>
					<tr>
						<td width="202">
							投票主题
						</td>
						<td width="280">
							投票中
						</td>
						
					</tr>
					<%
						ArrayList<Comment>  comments=new Commentservice().getcomment();
							              Iterator<Comment> it2=comments.iterator();
							              while(it2.hasNext()){
							                 Comment  comment=(Comment)it2.next();
					%>
					<tr>
						<td><%=comment.getCommentname() %></td>
						<td><%=comment.getCommentcount() %></td>
					</tr>
					<% 
		              }
		            %>
				</table>
			</td>
			</tr>
			<tr>
		
	</table>
</center>
<%@ include file="foot.jsp"%>
</body>

<!-- 图片轮播CSS以及js文件 -->
<style type="text/css">
#ifocus {
	width:428px;
	height:304px;
	border:1px solid #DEDEDE;
	background:#F8F8F8;
}
	#ifocus_pic {
	display:inline;
	position:relative;
	float:left;
	width:330px;
	height:280px;
	overflow:hidden;
	margin:5px 0 0 3px;
}
		#ifocus_piclist { position:absolute;width:330px; }
		#ifocus_piclist li {
	width:330px;
	height:280px;
	overflow:hidden;
}
		#ifocus_piclist img {
	width:330px;
	height:245px;
}
	#ifocus_btn {
	display:inline;
	float:right;
	width:91px;
	margin-top:4px;
}
		#ifocus_btn li { width:91px; height:57px; cursor:pointer; opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50); margin-bottom:5px;}
		#ifocus_btn img {
	width:75px;
	height:45px;
	margin:7px 0 0 10px;
}
		#ifocus_btn .current { background: url(http://i6.chinanews.com/edu/hp2009/ifocus_btn_bg.gif) no-repeat; opacity:1; -moz-opacity:1; filter:alpha(opacity=100); }
	#ifocus_opdiv {
	position:absolute;
	left:0px;
	bottom:0px;
	width:330px;
	height:35px;
	background:#F8F8F8;

}
	#ifocus_tx {
font-size:14px;
text-align:center;
        width:330px;
height:35px;
line-height:35px;
	position:absolute;
	left:0px;
	bottom:0px;
	color:#1F6DB4;
}
		#ifocus_tx .normal { display:none; }
</style>

<script type="text/javascript">
function $(id) { return document.getElementById(id); }

function addLoadEvent(func){
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function(){
			oldonload();
			func();
		}
	}
}

function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem = document.getElementById(elementID);
  if (elem.movement) {
    clearTimeout(elem.movement);
  }
  if (!elem.style.left) {
    elem.style.left = "0px";
  }
  if (!elem.style.top) {
    elem.style.top = "0px";
  }
  var xpos = parseInt(elem.style.left);
  var ypos = parseInt(elem.style.top);
  if (xpos == final_x && ypos == final_y) {
		return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/10);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/10);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/10);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/10);
    ypos = ypos - dist;
  }
  elem.style.left = xpos + "px";
  elem.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem.movement = setTimeout(repeat,interval);
}

function classNormal(iFocusBtnID,iFocusTxID){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	for(var i=0; i<iFocusBtns.length; i++) {
		iFocusBtns[i].className='normal';
		iFocusTxs[i].className='normal';
	}
}

function classCurrent(iFocusBtnID,iFocusTxID,n){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
	var iFocusTxs = $(iFocusTxID).getElementsByTagName('li');
	iFocusBtns[n].className='current';
	iFocusTxs[n].className='current';
}

function iFocusChange() {
	if(!$('ifocus')) return false;
	$('ifocus').onmouseover = function(){atuokey = true};
	$('ifocus').onmouseout = function(){atuokey = false};
	var iFocusBtns = $('ifocus_btn').getElementsByTagName('li');
	var listLength = iFocusBtns.length;
	iFocusBtns[0].onmouseover = function() {
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (listLength>=2) {
		iFocusBtns[1].onmouseover = function() {
			moveElement('ifocus_piclist',0,-280,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',1);
		}
	}
	if (listLength>=3) {
		iFocusBtns[2].onmouseover = function() {
			moveElement('ifocus_piclist',0,-560,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',2);
		}
	}
	if (listLength>=4) {
		iFocusBtns[3].onmouseover = function() {
			moveElement('ifocus_piclist',0,-840,5);
			classNormal('ifocus_btn','ifocus_tx');
			classCurrent('ifocus_btn','ifocus_tx',3);
		}
	}
}

setInterval('autoiFocus()',5000);
var atuokey = false;
function autoiFocus() {
	if(!$('ifocus')) return false;
	if(atuokey) return false;
	var focusBtnList = $('ifocus_btn').getElementsByTagName('li');
	var listLength = focusBtnList.length;
	for(var i=0; i<listLength; i++) {
		if (focusBtnList[i].className == 'current') var currentNum = i;
	}
	if (currentNum==0&&listLength!=1 ){
		moveElement('ifocus_piclist',0,-280,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',1);
	}
	if (currentNum==1&&listLength!=2 ){
		moveElement('ifocus_piclist',0,-560,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',2);
	}
	if (currentNum==2&&listLength!=3 ){
		moveElement('ifocus_piclist',0,-840,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',3);
	}
	if (currentNum==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==1&&listLength==2 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
	if (currentNum==2&&listLength==3 ){
		moveElement('ifocus_piclist',0,0,5);
		classNormal('ifocus_btn','ifocus_tx');
		classCurrent('ifocus_btn','ifocus_tx',0);
	}
}
addLoadEvent(iFocusChange);
</script>
</html>

