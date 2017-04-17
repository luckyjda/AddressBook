<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<title>学生管理系统</title>
		<link rel='icon' href='images/left/home.ico' type='image/x-ico' /> 

	<script type="text/javascript">
	function resetValue(){
		document.getElementById("username").value="";
		document.getElementById("password").value="";
	}
	
	function submit(){	
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(username == null || username == "" ) {
			alert('您输入用户名不能为空！');
			return;
		}
		if(password == null || password == "" ) {
			alert('您输入密码不能为空！');
			return;
		}
		auth(username, password);
	}
	
	//认证 ajax 提交数据
	function auth(username,password){
		var returndata;
		//var url='/AddressBook/LoginServlet';
		var url='/AddressBook/LoginServlet?username='+username+'&password='+password;
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){//ajax返回
				returndata=xmlhttp.responseText;
				if("error" == returndata){
					alert('您输入的用户名或者密码错误！');
					//console.log('您输入的用户名或者密码错误！'); 日志打印到后台
				}else{
					window.location.href="/AddressBook/LoginForwordServlet?username=" + username + "&password="+password;
				}
				
			}
		};
		xmlhttp.open('POST',url,false);// true 为异步提交   false 同步提交
		//xmlhttp.send('username='+username+'&password='+password);
		xmlhttp.send();
		return returndata;
	}
	</script>
	<style type="text/css">
		#main {
			background: url("images/login.jpg") no-repeat;
			background-position: center;
			background-attachment: fixed;
			width: 1200px;
			height: 675px;
			margin: 0 auto;
			position: relative;
		}
		#form {
			margin: 0 auto;
			position: absolute;
			left: 300px;
			top: 385px;
		}
	</style>
	</head>

	<body>
		<div id="main">
			<div id="form">
				用户名
				<input type="text" name="name" id="username" >
				<br>
				<br>
				密&nbsp&nbsp&nbsp码
				<input type="password" name="password" id="password">
				<br>
				<br>
				<input type="button" value="提交" onclick="submit()">&nbsp;&nbsp;
				<input type="button" value="重置" onclick="resetValue()">
			</div>
		</div>
	</body>
	
</html>
