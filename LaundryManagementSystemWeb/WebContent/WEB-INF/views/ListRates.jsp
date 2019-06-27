<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IRatesService"%>
<%@page import="com.lms.service.RatesServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.model.WashFoldRates"%>
<%@page import="com.lms.service.RatesServiceImpl"%>
<%@page import="com.lms.model.DryCleanRates"%>

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
				<h1 data-aos="fade-up" class="title" align="center">Rates</h1>
				<%
					String searchType = (String) request.getAttribute("search");

					if (searchType.compareTo("Wash-Fold-Rates") == 0) {
				%>

				<h2 class = "caption">Wash Fold Rates</h2>
				<table border="0">

					<tr>
						<td style = "color : red;">Package</td>
						<td style = "color : red;">Small Price</td>
						<td style = "color : red;">Medium Price</td>
						<td style = "color : red;">Large Price</td>

					</tr>


					<%
						IRatesService iRatesService = new RatesServiceImpl();
							ArrayList<WashFoldRates> arrayList = iRatesService.getWashFoldRates();

							for (WashFoldRates wfR : arrayList) {
					%>


					<tr>
						<td style = "color : white;"><%=wfR.getRatePackage()%></td>
						<td style = "color : white;"><%=wfR.getSmallWeightPrice()%></td>
						<td style = "color : white;"><%=wfR.getMediumWeightPrice()%></td>
						<td style = "color : white;"><%=wfR.getLargeWeightPrice()%></td>

					</tr>
					<%
						}
					%>
				</table>

				<%
					} else if (searchType.compareTo("Dry-Clean-Rates") == 0) {
				%>

				<h2 class = "caption">DRY CLEAN RATES</h2>

				<table border="0">
					<tr>
						<td class = "caption" style = "color : red">Item</td>

						<td class = "caption"  style = "color : red">Price Per Unit</td>
					</tr>


					<%
						IRatesService iDryRatesService = new RatesServiceImpl();
							ArrayList<DryCleanRates> dryArrayList = iDryRatesService.getDryCleanRates();

							for (DryCleanRates dcR : dryArrayList) {
					%>

					<tr>
						<td class = "caption"><%=dcR.getRateItem()%></td>
						<td class = "caption"><%=dcR.getPricePerUnit()%></td>

					</tr>
					<%
						}
					%>
				</table>
				<%
					}
				%>
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
