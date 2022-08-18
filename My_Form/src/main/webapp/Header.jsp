<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String user = (String) session.getAttribute("username");
out.println("welcome"+user);
%>
<a href="">Home</a>
<a href="">Info</a>
<a href="">Tutorials</a>
<a href="">About us</a>
<a href="">Log Out</a>
</body>
</html>