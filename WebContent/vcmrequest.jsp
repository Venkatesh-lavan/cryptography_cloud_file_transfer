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
<%@page import="com.dao.Dao"%>
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
				<li  class="current_page_item"><a href="vcmrequest.jsp" accesskey="1" title="">Home</a></li>
				<li><a href="fileupload.jsp" accesskey="2" title="">Upload</a></li>
				<li><a href="filedownload.jsp" accesskey="3" title="">Download</a></li>
				<li><a href="keyrequest.jsp" accesskey="4" title="">Key Requests</a></li>
				<li><a href="logout.jsp" accesskey="5" title="">Logout</a></li>
			</ul>
		</div>
	</div>
	<div id="header-featured" style="padding-top: 70px;">
		<div id="banner-wrapper">
			<div id="banner" class="container">
			<% session = request.getSession(false); 
				String name = (String) session.getAttribute("name");
				String uid = (String) session.getAttribute("uid");
				String sql = "select * from vcmkey where userid='"+uid+"' and status ='Approved'";
				boolean b = Dao.getStatus(sql);
				if(b == true){
					%>
					<h2>Welcome To <%=name %></h2>
					<%
				}else{
			%>
				<h2>VCM Verification</h2>
				<form action="VCMKey" method="post">
				<div>
				<table class="table" style="width: 650px; margin-left: 20%; margin-right: 25%;">
				<tr><td>VCM Key</td><td><input type="password" name="vkey" class="w3-input"/> </td></tr>
				</table>
				<input type="submit" value="Verify" class="button"/> 
				</div>
				</form>
				</div>
				<%} %>
		</div>
	</div>
</div>

</body>
</html>
