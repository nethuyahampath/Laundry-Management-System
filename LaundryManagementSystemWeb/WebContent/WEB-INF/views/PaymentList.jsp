<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.model.Payment"%>
<%@page import="com.lms.service.PaymentServiceImpl"%>
<%@page import="com.lms.service.IPaymentService"%>
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
				<h1 data-aos="fade-up" class="title" align="center">Payment
					History</h1>
				<table border="0">
					<tr>
						<th style = "color : #39b54a;">Payment ID</th>
						<th style = "color : #39b54a;">Date</th>
						<th style = "color : #39b54a;">Amount</th>
						<th style = "color : #39b54a;">Order Type</th>
						<th style = "color : #39b54a;">Order ID</th>

					</tr>
					<tr>
						<td colspan = "6" > <hr style = "background-color : white;" ></td>
					</tr>

					<%
						String userID = session.getAttribute("userID").toString();
						IPaymentService iPayService = new PaymentServiceImpl();
						ArrayList<Payment> paymentArrayList = iPayService.getPaymentsByID(userID);

						for (Payment payment : paymentArrayList) {
					%>

					<tr>

						<td  style = "color : white;"><%=payment.getPaymentID()%></td>
						<td style = "color : white;"><%=payment.getPaymentDate()%></td>
						<td style = "color : white;"><%=payment.getAmount()%></td>
						<td style = "color : white;"><%=payment.getOrderType()%></td>
						<td style = "color : white;"><%=payment.getOrderID()%></td>
						<td>
							<form method="POST" action="deletePaymentRecordServlet">

								<input type="hidden" name="paymentID"
									value=<%=payment.getPaymentID()%> /> <input type="submit"
									value="Delete Record" />

							</form>
						</td>
					</tr>
					<%
						}
					%>
				</table>
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