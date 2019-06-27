<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.service.RatesServiceImpl"%>
<%@page import="com.lms.service.IRatesService"%>
<%@page import="com.lms.model.WashFoldOrders"%>
<%@page import="com.lms.model.WashFoldRates"%>
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
<script>
function washFoldValidate(){
	
	
	var pDay = document.forms["WashFoldForm"]["pickDate"].value;
	var orderPackage = document.forms["WashFoldForm"]["package"].value;
	
	if( orderPackage == "Please Select"){
		alert("Please Select a package option ");
		return false;
		
	}
	
	if( pDay == "" || pDay == null ){
		alert("Please enter a pick date ");
		return false;
	}
}
</script>


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
				<h1 data-aos="fade-up" class="title" align="center">Update Wash
					Fold Order</h1>
				
	<%
		WashFoldOrders wfOrders = (WashFoldOrders) request.getAttribute("wfOrder");
		IOrdersService iOrder = new OrdersServiceImpl();

		String orderID = wfOrders.getOrderID();

		WashFoldOrders o = new WashFoldOrders();

		o = iOrder.MyWashFoldList(orderID);
	%>

	<form method="POST" action="UpdateWashFoldOrderServlet" name="WashFoldForm"
					onsubmit="return washFoldValidate()">
		<table border="0">
			<tr>
				<td class="caption" width="600">Package :</td>
				<td>
				<select name="package" style="color: black; background-color: white; opacity: 0.7; width: 600px; font-size: 25px; text-indent: 10px;">
						<option value="<%=o.getRateID()%>">
							<%=o.getOrderPackage()%>
						</option>
						<%
							IRatesService iRateService = new RatesServiceImpl();
							ArrayList<WashFoldRates> washFoldArrayList = iRateService.getWashFoldRates();
							for (WashFoldRates rate : washFoldArrayList) {
																
								out.write("<option type = 'text' value = '" + rate.getRateID() + "'>");
								out.write(rate.getRatePackage());
								out.write(rate.getRateID() );
								out.write("</option>");
							}
						%>

				</select>
				</td>
			</tr>
			<tr>
				<td class="caption" width="600">Pick Up Date :</td>
				<td>
					<input type="date" value="<%=wfOrders.getOrderPickDate()%>" name="pickDate" style="color: black; background-color: white; opacity: 0.7; width: 600px; font-size: 25px; text-indent: 10px;"> 
				</td>
			</tr>
			<tr>
				<td><input type="hidden" value="<%= wfOrders.getOrderID() %>" name="orderID"  ></td>
				<td><input type="submit" value="Update Order" style="color: white; background-color: #39b54a; width: 200px; border-style: none;"></td>
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