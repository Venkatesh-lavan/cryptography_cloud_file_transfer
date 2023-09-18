<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : SimpleWork 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20140225

-->
<%@page import="com.dao.PortNumber"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.net.InetAddress"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" /> -->
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/w3.css" rel="stylesheet"/>
<link href="main.css" rel="stylesheet"/>
<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo" style="width: 700px;">
			<h1><a href="#" >Research and Design of Cryptography Cloud Framework</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li ><a href="index.jsp" accesskey="1" title="">Homepage</a></li>
				<li><a href="admin.jsp" accesskey="2" title="">Admin</a></li>
				<li><a href="kmc.jsp" accesskey="3" title="">KMC</a></li>
				<li class="current_page_item"><a href="user.jsp" accesskey="4" title="">User</a></li>
				<li><a href="#" accesskey="5" title="">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<%
	 InetAddress localhost = InetAddress.getLocalHost();
	%>
	<div id="header-featured" style="padding-top: 70px;">
		<div id="banner-wrapper">
			<div id="banner" class="container">
				<h2>Register</h2>
				<form action="UserReg" method="post">
				<div>
				<table class="table" style="width: 650px; margin-left: 20%; margin-right: 25%;">
				<tr><td>Name</td><td><input type="text" name="name" class="w3-input" /></td></tr>
				<tr><td>Email</td><td><input type="text" name="uid" class="w3-input"/> </td></tr>
				<tr><td>Password</td><td><input type="password" name="pwd" class="w3-input"/> </td></tr>
				<tr><td>Mobile</td><td><input type="text" name="mob" class="w3-input" /></td></tr>
				<tr><td>Ip</td><td><input type="text" name="ip" value="<%=localhost.getHostAddress() %>" class="w3-input" /></td></tr>
				<tr><td>Port</td><td><input type="text" name="port" value="<%=PortNumber.getPort() %>" class="w3-input" /></td></tr>
				</table>
				<input type="submit" value="Register" class="button"/> 
				<a href="user.jsp" class="button">Login</a>
				</div>
				</form>
				</div>
		</div>
	</div>
</div>

</body>
</html>
