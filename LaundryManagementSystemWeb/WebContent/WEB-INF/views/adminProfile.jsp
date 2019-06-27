<%@page import="com.lms.model.User"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Profile</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>

	<table border = "0" class  = "sub" align = "center" >
	<tr>
	<td>
		<h1 align = "center"> Admin View </h1>
			
	</td>
	</tr>
	</table>
</body>
</html>