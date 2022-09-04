<%@page import="com.raysetch.bean.Registration_Bean"%>
<%@page import="com.raysetch.bean.Student_MarksheetBean"%>
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
Registration_Bean bean = (Registration_Bean) session.getAttribute("get");
if(bean != null){
	%>
	<h4>Hello...
	<%=bean.getfName() %>
	<a href="">Home|</a>
	<a href="">About Us|</a>
	<a href="">Contact us|</a>
	<a href="">Tutorials|</a>
	<a href="LogOut.jsp">Log Out|</a>
	<a href="StudentMark.jsp">Student Marksheet</a>
	</h4>
	<% 
}else{
	%>
	<h3>Hello Guest...</h3>
	<a href = "LoginCtnl">Login</a>
<% 
}
%>
	
</body>
</html>