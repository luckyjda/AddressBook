<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<style type="text/css">
			body {
				margin: 0;
				padding: 0;
				overflow-x: hidden;
			}
			
			html,body {
				height: 100%;
			}
			
			img {
				border: none;
			}
			
			* {
				font-family: '微软雅黑';
				font-size: 12px;
				color: #626262;
			}
			
			dl,dt,dd {
				display: block;
				margin: 0;
			}
			
			a {
				text-decoration: none;
			}
			
			#bg {
				background-image: url(images/content/dotted.png);
			}
			
			.container {
				width: 100%;
				height: 100%;
				margin: auto;
			}
			
			/*left*/
			.leftsidebar_box {
				width: 160px;
				height: auto !important;
				overflow: visible !important;
				position: fixed;
				height: 100% !important;
				background-color: #3992d0;
			}
			
			.line {
				height: 2px;
				width: 100%;
				background-image: url(images/left/line_bg.png);
				background-repeat: repeat-x;
			}
			
			.leftsidebar_box dt {
				padding-left: 40px;
				padding-right: 10px;
				background-repeat: no-repeat;
				background-position: 10px center;
				color: #f5f5f5;
				font-size: 14px;
				position: relative;
				line-height: 48px;
				cursor: pointer;
			}
			
			.leftsidebar_box dd {
				background-color: #317eb4;
				padding-left: 40px;
			}
			
			.leftsidebar_box dd a {
				color: #f5f5f5;
				line-height: 20px;
			}
			
			.leftsidebar_box dt img {
				position: absolute;
				right: 10px;
				top: 20px;
			}
			
			.system_log dt {
				background-image: url(images/left/system.png)
			}
			
			.custom dt {
				background-image: url(images/left/custom.png)
			}
			
			.channel dt {
				background-image: url(images/left/channel.png)
			}
			
			.app dt {
				background-image: url(images/left/app.png)
			}
			
			.cloud dt {
				background-image: url(images/left/cloud.png)
			}
			
			.syetem_management dt {
				background-image: url(images/left/syetem_management.png)
			}
			
			.source dt {
				background-image: url(images/left/source.png)
			}
			
			.statistics dt {
				background-image: url(images/left/statistics.png)
			}
			
			.leftsidebar_box dl dd:last-child {
				padding-bottom: 10px;
			}
		</style>
	</head>

	<body>
	<div class="container">
	<div class="leftsidebar_box">
		<div class="line"></div>
		<dl class="system_log">
			<dt onClick="changeImage()">系统记录<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">充值记录</a></dd>
			<dd><a href="#">短信充值记录</a></dd>
			<dd><a href="#">消费记录</a></dd>
			<dd><a href="#">操作记录</a></dd>
		</dl>
	
		<dl class="custom">
			<dt onClick="changeImage()">联系人管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">联系人列表</a></dd>
			<dd><a href="#">添加联系人</a></dd>
			<dd><a href="#">修改联系人</a></dd>
			<dd><a href="#">删除联系人</a></dd>
		</dl>
	
		<dl class="channel">
			<dt>管理员管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">管理员列表</a></dd>
			<dd><a href="#">添加管理员</a></dd>
			<dd><a href="#">修改管理员</a></dd>
			<dd><a href="#">删除管理员</a></dd>
		</dl>
	
		<dl class="app">
			<dt onClick="changeImage()">APP管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">App运营商管理</a></dd>
			<dd><a href="#">开放接口管理</a></dd>
			<dd><a href="#">接口类型管理</a></dd>
		</dl>
	
		<dl class="cloud">
			<dt>大数据云平台<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">平台运营商管理</a></dd>
		</dl>
	
		<dl class="syetem_management">
			<dt>系统管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">后台用户管理</a></dd>
			<dd><a href="#">角色管理</a></dd>
			<dd><a href="#">客户类型管理</a></dd>
			<dd><a href="#">栏目管理</a></dd>
			<dd><a href="#">微官网模板组管理</a></dd>
			<dd><a href="#">商城模板管理</a></dd>
			<dd><a href="#">微功能管理</a></dd>
			<dd><a href="#">修改用户密码</a></dd>
		</dl>
	
		<dl class="source">
			<dt>素材库管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">图片库</a></dd>
			<dd><a href="#">链接库</a></dd>
			<dd><a href="#">推广管理</a></dd>
		</dl>
	
		<dl class="statistics">
			<dt>统计分析<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">客户统计</a></dd>
		</dl>
	
	</div>

	</div>
	
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
	$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
	$(function(){
		$(".leftsidebar_box dd").hide();
		$(".leftsidebar_box dt").click(function(){
			$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
			$(this).css({"background-color": "#317eb4"});
			$(this).parent().find('dd').removeClass("menu_chioce");
			$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
			$(this).parent().find('img').attr("src","images/left/select_xl.png");
			$(".menu_chioce").slideUp(); 
			$(this).parent().find('dd').slideToggle();
			$(this).parent().find('dd').addClass("menu_chioce");
		});
	})
	</script>
	<script src="http://www.w2bc.com/scripts/2bc/_gg_980_90.js" type="text/javascript"></script>
	</body>
</html>
