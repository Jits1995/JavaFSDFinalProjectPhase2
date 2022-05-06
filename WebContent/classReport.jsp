<%@page import="com.simplilearn.phase2.bean.Student"%>
<%@page import="com.simplilearn.phase2.bean.ClassReport"%>
<%@page import="com.simplilearn.phase2.bean.Classes"%>
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
<title>Class Report</title>
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

	<form action="class-Report" method="post">
		<table align="center">
			<tr>
				<td><label for="name">Select Class : </label></td>
				<td><select name="class">
						<option disabled="disabled" selected="selected">Select
							Class</option>
						<%
							List<Classes> clas = (List) request.getAttribute("classes");

							if (clas != null && clas.size() > 0) {

								for (Classes cls : clas) {
									out.println("<option value='" + cls.getClass_id() + "'>" + cls.getClass_name() + "</option>");
								}
							}
						%>
				</select></td>
				<td><input type="submit" name="submit" value="Generate Report" />
				</td>
			</tr>
		</table>
	</form>

	<table border="1" width="80%" align="center">
		<tr>
			<th>Class Name</th>
			<th>Subject Name</th>
			<th>Teacher Name</th>
			<th>Teacher Gender</th>
			<th>Teacher Experience</th>
		</tr>

		<%
			List<ClassReport> classreport = (List) request.getAttribute("classReport");
		
			if (classreport != null) {

				for (ClassReport cls : classreport) {
					out.print("<tr>");
					out.print("<td>" + cls.getClass_name() + "</td>");
					out.print("<td>" + cls.getSubject_name() + "</td>");
					out.print("<td>" + cls.getFirst_name() + " " + cls.getLast_name() + "</td>");
					out.print("<td>" + cls.getGender() + "</td>");
					out.print("<td>" + cls.getExperience() + "</td>");
					out.print("</tr>");
				}
			} else {
				out.println("<tr><td>No records to display.</td></tr>");
			}
		%>

	</table>
<br>

	<table border="1" width="80%" align="center">
		<tr>
			<th>Student Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>City</th>
			<th>Mobile No</th>
		</tr>

		<%
			List<Student> student = (List) request.getAttribute("studentReport");
			
			if (student != null) {

				for (Student stud : student) {
					out.print("<tr>");
					out.print("<td>" + stud.getFirstName() + " " + stud.getLastName() + "</td>");
					out.print("<td>" + stud.getGender() + "</td>");
					out.print("<td>" + stud.getAddress() + "</td>");
					out.print("<td>" + stud.getCity() + "</td>");
					out.print("<td>" + stud.getMobileNo() + "</td>");
					out.print("</tr>");
				}
			} else {
				out.println("<tr><td>No records to display.</td></tr>");
			}
		%>

	</table>

	<br>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>