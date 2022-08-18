<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="getpwd" method="post">
		<%
			String passw = (String) request.getAttribute("passw");

			if (passw != null) {
		%>
		<font color="blue"> <%=passw%>
		</font>
		<%
			}
		%>
		<center>
			<font color="red"><h1>Forget Your Password ?</h1></font>
			<h4>Submit your email address and we'll send you password.</h4>
			<p>
				<i>Password is sent to your registered email id</i>
			</p>

			<table>
				<tr>
					<td>
						<p>Email Id:</p>
					</td>
					<td><input type="email" name="email"
						placeholder="Enter ID here"></td>
					<td>
						<button>
							<a style="float: center; text-decoration: none;">Go 
						</button>
					</td>
				</tr>

				<td></td>
				<td><font color="red">Email is required</font></td>

			</table>
		</center>
	</form>
</body>
</html>