<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "StudentController" method = "post">
<center>
<h1>Student Marksheet...</h1>
			<table>
				<tr>
					<th>Roll_No*:</th>
					<td><input type="text" name="roll" value=""></td>
				</tr>
				<tr>
					<th>First Name*:</th>
					<td><input type="text" name="fname" value=""></td>
				</tr>
				<tr>
					<th>Last Name*:</th>
					<td><input type="text" name="lname" value=""></td>
				</tr>
				<tr>
					<th>Physics*:</th>
					<td><input type="text" name="physics" value=""></td>
				</tr>
				<tr>
					<th>Chemistry*:</th>
					<td><input type="text" name="chemistry" value=""></td>
				</tr>
				<tr>
					<th>Mathematics*:</th>
					<td><input type="text" name="mathematics" value=""></td>
				</tr>
				<tr>
					<th>Session*:</th>
					<td><input type="text" name="session" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Add">
						<input type="submit" name="operation" value="Modify"> <input
						type="submit" name="operation" value="Delete">
				</tr>
				<tr>
				<th></th>
				<td><b><a href = "Search.jsp">Click here to search record...</a></b></td>
				</tr>
			</table>
</center>
</form>
</body>
</html>