<%@page import="com.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session = request.getSession(false);
String uid = (String) session.getAttribute("uid");
String sql = "update user set status='pending' where email='"+uid+"'";
Dao.update(sql);
sql = "update vcmkey set status='pending' where userid='"+uid+"'";
Dao.update(sql);
session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>