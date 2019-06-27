<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.model.WashFoldRates"%>
<%@page import="com.lms.model.DryCleanRates"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.service.RatesServiceImpl"%>
<%@page import="com.lms.util.Generator"%>
<%@page import="com.lms.service.IRatesService"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--- basic page needs
   ================================================== -->
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
<script src="js/DCValidate.js"></script>

<!-- favicons
	================================================== -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dry Clean Order Form</title>

<script>
	function dryCleanValidate(){
		
		var qtyLen  = document.forms["DryCleanForm"]["quantity"].length;
		var cDay = document.forms["DryCleanForm"]["currentDate"].value;
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
				<form method="POST" action="DryCleanOrdersServlet"
					name="DryCleanForm" onsubmit="return dryCleanValidate()">
					
					<h1 data-aos="fade-up" class="title" align="center">Add Dry Clean Order</h1>
					
					<table border="0" class="formTable" align="center" cellpadding="12">
						<tr>
							<td class="title" style="color: #3a2d79; text-indent: 100px;"
								width="600"></td>
							<td style="text-indent: 50px;"><input type="hidden"
								name="userID" value="${sessionScope.userID }" class="text-box">
								<input type = "hidden" value = "<%= Generator.getCurrentDate() %>" name = "currentDate" >
						</tr>
						<tr>
							<th class="caption" width = "600"><span style="color: #39b54a">Item
							</span></th>
							<th class="caption"><span style="color: #39b54a">
									Quantity </span></th>
						</tr>

						<%
							IRatesService iRateService = new RatesServiceImpl();
							ArrayList<DryCleanRates> dryCleanArrayList = iRateService.getDryCleanRates();

							for (DryCleanRates rate : dryCleanArrayList) {
						%>

						<tr>
							<td class="caption" width="600"><%=rate.getRateItem()%></td>

							<td style="text-indent: 160px;">
								<%
									//rate.getRatePackage()
										out.write("<input type = 'hidden' name = 'rateID' value = '" + rate.getRateID() + "'>");
										out.write(
												"<input type = 'number' name = 'quantity' value = '0' class =  'text-box' style = 'color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;'>");
								%>
							</td>
						</tr>
						<%
							}
						%>
						<tr>
							<td class="caption" width="600">Pick Up Date :</td>
							<td style="text-indent: 160px;" align  = "center"><input type="date"
								name="pickDate" class="text-box"
								style="color: black; background-color: white; opacity: 0.7; width: 400px; font-size: 25px; text-indent: 10px;">
						</tr>
						<tr>
							<td></td>
							<td align="center"><input type="submit"
								Value="Add Dry Clean Order" class="button"
								style="color: white; background-color: #39b54a; width: 250px; border-style: none; float: left;margin-right: 400px;">
							</td>
						</tr>
					</table>
				</form>
			</div>

		</div>

	</div>

	<!-- end home-content --> </section>
	<!-- end home -->

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
<!--body>
	<h4>You are logged in as :  ${sessionScope.userfname }  </h4>
	
	<div class = "mainDiv" >
	
	
	</div>
	<br/><br/>
</body-->
</html>