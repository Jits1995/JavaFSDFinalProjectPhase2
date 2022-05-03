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
<title>Add Teacher Page</title>
</head>
<body>

	<jsp:include page="NavigationBar.jsp"></jsp:include>

	<fieldset>
		<legend>Add Teacher Form : </legend>

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
		<form action="add-teacher" method="post">
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
							<option value=""></option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
					</select></td>
				</tr>
				<tr>
					<td>Address* :</td>
					<td><textarea type="text" name="Address"></textarea></td>
				</tr>
				<tr>
					<td>Mobile No* :</td>
					<td><input type="text" name="MobileNo" /></td>
				</tr>
				<tr>
					<td>Teaching Experience* :</td>
					<td><input type="text" name="Experience" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Add Teacher" />
					</td>
				</tr>
			</table>
		</form>

	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>