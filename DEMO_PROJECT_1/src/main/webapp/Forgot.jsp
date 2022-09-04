<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ForgotCtnl" method="post">
		<center>
			<table>
				<h1>We'll send your password to your registered email id!</h1>
				<%
					String passw = (String) request.getAttribute("pass");

					if (passw != null) {
				%>
				<h5>your password is:-</h5><font color="blue"><%=passw%></font>
				<%
					}
				%>
				<tr>
					<th>Enter your Email_Id*:</th>
					<td><input type="email" name="email" value=""> <input
						type="submit" name="submit" value="Go"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>