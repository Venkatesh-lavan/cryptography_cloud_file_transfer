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
<%@page import="java.util.Iterator"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.util.List"%>
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
				<li><a href="khome.jsp" accesskey="1" title="">Home</a></li>
				<li class="current_page_item"><a href="kfile.jsp" accesskey="2" title="">File Details</a></li>
				<li><a href="keyre.jsp" accesskey="3" title="">Key Requests</a></li>
				<li><a href="kuser.jsp" accesskey="4" title="">User Keys</a></li>
				<li><a href="index.jsp" accesskey="5" title="">Logout</a></li>
			</ul>
		</div>
	</div>
	<div id="header-featured" style="padding-top: 70px;">
		<div id="banner-wrapper">
			<div id="banner" class="container">
				<h2>Keys for Files</h2>
				</div>
				<%
				String sql = "select * from keyreceived";
				List<String> lt = Dao.getKey(sql);
				Iterator<String> itr = lt.iterator();
				%>
				<table class="w3-table w3-text-white" style="width: 850px;">
				<tr><th>UserID</th><th>File</th><th>Root</th><th>CMK</th><th>DEK</th><th>Date</th></tr>
				<%
				while(itr.hasNext()){
				%>
				<tr><td><%=itr.next() %></td><td><%=itr.next() %></td>
				<td><%=itr.next() %></td><td><%=itr.next() %></td>
				<td><%=itr.next() %></td><td><%=itr.next() %></td></tr>
				<%} %>
				</table>
				 
		</div>
	</div>
</div>

</body>
</html>
