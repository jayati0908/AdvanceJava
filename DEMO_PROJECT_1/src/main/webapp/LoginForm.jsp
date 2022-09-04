<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b><%@include file="Header.jsp"%></b>
	<hr>
	<b><%@include file="Footer.jsp"%></b>
	<form action="LoginCtnl" method="post">
		<center>
			<%
				String email = (String) request.getAttribute("email");
				String pwd = (String) request.getAttribute("pass");
			%>
			<h1>Login Your Account...</h1>
			<table>
				<tr>
					<th>Email*:</th>
					<td><input type="email" name="email" value=""> <%
 	if (email != null) {
 %> <font color="red"><%=email%></font> <%
 	}
 %></td>
				</tr>
				<tr>
					<th>Password*:</th>
					<td><input type="password" name="pwd" value=""> <td>
				<%
					if (pwd != null) {
				%> <font color="red"><%=pwd%></font> <%
 	}
 %></td></tr>
				<tr>
					<th></th>
					<td><input type="submit" name="submit" value="LogIn">
						<b><a href="Forgot.jsp">Forgot Your Password?</td>
					</b>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><b><a href="Registration.jsp">Don't have any
								account,create one?</a></b></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>