<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.model.Review"%>
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
				<h1 data-aos="fade-up" class="title" align="center">Customer
					Reviews</h1>
				<form method="POST" action="ReviewServlet">
					
					<table border="0" align = "center">
						<tr>
							<td style = "color : white;"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Name : ${sessionScope.userfname } <input type="hidden"
								name="fname" value="${sessionScope.userfname }">
							</td>
						</tr>
						<tr>
							<td style = "color : white;"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" name="grade" value="Very Bad">
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspVery Bad &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="radio" name="grade" value="Bad">Bad
								&nbsp&nbsp&nbsp&nbsp&nbsp <input type="radio" name="grade" value="Good">Good &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<input type="radio" name="grade" value="Very Good">Very
								Good &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="radio" name="grade" value="Excellent">Excellent
							</td>
						</tr>
						<tr>

							<td style = "color : white;" > &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Comment : <br> <textarea rows="5" cols="50"
									name="comment" style = "background-color : white; width : 950px; margin-left: 80px;opacity : 0.7;"></textarea>
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="Add Review" style = "color :white; background-color:#39b54a; margin-left: 700px; width:200px;border-style:none;"> <input
								type="hidden" name="userID" value="${sessionScope.userID }">
							</td>
						</tr>
					</table>
				</form>

				<br>

				<%
					IUserService iUserService = new UserServiceImpl();
					ArrayList<Review> reviewList = iUserService.getUserReviews();

					for (Review rev : reviewList) {
				%>
				<hr style = "background-color : white;">
				<table border="0" align = "center">
					<tr>
						<td style = "color : white; text-indent: 50px;" width = "300">Date :</td>
						<td style = "color : white;"><%=rev.getDate()%></td>
					</tr>
					<tr>
						<td  style = "color : white; text-indent: 50px;" width = "300">Name :</td>
						<td style = "color : white;"><%=rev.getFname()%></td>
					</tr>
					<tr>
						<td  style = "color : white; text-indent: 50px;" width = "300">Grade :</td>
						<td style = "color : white;"><%=rev.getGrade()%></td>
					</tr>
					<tr>
						<td  style = "color : white; text-indent: 50px;" width = "300">Comment :</td>
						<td ><textarea disabled rows="5" cols="50" style = "background-color : white; width : 700px;opacity : 0.7; color : black;">
						<%=rev.getComment()%>
					</textarea></td>
					</tr>
				</table>
				<%
					} //end for
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