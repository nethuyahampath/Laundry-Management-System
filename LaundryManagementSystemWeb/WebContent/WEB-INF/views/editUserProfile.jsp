<%@page import="com.lms.model.User"%>
<%@page import="com.lms.service.IUserService"%>
<%@page import="com.lms.service.UserServiceImpl"%>

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
				<h1 data-aos="fade-up" class="title" align="center">Edit Profile</h1>
			
	<%
	
		User user = (User) request.getAttribute("user");
	
	%>
	<form method="POST" action="userUpdateServlet">
		<table>
			<tr>
				<td class="caption">userID</td>
				<td class="caption"><input type="text" name="userID" disabled="disabled"
					value="<%=user.getUserID()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">firstName</td>
				<td class="caption"><input type="text" name="firstName"
					value="<%=user.getFirstName()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">lastName</td>
				<td class="caption"><input type="text" name="lastName"
					value="<%=user.getLastName()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">password</td>
				<td class="caption"><input type="password" name="password" disabled="disabled"
					value="<%=user.getPassword()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">no</td>
				<td class="caption"><input type="text" name="no"
					value="<%=user.getNo()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">street</td>
				<td class="caption"><input type="text" name="street"
					value="<%=user.getStreet()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption">city</td>
				<td class="caption"><input type="text" name="city"
					value="<%=user.getCity()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td  class="caption">contact</td>
				<td class="caption"><input type="text" name="contact"
					value="<%=user.getContact()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td  class="caption">email</td>
				<td><input type="text" name="email"
					value="<%=user.getEmail()%>" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"/></td>
			</tr>
			<tr>
				<td class="caption"></td>
				<td class="caption"><input type="hidden" name="type" value="User"></td>
			</tr>
			
			
			<tr>
				<td> </td>
				<td colspan="2"><input type="hidden" name="userID" value="<%=user.getUserID()%>" />
				<input type="submit" value="Update Details" style="color: white; background-color: #39b54a; width: 200px; border-style: none;"/></td>
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