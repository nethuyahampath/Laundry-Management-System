<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.model.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.util.Generator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
   ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
   ================================================== -->
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/vendor.css">
<link rel="stylesheet" href="css/main2.css">
<link rel="stylesheet" href="css/back2.css">
<link rel="stylesheet" href="css/style.css">

<!-- script
   ================================================== -->
<script src="js/modernizr.js"></script>

<!-- favicons
	================================================== -->

<meta charset="UTF-8">
<title>Wash Fold Form</title>
</head>
</head>
<body>
	<jsp:include page="/WEB-INF/views/userHeader.jsp"></jsp:include>
	<section id="home" data-parallax="scroll"
		data-image-src="images/hero-bg.jpg" data-natural-width=3000
		data-natural-height=2000>
	<table border="0" style="position: absolute; top: 135px;">
		<tr>
			<td>
				<%
					//get the current date
					String currentDate = Generator.getCurrentDate();
				%>

				<div class="mainDiv">
						<div class="leftDiv">

							<h1 align="center" class="header">Wash Fold Orders</h1>
							<%
								String userID = session.getAttribute("userID").toString();

								IOrdersService iOrders1 = new OrdersServiceImpl();
								ArrayList<Orders> arrayList1 = iOrders1.getWashFoldOrders(userID);

								for (Orders o : arrayList1) {
							%>
							<br>
							<table border="0" class="leftTable" align="center"
								cellpadding="8">

								<tr>
									<td class="title" align = "center">Order ID</td>
									<td class="des"><%=o.getOrderID()%></td>

									<td >
										<form method="POST" action="WashFoldBillServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="View Bill" >
										</form>
									</td>

								</tr>
								<tr>
									<td class="title">Order Placed Date</td>
									<td class="des"><%=o.getOrderDropDate()%></td>
									<%
										String status1 = o.getOrderStatus();
											String status2 = "Pending";

											if (status1.compareTo(status2) == 0) {
									%>
									<td class="title">
										<form method="POST" action="ToUpdateWFServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="Update Order">
										</form>
									</td>
									<%
										}
									%>
								</tr>
								<tr>

									<td class="title">Order Pick Up Date</td>
									<td class="des"><%=o.getOrderPickDate()%></td>
									<%
										if (status1.compareTo(status2) == 0) {
									%>
									<td>
										<form method="POST" action="DeleteWFServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="Delete Order">
										</form>
									</td>
									<%
										}
									%>
								</tr>
								<tr>
									<td class="title">Track Order Status</td>
									<td class="des"><%=o.getOrderStatus()%></td>
								</tr>
								<tr>
									<td colspan="3" style="background-color: red; color: white;">
										<%=iOrders1.getOrderDeadLineMessage(o.getOrderPickDate(), currentDate)%>
									</td>
								</tr>
							</table>
							<hr style = "background-color : white">
							<%
								}
							%>
							
						</div>

						<div class="rightDiv">
							<h1 align="center" class="header">Dry Clean Orders</h1>
							<%
								IOrdersService iOrders2 = new OrdersServiceImpl();
								ArrayList<Orders> arrayList2 = iOrders2.getDryCleanOrders(userID);

								for (Orders o : arrayList2) {
							%>
							<br>
							<table border="0" cellpadding="8" class="rightTable"
								align="center">

								<tr>
									<td class="title">Order ID</td>
									<td class="des"><%=o.getOrderID()%></td>

									<td>
										<form method="POST" action="DryCleanBillServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="View Bill">
										</form>
									</td>

								</tr>
								<tr>
									<td class="title">Order Placed Date</td>
									<td class="des"><%=o.getOrderDropDate()%></td>
									<%
										String status1 = o.getOrderStatus();
											String status2 = "Pending";

											if (status1.compareTo(status2) == 0) {
									%>
									<td>
										<form method="POST" action="ToUpdateDCServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="Update Order">
										</form>
									</td>
									<%
										}
									%>
								</tr>
								<tr>

									<td class="title">Order Pick Up Date</td>
									<td class="des"><%=o.getOrderPickDate()%></td>
									<%
										if (status1.compareTo(status2) == 0) {
									%>
									<td>
										<form method="POST" action="DeleteDCServlet">
											<input type="hidden" value="<%=o.getOrderID()%>"
												name="orderID"> <input type="submit"
												value="Delete Order" >
										</form>
									</td>
									<%
										}
									%>
								</tr>
								<tr>
									<td class="title">Track Order Status</td>
									<td class="des"><%=o.getOrderStatus()%></td>
								</tr>
								<tr>
									<td colspan="3" style="background-color: red; color: white;">
										<%=iOrders2.getOrderDeadLineMessage(o.getOrderPickDate(), currentDate)%>
									</td>
								</tr>
							</table>
							<hr style = "background-color : white">
							<%
								}
							%>
						</div>

					</div>
			</td>
		</tr>
	</table>
	</section>
	<div id="preloader">
		<div id="loader"></div>
	</div>

	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-2.1.3.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>
</html>