<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.simplilearn.phase2.util.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
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
<title>Add Student Page</title>
</head>
<body>


	<jsp:include page="NavigationBar.jsp"></jsp:include>
	<fieldset>
		<legend>Add Student Form</legend>

		<form action="add-student" method="post">

			<div style="color: red;">
				<%
					if (null != request.getAttribute("ErrorMessage")) {
				%>
				<%=request.getAttribute("ErrorMessage").toString()%>
				<%
					}
				%>
			</div>
			<div style="color: green;">
				<%
					if (null != request.getAttribute("SuccessMessage")) {
				%>
				<%=request.getAttribute("SuccessMessage").toString()%>
				<%
					}
				%>
			</div>
			<table>
				<tr>
					<td>Enter First Name* :</td>
					<td><input type="text" name="FirstName" /></td>
				</tr>
				<tr>
					<td>Enter Last Name* :</td>
					<td><input type="text" name="LastName" /></td>
				</tr>
				<tr>
					<td><label for="name">Select Gender* : </label></td>
					<td><select name="Gender_Type">
							<option value="">Select Gender</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
					</select></td>
				</tr>
				<tr>
					<td>Enter Address* :</td>
					<td><textarea rows="6" cols="20" name="Address"></textarea></td>
				</tr>
				<tr>
					<td>Enter City* :</td>
					<td><input type="text" name="City" /></td>
				</tr>
				<tr>
					<td>Enter Mobile No*:</td>
					<td><input type="text" name="MobileNo" /></td>
				</tr>
				<tr>
					<td><label for="name">Select Class* : </label></td>
					<td><select name="StudentClass">
							<option value="">Select Class</option>
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
					<td><input type="submit" name="submit" value="Add Student" />
					</td>
				</tr>
			</table>
		</form>

	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>