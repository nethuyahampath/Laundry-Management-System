<%@page import="com.lms.model.User"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	
	<input type = "hidden" value = " ${sessionScope.userID }" >
	<div class = "main" >
	
	<h3  style = "background-color : black;  color : white; ">Logged in as Admin : ${sessionScope.userfname }</h3>
	<a href="LogoutUserServlet"
		class="button button-primary cta" style = "background-color : red; border-style:none;font-size:20px; margin-left: 90%;">Log Out
	</a>
	<table border = "0" align = "center" width = "100%">
		<tr style = "background-color : black;">
			<td>
				<font style = "color : white;"> User Management : </font>
			</td>
			<td align = "center">
				<form method="POST" action="getAdminAccountServlet">
					<input type="hidden" name="userID" value="${sessionScope.userID }"/>
					<input type="submit" value= "Edit Profile"  />
				</form>
			</td>
			<td  align = "center">
				<form method="POST" action="RedirectServlet">
					<input type="submit" value="Display All Users" name =  "button">
				</form>
			</td>
			
			
			
			
			<td>
			
			</td>
			<td>
			
			</td>
	
		</tr>
		<tr  style = "background-color : black;">
			<td>
				<font style = "color : white;"> Product Management :   </font>
			</td>
			<td align = "center">
				<form method="POST" action="RedirectServlet">
					<input type="submit" value="Admin Rates" name = "button">
				</form>
			</td>
		
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Add Rates" name = "button">
				</form>
			</td >
			
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Orders Status" name = "button">
				</form>
			</td>
			
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Update Weight" name = "button">
				</form>
			</td>
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Add Deposit" name = "button">
				</form>
			</td>
		</tr>
		<tr style = "background-color : black;">
			<td>
				<font style = "color : white;"> Get Reports :   </font>
			</td>
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Order Report" name = "button">
				</form>
			</td>
			<td align = "center">
				<form method = "POST" action = "RedirectServlet">
					<input type = "submit" value = "Customer Report" name = "button">
				</form>
			</td>
			
		</tr>
	</table>
	</div>

</body>
</html>