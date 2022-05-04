<%@page import="com.simplilearn.phase2.bean.Teacher"%>
<%@page import="java.util.List"%>
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
<title>View List of Teacher</title>
</head>
<body>

	<jsp:include page="NavigationBar.jsp"></jsp:include>
	<br>

	<div style="color: green;">
		<%
			if (null != request.getAttribute("SuccessMessage")) {
		%>
		<%=request.getAttribute("SuccessMessage").toString()%>
		<%
			}
		%>
	</div>
	<div style="color: red;">
		<%
			if (null != request.getAttribute("ErrorMessage")) {
		%>
		<%=request.getAttribute("ErrorMessage").toString()%>
		<%
			}
		%>
	</div>

	<table border="1" width="80%" align="center">
		<tr>
			<th>Teacher Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Mobile No</th>
			<th>Experience</th>
			<th>Delete</th>
		</tr>

		<%
			List<Teacher> teachers = (List) request.getAttribute("teacher");

			if (teachers.size() > 0 && teachers != null) {

				for (Teacher teacher : teachers) {
					out.print("<tr>");
					out.print("<td>" + teacher.getFirstName() + " " + teacher.getLastName() + "</td>");
					out.print("<td>" + teacher.getGender() + "</td>");
					out.print("<td>" + teacher.getAddress() + "</td>");
					out.print("<td>" + teacher.getMobileNo() + "</td>");
					out.print("<td>" + teacher.getExperience() + " years</td>");
					out.print("<td> <a href='delete-Teacher?teacher_id=" + teacher.getTeacherId() + "'>Delete</a></td>");
					out.print("</tr>");
				}
			} else {
				out.println("No records to display.");
			}
		%>
	</table>
	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>