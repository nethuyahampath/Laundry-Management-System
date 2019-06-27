<%@page import="com.lms.model.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					Validation</h1>

				<table border = "0" align = "center">
				<tr>
				<td align = "center">
				<%
					Payment pay = (Payment) request.getAttribute("pay");
					Double result = (Double) request.getAttribute("result");
					Double depositAmount = (Double) request.getAttribute("depositAmount");
				%>

				<br> <br>

				<%
					if (result == null || result == 0) {
				%>
				<h4 align = "center" class="caption" style = "color : red">Insufficient Funds</h4>
				<h5 align = "center" class="caption">
					Deposit Balance :
					<%=depositAmount%></h5>
				<h4 align = "center" class="caption">Please Make a New Deposit !</h4>
				<%
					} else {
				%>
				<table>
					<tr>
						<td align = "center" class="caption">Previous Balance :</td>
						<td align = "center" class="caption"><%=depositAmount%></td>
					</tr>
					<tr>
						<td align = "center" class="caption">Order Price :</td>
						<td align = "center" class="caption"><%=pay.getAmount()%></td>
					</tr>
					<tr>
						<td align = "center" class="caption">Available Balance :</td>
						<td align = "center" class="caption" style = "color : red"><%=result%></td>
					</tr>
				</table>
				<%
					}
				%>
				</td>
				</tr>
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