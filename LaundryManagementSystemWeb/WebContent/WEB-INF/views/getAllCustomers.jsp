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
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>

	<table class="sub" align="center">
		<tr>
			<td>
				<h3>List of Customers</h3> <br> <br>
				<div align="left">
					<table border="1" cellpadding="12" align = "center">
					
						<tr>
							<th>userID</th>
							<th>firstName</th>
							<th>lastName</th>
							<th>no</th>
							<th>street</th>
							<th>city</th>
							<th>contact</th>
							<th>email</th>
							

						</tr>




						<%
							IUserService iUserService = new UserServiceImpl();
							ArrayList<User> arrayList = iUserService.getCustomers();

							for (User user : arrayList) {
						%>
						<tr>
							<td><%=user.getUserID()%></td>
							<td><%=user.getFirstName()%></td>
							<td><%=user.getLastName()%></td>
							<td><%=user.getNo()%></td>
							<td><%=user.getStreet()%></td>
							<td><%=user.getCity()%></td>
							<td><%=user.getContact()%></td>
							<td><%=user.getEmail()%></td>
							



							
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