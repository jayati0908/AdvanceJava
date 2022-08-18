<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<h1 align="center">Login Form</h1>

	<form action="User" method="post">


		<table align="center">
			<tr>
				<th>User name*:</th>
				<td><input type="text" name="email" value=""></td>

			</tr>
			<tr>
				<th>Password*:</th>
				<td><input type="password" name="pwd" value=""></td>
				<td><input type="hidden" name="jsessionid"
					value="<%=session.getId()%>"></input></td>
			</tr>
			<tr>
				<td><input type="submit" name="Login" value="Log In"> <input
					type="submit" name="Cancel" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>