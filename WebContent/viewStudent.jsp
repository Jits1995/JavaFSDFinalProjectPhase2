<%@page import="java.util.List"%>
<%@page import="com.simplilearn.phase2.bean.Student"%>
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
<title>View List of Student</title>
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
			<th>Student Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>City</th>
			<th>Mobile No</th>
			<th>Class</th>
			<th>Delete</th>
		</tr>

		<%
			List<Student> student = (List) request.getAttribute("student");

			if (student.size() > 0 && student != null) {

				for (Student stud : student) {
					out.print("<tr>");
					out.print("<td>" + stud.getFirstName() + " " + stud.getLastName() + "</td>");
					out.print("<td>" + stud.getGender() + "</td>");
					out.print("<td>" + stud.getAddress() + "</td>");
					out.print("<td>" + stud.getCity() + "</td>");
					out.print("<td>" + stud.getMobileNo() + "</td>");
					out.print("<td>" + stud.getClassName() + "</td>");
					out.print("<td> <a href='delete-Student?student_id=" + stud.getStudentId() + "'>Delete</a></td>");
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