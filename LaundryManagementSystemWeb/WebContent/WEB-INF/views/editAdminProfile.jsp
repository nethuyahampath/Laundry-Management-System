<%@page import="com.lms.model.User"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Laundry User Management</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>


	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	
	<table border = "0" class  = "sub" align = "center" >
	<tr> <td>
	<h2>Edit Admin Page</h2>

	<%
	
		User user = (User) request.getAttribute("user");
		
	
	%>
	<form method="POST" action="userUpdateServlet">
		<table align =  "center">
			<tr>
				<td>userID</td>
				<td><input type="text" name="userID" disabled="disabled"
					value="<%=user.getUserID()%>" /></td>
			</tr>
			<tr>
				<td>firstName</td>
				<td><input type="text" name="firstName"
					value="<%=user.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>lastName</td>
				<td><input type="text" name="lastName"
					value="<%=user.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password"
					value="<%=user.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>no</td>
				<td><input type="text" name="no"
					value="<%=user.getNo()%>" /></td>
			</tr>
			<tr>
				<td>street</td>
				<td><input type="text" name="street"
					value="<%=user.getStreet()%>" /></td>
			</tr>
			<tr>
				<td>city</td>
				<td><input type="text" name="city"
					value="<%=user.getCity()%>" /></td>
			</tr>
			<tr>
				<td>contact</td>
				<td><input type="text" name="contact"
					value="<%=user.getContact()%>" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email"
					value="<%=user.getEmail()%>" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" name="type" value="Admin"></td>
			</tr>
			
			
			<tr>
				<td colspan="2"><input type="hidden" name="userID" value="<%=user.getUserID()%>" /> 
				<input type="submit" value="Update Details" /></td>
			</tr>
		</table>
	</form>
	</td></tr>
	</table>
	
	
	
	
</body>
</html>