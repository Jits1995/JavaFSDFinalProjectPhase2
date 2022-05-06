<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	if (session.getAttribute("username") == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<table border="1" bgcolor="blue" width="100%">
		<tr>
			<td align="center"><h1><font color="white">Learner Academy</font></h1></td>
		</tr>
	</table>

	<table border="1" width="100%" >
		<tr align="center">
			<td><a href="home.jsp">Home</a></td>
			<td><a href="class-Report">Class Report</a></td>
			<td><a href="addStudent.jsp">Add Student</a></td>
			<td><a href="addSubject.jsp">Add Subject</a></td>
			<td><a href="addTeacher.jsp">Add Teacher</a></td>
			<td><a href="addClass.jsp">Add Class</a></td>

			<td><a href="get-Student">View Student</a></td>
			<td><a href="get-Subject">View Subject</a></td>
			<td><a href="get-Teacher">View Teacher</a></td>
			<td><a href="get-Class">View Class</a></td>
			<td><a href="assignSubjectToClasses.jsp">Assign Subject to Class</a></td>
			<td><a href="assignTeacherToClassForSubject.jsp">Assign Teacher to Class</a></td>
		</tr>

	</table>

</body>
</html>