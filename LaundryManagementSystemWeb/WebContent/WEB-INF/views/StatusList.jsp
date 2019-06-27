<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.model.WashFoldOrders"%>
<%@page import="com.lms.model.DryCleanOrders"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Status</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	<table class="sub" align="center" border = "0">
		<tr><td colspan = "2">
				<h1> Incomplete Order Status</h1>
			</td>
		</tr>
		<tr>
			<td>
			<input type="hidden" value="${sessionScope.userID }">
			
				<h2>Wash Fold Status</h2>

				<table border="1" align = "center">

					<tr>
						<th>Order ID</th>
						<th>Status</th>

					</tr>

					<%
						IOrdersService iOrdersService1 = new OrdersServiceImpl();
						ArrayList<WashFoldOrders> WFOrdersArrayList = iOrdersService1.getWashFoldOrdersStatusList();

						for (WashFoldOrders orders : WFOrdersArrayList) {

							String status1 = orders.getOrderStatus();

							if (status1.compareTo("Completed") != 0) {
					%>

					<form method="POST" action="updateWashFoldStatusServlet">

						<tr>
							<td><%=orders.getOrderID()%></td>
							<td><select name="status">
									<option value="<%=orders.getOrderStatus()%>">
										<%=orders.getOrderStatus()%>
									</option>
									<option value="Washing">Washing</option>
									<option value="Folding">Folding</option>
									<option value="Completed">Completed</option>
							</select></td>
							<td><input type="hidden" name="orderID"
								value="<%=orders.getOrderID()%>"> <input type="submit"
								value="Update"></td>
						</tr>
					</form>
					<%
						} //end if
						} //end while
					%>

				</table>
			</td>
			<td>
				<h2>Dry Clean Status</h2>

				<table border="1" align = "center">

					<tr>
						<th>Order ID</th>
						<th>Status</th>

					</tr>
					<%
						IOrdersService iOrdersService2 = new OrdersServiceImpl();
						ArrayList<DryCleanOrders> DCOrdersArrayList = iOrdersService2.getDryCleanOrdersStatusList();

						for (DryCleanOrders orders : DCOrdersArrayList) {

							String status2 = orders.getOrderStatus();

							if (status2.compareTo("Completed") != 0) {
					%>


					<form method="POST" action="updateDryCleanStatusServlet">

						<tr>
							<td><%=orders.getOrderID()%></td>
							<td><select name="status">
									<option value="<%=orders.getOrderStatus()%>">
										<%=orders.getOrderStatus()%>
									</option>
									<option value="Drying">Drying</option>
									<option value="Cleaning">Cleaning</option>
									<option value="Completed">Completed</option>
							</select></td>
							<td><input type="hidden" name="orderID"
								value="<%=orders.getOrderID()%>"> <input type="submit"
								value="Update"></td>
						</tr>
					</form>

					<%
						} //end if
						} //end while
					%>

				</table>
			</td>
		</tr>
	</table>
</body>
</html>
