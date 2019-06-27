<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Admin</title>
</head>
<body>
	<h2>Add Admin</h2>
	<br>
	
	<form method="POST" action="addUserServlet">
	
	<table>
	
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName"></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>No</td>
		<td><input type="text" name="no"></td>
	</tr>
	<tr>
		<td>Street</td>
		<td><input type="text" name="street"></td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type="text" name="city"></td>
	</tr>
	<tr>
		<td>Contact</td>
		<td><input type="text" name="contact"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="hidden" name="type" value="Admin"></td>
	</tr>
	
			
			
			
			
	
	
	<tr>
		<td></td>
		<td><input type="submit" value="Add Admin"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="reset" value="Reset"></td>
	</tr>
	
	</table>
	
	
	</form>

</body>
</html>