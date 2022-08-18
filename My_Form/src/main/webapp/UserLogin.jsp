<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file = "Header.jsp" %>
	<h1 align="center">Login Form</h1>
	<h2>
	<font align = "center" color = "blue">Hii , Guest...</font>
	</h2>
	

	<form action="UserCtnl" method="post">
		<%
			String smsg = (String) request.getAttribute("smsg");
			String email = (String) request.getAttribute("email");
			String pwd = (String) request.getAttribute("pwd");
			String msg = (String) request.getAttribute("msg");

			if (smsg != null) {
		%>
		<font color="red"> <%=smsg%>
		</font>
		<%
			}
		%>
		<center>

			<%
				if (msg != null) {
			%>
			<font color="red"><%=msg%></font>
			<%
				}
			%>
		</center>
		<table align="center">
			<tr>
				<th>User name*:</th>
				<td><input type="email" name="email" value=""></td>
				<td>
					<%
						if (email != null) {
					%> <font color="red"><%=email%></font> <%
 	}
 %>
				</td>

			</tr>
			<tr>
				<th>Password*:</th>
				<td><input type="password" name="pwd" value=""></td>
				<td>
					<%
						if (pwd != null) {
					%> <font color="red"><%=pwd%></font> <%
 	}
 %>
				</td>
			</tr>
			<tr>
			<th></th>
				<td><input type="submit" name="Login" value="Log In"> <input
					type="submit" name="Cancel" value="Cancel"></td>
				<td>
			</tr>
			<tr><th></th>
				<td><a href="RegistrationForm.jsp"><b>New Registration</b></a></td>
			</tr>

		</table>
	</form>
</body>
</html>