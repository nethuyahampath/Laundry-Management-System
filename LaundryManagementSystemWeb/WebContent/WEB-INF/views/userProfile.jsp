<%@page import="com.lms.model.User"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>



	<h2>User Profile Page</h2>

	
	<br>
	<br>
	<% User user = (User) request.getAttribute("user");  %>
	
	
	<!--% String username = session.getAttribute("userfname").toString();
	System.out.println(username);
	%-->
	
	<h4>You are logged in as :  ${sessionScope.userID }</h4>
	
	<input type = "text" value = "${sessionScope.userID }" >
	
		<form method = "POST" action = "RedirectServlet">
			<input  type = "submit" value = "Home" name = "button" >
		</form>
		
		<form method = "POST" action = "RedirectServlet">
			<input  type = "submit" value = "Rates List" name = "button" >
		</form>
	
		<form method="POST" action="getMyAccountServlet">
			<input type="hidden" name="userID" value="<%=user.getUserID()%>"/>
			<input type="submit" value= "Edit Profile"  /> 
		</form>
		
		
		<form method="POST" action="RedirectServlet">
			<input type="hidden" name="userID" value="<%=user.getUserID()%>"/>
			<input type="submit" value= "Record History"  name = "button"/> 
		</form>	
		
		
	
	<a href="LoginUserServlet">Logout</a>
	
	
	
	
</body>
</html>