<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'addStudent.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<style type="text/css">
			#form {
				margin-left: 30px;
				margin-top: 30px;
				position: absolute;
			}
			#submit {
				position: relative;
				left:50%;
			}
		</style>
	</head>

	<body>
		<div id="form">
			性别:&nbsp;
			<input type="text" name="name"></input>
			<br />
			<br />
			年龄:&nbsp;
			<input type="text" name="age"></input>
			<br />
			<br />
			<div id = "submit">
				<input type="button" value="提交" />
			</div>

		</div>

	</body>
</html>
