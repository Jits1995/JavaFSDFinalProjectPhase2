<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.simplilearn.phase2.util.DBConnector"%>
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
<title>Assign Subject to Classes</title>
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
		<form action="assign-SubjectToClass" method="post">

			<table>
				<tr>
					<td><label for="name">Select Class : </label></td>
					<td><select name="class">
					<option disabled="disabled" selected="selected">Select Class</option>
							<%
								Connection con = DBConnector.getConnection();
								Statement stmt = con.createStatement();
								
								//executing query
								String sql = "SELECT * FROM classes";
								ResultSet rs = stmt.executeQuery(sql);

								//getting classes name
								while (rs.next()) {
									out.println("<option value='" + rs.getInt("class_id") + "'>" + rs.getString("class_name") + "</option>");
								}
								stmt.close();
								con.close();
							%>
					</select></td>
				</tr>
				<tr>
					<td><label for="name">Select Subject : </label></td>
					<td><select name="subject" multiple>
					<option disabled="disabled">Select Subject</option>
							<%
								Connection con1 = DBConnector.getConnection();
								Statement stmt1 = con1.createStatement();

								//executing query
								String sql1 = "SELECT * FROM subject";
								ResultSet rs1 = stmt1.executeQuery(sql1);

								//getting classes name
								while (rs1.next()) {
									out.println("<option value='" + rs1.getInt("subject_id") + "'>" + rs1.getString("subject_name") + "</option>");
								}
								stmt1.close();
								con1.close();
							%>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Assign Subject to Class" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>