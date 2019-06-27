<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add deposit</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	<table class="sub" align="center" border="0">
	
		<tr>
			<td>
			<h1>  Add Deposit </h1>
	<form method="POST" action="DepositServlet">
	
	<table align = "center">
	<tr>
		<td>User ID</td>
		<td><input type="text" name="userID"></td>
	</tr>
	<tr>
		<td>New Amount</td>
		<td><input type="number" name="amount"></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" value="Add"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="Reset"></td>
	</tr>
	
	</table>
	
	
	</form>
	</td>
	</tr>
	</table>
</body>
</html>