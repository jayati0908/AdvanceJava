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
		String name = (String) request.getAttribute("myname");
		String ssn = (String) session.getAttribute("sess");
	

		if (name != null) {
	%>
	<h3>
		Hello,
		<%=name%>
		<%=ssn %>
		</h3>
	<%
		} else {
	%>
	<center>
	<h3>Hii , Guest...</h3>
	</center>
	<%
		}
	%>
	<center>
		<h1>
			<font color="red">Welcome...</font>
		</h1>
	</center>
</body>
</html>