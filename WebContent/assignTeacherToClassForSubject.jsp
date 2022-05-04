<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.simplilearn.phase2.util.DBConnector"%>
<%@page import="java.sql.Connection"%>
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
<title>Assign Teacher to Class</title>
</head>
<body>

	<jsp:include page="NavigationBar.jsp"></jsp:include>

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
	<fieldset>
		<legend>Assign Subject to Classes</legend>
		<form action="assign-TeacherToClassSubject" method="post">

			<table>
				<tr>
					<td><label for="name">Select Teacher : </label></td>
					<td><select name="teacher">
							<option disabled="disabled" selected="selected">Select Teacher</option>
							<%
								Connection con = DBConnector.getConnection();
								Statement stmt = con.createStatement();

								//executing query
								String sql = "SELECT * FROM teacher_details";
								ResultSet rs = stmt.executeQuery(sql);

								//getting classes name
								while (rs.next()) {
									out.println("<option value='" + rs.getInt("teacher_id") + "'>" + rs.getString("first_name") + " " + rs.getString("last_name")
											+ "</option>");
								}
								stmt.close();
								con.close();
							%>
					</select></td>
				</tr>
				<tr>
					<td><label for="name">Select Class : </label></td>
					<td><select name="classSubject">
							<option disabled="disabled" selected="selected">Select
								Class Subject</option>
							<%
								Connection con1 = DBConnector.getConnection();
								Statement stmt1 = con1.createStatement();

								//executing query
								String sql1 = "select cs.class_subject_id, c.class_name, s.subject_name from class_subject_teacher_link cs INNER JOIN classes c ON c.class_id = cs.class_id	INNER JOIN subject s ON s.subject_id = cs.subject_id";
								ResultSet rs1 = stmt1.executeQuery(sql1);

								//getting classes name
								while (rs1.next()) {
									out.println(
											"<option value='" + rs1.getInt("class_subject_id") + "'>" + rs1.getString("class_name") + " : " + rs1.getString("subject_name") + "</option>");
								}
								stmt1.close();
								con1.close();
							%>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Assign Teacher to Class" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>