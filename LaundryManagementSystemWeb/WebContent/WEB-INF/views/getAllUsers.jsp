<%@page import="com.lms.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List of Laundry</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>

	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>

	<table class="sub" align="center">
		<tr>
			<td>
				<h3>List of Users</h3> <br> <br>
				<div align="left">
					<table border="1" cellpadding="12" align = "center">
					
						<tr>
							<th>userID</th>
							<th>firstName</th>
							<th>lastName</th>
							<th>password</th>
							<th>no</th>
							<th>street</th>
							<th>city</th>
							<th>contact</th>
							<th>email</th>
							<th>type</th>

						</tr>




						<%
							IUserService iUserService = new UserServiceImpl();
							ArrayList<User> arrayList = iUserService.getUsers();

							for (User user : arrayList) {
						%>
						<tr>
							<td><%=user.getUserID()%></td>
							<td><%=user.getFirstName()%></td>
							<td><%=user.getLastName()%></td>
							<td><%=user.getPassword()%></td>
							<td><%=user.getNo()%></td>
							<td><%=user.getStreet()%></td>
							<td><%=user.getCity()%></td>
							<td><%=user.getContact()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getType()%></td>



							<td>
								<form method="POST" action="getTheUserServlet">
									<input type="hidden" name="userID"
										value="<%=user.getUserID()%>" /> <input type="submit"
										value="Select User" />
								</form>
							</td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</td>
		</tr>
	</table>






</body>
</html>