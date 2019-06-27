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
<script>
function dryCleanValidate(){

	
	var qtyLen  = document.forms["DryCleanForm"]["quantity"].length;
	var pDay = document.forms["DryCleanForm"]["pickDate"].value;

	var q  =  new Array();
	
	var i = 0;

	for( i = 0; i < qtyLen; ++i ){
		q = document.getElementsByName("quantity")[i].value;
		if( q < 0 ){
			alert("You cannot enter negative values");
			return false;
		}
		else{
			isNumeric( q )
		}
	}//end for
	
	if( pDay == "" || pDay == null ){
		alert("Please enter a pick date ");
		return false;
	}
	

}


function isEmpty( elemValue , field ){
	
	if( elemValue == "" || elemValue == null ){
		alert( "You cannot have  the " + field + " empty");
		return true;
	}else{
		return false;
	}
}

function isNumeric( elemValue ){
	var exp = /^[0-9]+$/;
	
	if( !isEmpty( elemValue , "Quantity")){
		
		if( elemValue.match(exp) ){
			return true;
		}
		else{
			alert("Enter only Numbers  to the fieild");
			return false;
		}
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
				<h1 data-aos="fade-up" class="title" align="center">Update Dry Clean Order</h1>
				<%
					DryCleanOrders dcOrders = (DryCleanOrders) request.getAttribute("dcOrder");
				%>
				<form method="POST" action="UpdateDryCleanOrderServlet" name="DryCleanForm" onsubmit="return dryCleanValidate()">
					<table border="0">
						<%
							String date = "";
							IOrdersService iOrders1 = new OrdersServiceImpl();
							ArrayList<DryCleanOrders> arrayList1 = iOrders1.MyDryCleanList(dcOrders.getOrderID());

							for (DryCleanOrders dcOrder : arrayList1) {
								
								out.write("<input type = 'hidden' name = 'rateID' value = '" + dcOrder.getRateID() + "' >");
						%>
						<tr>
							<td class="caption" width="600"><%=dcOrder.getItem()%></td>

							<td><input type="number" value="<%=dcOrder.getQuantity()%>"
								name="quantity" style="color: black; background-color: white; opacity: 0.7; width: 600px; font-size: 25px; text-indent: 10px;"></td>

						</tr>

						<%
							}

							date = iOrders1.getPickDateByID(dcOrders.getOrderID());
						%>
						<tr>
							<td class="caption" width="600">Pick Date</td>
							<td><input type="date" value="<%=date%>" name="pickDate"  style="color: black; background-color: white; opacity: 0.7; width: 600px; font-size: 25px; text-indent: 10px;"></td>
						</tr>
						<tr>
							<td><input type="hidden"
								value="<%=dcOrders.getOrderID()%>" name="orderID"  ></td>

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