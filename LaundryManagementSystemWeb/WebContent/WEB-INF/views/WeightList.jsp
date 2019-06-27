<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.model.WashFoldOrders"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weight Status</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	
	<table class="sub" align="center" border="0">
		<tr>
			<td>
				<h1> Update Weight </h1>
			<input type="hidden" value="${sessionScope.userID }">

				<table border="1" align = "center">

					<%
						IOrdersService iOrdersService = new OrdersServiceImpl();
						ArrayList<WashFoldOrders> WFOrdersArrayList = iOrdersService.getWashFoldWeight();

						for (WashFoldOrders orders : WFOrdersArrayList) {

							if (orders.getWeight() == 0) {
					%>

					<form method="POST" action="updateWeightServlet">

						<tr>
							<td><%=orders.getOrderID()%></td>
							<td><input type="text" name="weight"
								value="<%=orders.getWeight()%>"></td>
							<td><input type="hidden" name="orderID"
								value="<%=orders.getOrderID()%>"></td>

							<td><input type="submit" value="updateWeight"></td>
						</tr>
					</form>
					<%
						} //end if
						} //end while
					%>

				</table></td>
		</tr>
	</table>
</body>
</html>
