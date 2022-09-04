<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b><%@include file="Header.jsp"%><hr>
		<%@include file="Footer.jsp"%></b>
	<form action="RegistrationCtnl" method="post">
	
<% 
String fname = (String) request.getAttribute("fname");
String lname = (String) request.getAttribute("lname");
String email = (String) request.getAttribute("email");
String pass = (String) request.getAttribute("pwd");
String gendr = (String) request.getAttribute("gender");
String contact = (String) request.getAttribute("contact");
String dob = (String) request.getAttribute("dob");

%>
		<center>
			<h1>Register Here...</h1>
			<table>
				<tr>
					<th>First Name*:</th>
					<td><input type="text" name="fname" value=""></td>
					<td>
					<%
					if(fname != null){
						%>
						<font color = "red">
						<%=fname %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<th>Last Name*:</th>
				<td><input type="text" name="lname" value=""></td>
				<td>
					<%
					if(lname != null){
						%>
						<font color = "red">
						<%=lname %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<tr>
					<th>Email Id*:</th>
					<td><input type="email" name="email" value=""></td>
					<td>
					<%
					if(email != null){
						%>
						<font color = "red">
						<%=email %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<tr>
					<th>Password*:</th>
					<td><input type="password" name="pwd" value=""></td>
					<td>
					<%
					if(pass != null){
						%>
						<font color = "red">
						<%=pass %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<tr>
					<th>Contact*:</th>
					<td><input type="text" name="contact" value=""></td>
					<td>
					<%
					if(contact != null){
						%>
						<font color = "red">
						<%=contact %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<tr>
					<th>Date Of Birth*:</th>
					<td><input type="text" name="date" value=""></td>
					<td>
					<%
					if(dob != null){
						%>
						<font color = "red">
						<%=dob %>
						</font>
						<% 
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
						<td>
					<%
					if(gendr != null){
						%>
						<font color = "red">
						<%=gendr %>
						</font>
						<% 
					}
					%>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="submit" value="submit">
						<input type="submit" name="cancle" value="Cancle"></td>
					<br>
					<td><a href="LoginForm.jsp">Already have an account?
							Please login!</a></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>