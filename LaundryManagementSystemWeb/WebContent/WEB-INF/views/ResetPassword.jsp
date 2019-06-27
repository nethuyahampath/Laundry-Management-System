<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Reset</title>

<script>
	function updatePasswordValidate() {

		var currentPassword = document.forms["myForms"]["currentPassword"].value;
		var newPassword = document.forms["myForms"]["newPassword"].value;
		var confirmPassword = document.forms["myForms"]["confirmPassword"].value;

		/*if(passwordValidation(password)){
		 return true;
		 }else {
		 return false;
		 }*/

		if (currentPasswordValidation(currentPassword))
			if (newPasswordValidation(newPassword))
				if (confirmPasswordValidation(confirmPassword))
					return true;

				else
					return false;
			else
				return false;
		else
			return false;

	}

	function isEmpty(elemValue, field) {
		if (elemValue == "" || elemValue == null) {
			alert("you cannot have " + field + " filed empty");
			return true;
		} else {
			return false;
		}
	}

	function currentPasswordValidation(elemValue) {
		if (!isEmpty(elemValue, "Current Password")) {
			var pw = document.forms["myForms"]["currentPassword"].value;
			var specialchar = "~!@#$%^&*_";
			var count = 0;

			for (var i = 0; i < pw.length; i++) {
				if (specialchar.indexOf(pw.charAt(i)) > -1) {
					count = 1;
				}
			}

			if (/[a-z]/.test(pw)) {
				count++;
			}

			if (/[A-Z]/.test(pw)) {
				count++;
			}
			if (/[\d]/.test(pw)) {
				count++;
			}
			if (pw.length >= 8) {
				count++;
			}

			if (count >= 5) {
				return true;
			} else {

				alert("Password must be at least 8 characters long and must be a combination of uppercase characters, lowercase characters, numeric characters and a special character. ");
				return false;
			}

		} else {
			return false;
		}

	}

	function newPasswordValidation(elemValue) {
		if (!isEmpty(elemValue, "New Password")) {
			var pw = document.forms["myForms"]["newPassword"].value;
			var specialchar = "~!@#$%^&*_";
			var count = 0;

			for (var i = 0; i < pw.length; i++) {
				if (specialchar.indexOf(pw.charAt(i)) > -1) {
					count = 1;
				}
			}

			if (/[a-z]/.test(pw)) {
				count++;
			}

			if (/[A-Z]/.test(pw)) {
				count++;
			}
			if (/[\d]/.test(pw)) {
				count++;
			}
			if (pw.length >= 8) {
				count++;
			}

			if (count >= 5) {
				return true;
			} else {

				alert("Password must be at least 8 characters long and must be a combination of uppercase characters, lowercase characters, numeric characters and a special character. ");
				return false;
			}

		} else {
			return false;
		}

	}

	function confirmpasswordValidation(elemValue) {
		if (!isEmpty(elemValue, "Confirm Password")) {
			var pw = document.forms["myForms"]["confirmPassword"].value;
			if (elemValue != pw) {
				alert("Passwords are didn't match.");
				return false;
			} else {

				return true;
			}
		} else {
			return false;
		}

	}
</script>
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
				<h1 data-aos="fade-up" class="title" align="center">Reset
					Password</h1>


				<form method="POST" onsubmit="return updatePasswordValidate()"
					action="PasswordResetServlet" name="myForms">
					${message }
					<table>


						<tr>
							<td class = "caption">Current Password</td>
							<td ><input type="text" name="currentPassword" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"></td>
						</tr>
						<tr>
							<td class = "caption">New Password</td>
							<td><input type="password" name="newPassword" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"></td>
						</tr>
						<tr>
							<td class = "caption">Confirm Password</td>
							<td><input type="password" name="confirmPassword" style = "color : black; background-color : white;opacity: 0.7; width : 600px; font-size : 25px; text-indent: 10px;"></td>
						</tr>

						<tr>
							<td><input type="hidden" name="userID"
								value="${sessionScope.userID }">
							<input type="reset" value="Reset Fields" style = "border-style:none;background-color:red;color:white;width:200px;float :right;"></td>
						
							<td><input type="submit" value="Reset Password" style = "color :white; background-color:#39b54a; margin-left: 200px; width:200px;border-style:none;"></td>
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