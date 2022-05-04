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
<title>View List of Classes</title>
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

	<table border="1" align="center">
		<tr>
			<th>Class Name</th>
			<th>Delete</th>
		</tr>

		<%
			List<Classes> clas = (List) request.getAttribute("classes");

			if (clas.size() > 0 && clas != null) {

				for (Classes cls : clas) {
					out.print("<tr>");
					out.print("<td>" + cls.getClass_name() + "</td>");
					out.print("<td>" + "<a href='delete-Classes?class_id=" + cls.getClass_id() + "'>Delete</a></td>");
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