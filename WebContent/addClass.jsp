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
<title>Add Class Page</title>
</head>
<body>


	<jsp:include page="NavigationBar.jsp"></jsp:include>

	<fieldset>
		<legend>Add Class Form : </legend>


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

		<form action="add-class" method="post">

			<table width="30%">
				<tr>
					<td>Enter Class Name* :</td>
					<td><input type="text" name="ClassName" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submit"
						value="Add Class" /></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>