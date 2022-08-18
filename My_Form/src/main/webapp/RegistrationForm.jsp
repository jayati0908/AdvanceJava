<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Registration form</h1>
	<h2>
	<font color = "blue">Hii , Guest...</font>
	</h2>
	<form action="RegisCtnl" method="post">
		<%
			String fname = (String) request.getAttribute("fname");
			String lname = (String) request.getAttribute("lname");
			String email = (String) request.getAttribute("email");
			String pwd = (String) request.getAttribute("pwd");
			String gender = (String) request.getAttribute("gender");
			String number = (String) request.getAttribute("number");
			String date = (String) request.getAttribute("date");
		%>


		<table align="center">

			<tr>
				<th>First Name:</th>
				<td><input type="text" name="fname" value=""></td>
				<td>
				<td>
					<%
						if (fname != null) {
					%> <font color="Red"> <%=fname%></font> <%
 	}
 %>
				</td>
				</td>
				<td></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lname" value=""></td>
				<td>
				<td>
					<%
						if (lname != null) {
					%> <font color="Red"> <%=lname%></font> <%
 	}
 %>
				</td>
				</td>
			</tr>
			<tr>
				<th>Login Id:</th>
				<td><input type="email" name="email" value=""></td>
				<td>
				<td>
					<%
						if (email != null) {
					%> <font color="Red"> <%=email%></font> <%
 	}
 %>
				</td>
				</td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="pwd" value=""></td>
				<td>
				<td>
					<%
						if (pwd != null) {
					%> <font color="Red"> <%=pwd%></font> <%
 	}
 %>
				</td>
				</td>
			</tr>
			<tr>
				<th>Mobile No:</th>
				<td><input type="text" name="number" value=""></td>
				<td>
				<td>
					<%
						if (number != null) {
					%> <font color="Red"> <%=number%></font> <%
 	}
 %>
				</td>
				</td>
			</tr>
			<tr>
				<th><b>Date of birth:</b></th>
				<td><input type="text" name="date"></td>
				<td>
				<td>
					<%
						if (date != null) {
					%> <font color="Red"> <%=date%></font> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<th><b>Gender:</b></th>
				<td><label for="gender" style="text-align: center;"
					name="gender"></label> <input type="radio" name="gender"
					value=" male" selected>Male <input type="radio"
					name="gender" value="female" selected>Female <input
					type="radio" name="gender" value="others" selected>Others</td>
			</tr>
			<td>
			<td>
				<%
					if (gender != null) {
				%> <font color="Red"> <%=gender%></font> <%
 	}
 %>
			</td>
			</td>
			<tr>
				<th></th>
				<td><input type="submit" name="Login" value="Log In"> <input
					type="submit" name="Cancel" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>