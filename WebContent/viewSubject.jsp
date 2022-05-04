<%@page import="com.simplilearn.phase2.bean.Subject"%>
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
<title>View List of Subject</title>
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

	<table border="1" width="20%" align="center">
		<tr>
			<th>Subject</th>
			<th>Delete</th>
		</tr>

		<%
			List<Subject> subject = (List) request.getAttribute("subject");

			if (subject.size() > 0 && subject != null) {

				for (Subject sub : subject) {
					out.print("<tr>");
					out.print("<td>" + sub.getSubjectName() + "</td>");
					out.print("<td> <a href='delete-Subject?subject_id=" + sub.getSubjectId() + "'>Delete</a></td>");
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