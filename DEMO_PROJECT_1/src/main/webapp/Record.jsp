<%@page import="com.raysetch.bean.Student_MarksheetBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<center>
			<table>
				<tr>
					<th>Std_Id</th>
					<th>Roll_No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Physics</th>
					<th>Chemistry</th>
					<th>Mathematics</th>
					<th>Session</th>
				</tr>
				<%
					ArrayList list = (ArrayList) request.getAttribute("get");
					Iterator<Student_MarksheetBean> it = list.iterator();
					while (it.hasNext()) {
						Student_MarksheetBean bean = it.next();
				%>
				<tr>
					<td><%=bean.getId()%></td>
					<td><%=bean.getRollNo()%></td>
					<td><%=bean.getfName()%></td>
					<td><%=bean.getlName()%></td>
					<td><%=bean.getPhysics()%></td>
					<td><%=bean.getChemistry()%></td>
					<td><%=bean.getMaths()%></td>
					<td><%=bean.getSession()%></td>
					<%
						}
					%>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>