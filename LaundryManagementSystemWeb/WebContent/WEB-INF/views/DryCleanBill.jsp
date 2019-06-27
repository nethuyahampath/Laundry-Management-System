<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.model.DryCleanOrders"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<!-- script
   ================================================== -->
<script src="js/modernizr.js"></script>

<!-- favicons
	================================================== -->
<meta charset="UTF-8">
<title>Wash Fold Form</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/userHeader.jsp"></jsp:include>
	<section id="home" data-parallax="scroll"
		data-image-src="images/hero-bg.jpg" data-natural-width=3000
		data-natural-height=2000>


	<div class="overlay"></div>
	<div class="home-content">

		<div class="row contents">
			<div class="home-content-left">
				<h1 data-aos="fade-up" class="title" align="center">Dry Clean
					Bill</h1>
				<%
					DryCleanOrders dcOrders = (DryCleanOrders) request.getAttribute("dcOrder");
				%>

				<form method = "POST" action = "AddPaymentServlet">
				<table border="0"  align="center" cellpadding="13">

					<%
						IOrdersService iOrders1 = new OrdersServiceImpl();
						ArrayList<DryCleanOrders> arrayList1 = iOrders1.MyDryCleanList(dcOrders.getOrderID());

						for (DryCleanOrders dcOrder : arrayList1) {
					%>
					<tr>
						<td class="caption" width="600">
							<%=dcOrder.getItem()%>
						</td >
						<td  class="caption" style = "font-size: 18px;">1 X <%=dcOrder.getQuantity()%>
						</td >
						<td  class="caption"
							style="color: white; font-weight: bold; font-size: 18px;"><%=dcOrder.getPrice()%>
						</td>
					</tr>

					<%
						}
					%>
					<tr>
						<td colspan="3">
							<hr>
						</td>
					</tr>
					<tr>
						<td class="title"
							style="color: red; text-indent: 5px; text-indent: 90px; font-size: 25px;">Total</td>
						<td class="caption"
							style="color: red; text-indent: 5px; font-size: 25px;">Rs:</td>
						<td class="caption"
							style="color: red; font-size: 25px; font-weight: bold;"><%=dcOrders.getTotal()%></td>
					</tr>
					<tr>
						<td> </td>
						<td> </td>
						<td><input type="hidden" name="orderID"
							value="<%=dcOrders.getOrderID()%>">
						<input type="hidden" name="amount"
							value="<%=dcOrders.getTotal()%>">
						<input type="hidden" name="userID"
							value="${sessionScope.userID }">
						<input type="hidden" value="Dry-Clean" name="orderType">
						
						<input type="submit" value="Proceed to Checkout" style="color: white; background-color: #39b54a; width: 200px; border-style: none;">
						</td>
					</tr>
				</table>
				</form>
			</div>

		</div>

	</div>

	<!-- end home-content --> </section>
	<!-- end home -->


	<!-- about
    ================================================== -->
	<section id="about">

	<div class="row about-intro">

		<div class="col-four">
			<h1 class="intro-header" data-aos="fade-up">About Our App</h1>
		</div>
		<div class="col-eight">
			<p class="lead" data-aos="fade-up">Excepteur enim magna veniam
				labore veniam sint. Ex aliqua esse proident ullamco voluptate. Nisi
				nisi nisi aliqua eiusmod dolor dolor proident deserunt occaecat elit
				Lorem reprehenderit. Id culpa veniam ex aliqua magna elit pariatur
				do nulla. Excepteur enim magna veniam labore veniam sint.</p>
		</div>

	</div>

	</section>

	<jsp:include page="/footer.jsp"></jsp:include>
	<!-- end footer-main -->


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