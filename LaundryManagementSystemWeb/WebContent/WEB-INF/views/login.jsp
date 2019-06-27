<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>Laundry Management System Web App</title>
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
<script src="js/pace.min.js"></script>

<!-- favicons
	================================================== -->
</head>
<body>

	<!-- header 
   ================================================== -->
	<header id="header" class="row"> <nav id="header-nav-wrap">
	<ul class="header-main-nav">
		<li><a href="Home.jsp" title="home">Home</a></li>
		<li><a class="smoothscroll" href="#about" title="about">About</a></li>
		<li><a class="smoothscroll" href="#contact" title="contact">ContactUs</a></li>
		<li><a href="LoginRedirectServlet" title="login">Login</a></li>
	</ul>

	<a href="signUp.jsp" title="sign-up" class="button button-primary cta">Sign
		Up</a> </nav> <a class="header-menu-toggle" href="#"><span>Menu</span></a> 
	</header>
	<!-- /header -->


	<!-- home
   ================================================== -->
	 <section id="home" data-parallax="scroll" data-image-src="images/hero-bg.jpg" data-natural-width=3000 data-natural-height=2000>


	<div class="overlay"></div>
	<div class="home-content">

		<div class="row contents">
			<div class="home-content-left">
				 <h1 data-aos="fade-up" class = "title">
                       Log In
                 </h1>
				<form method="POST" action="LoginUserServlet">

					<table border='0'>
						<tr>
							<td colspan="2" align="center" style = "text-align: center;"><font class = "error">
									${message } </font></td>
						</tr>
						<tr>
							<td class = "caption" width = "50">Email</td>
							<td ><input type="text" name="email" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"></td>
						</tr>
						<tr>
							<td class = "caption" width = "50">Password</td>
							<td><input type="password" name="password"  style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;">
							
							</td>	
						</tr>
					
					</table>
							<input type="submit" value="Login" style = "color :white; background-color:#39b54a; margin-left: 700px; width:200px;border-style:none;">


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

	<!-- footer
    ================================================== -->
	<footer>

	<div class="footer-main">
		<div class="row">

			<div class="col-three md-1-3 tab-1-2 mob-full footer-contact">

				<h4>Contact</h4>

				<p>
					1600 Amphitheatre Parkway<br> Mountain View, CA <br>
					94043 US<br>
				</p>

				<p>
					someone@dazzlesite.com <br> Phone: (+63) 555 1212 <br>
					Fax: (+63) 555 0100
				</p>

			</div>
			<!-- end footer-contact -->

			<div class="col-two md-1-3 tab-1-2 mob-full footer-site-links">

				<h4>Site Links</h4>

				<ul class="list-links">
					<li><a href="Home.jsp">Home</a></li>
					<li><a class="smoothscroll" href="#about" title="about">About</a></li>
					<li><a class="smoothscroll" href="#contact" title="contact">ContactUs</a></li>
					<li><a href="LoginRedirectServlet" title="login">Login</a></li>
					<li><a href="signUp.jsp">Sign Up</a></li>
				</ul>

			</div>
			<!-- end footer-site-links -->


		</div>
		<!-- /row -->
	</div>
	<!-- end footer-main -->


	<div class="footer-bottom">

		<div class="row">

			<div class="col-twelve">
				<div class="copyright">
					<span>© Copyright ---------</span> <span>Design by
						-------------------</span>
				</div>

				<div id="go-top">
					<a class="smoothscroll" title="Back to Top" href="#top"><i
						class="icon-arrow-up"></i></a>
				</div>
			</div>

		</div>
		<!-- end footer-bottom -->

	</div>

	</footer>

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
