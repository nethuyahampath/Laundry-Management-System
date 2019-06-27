<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- header 
   ================================================== -->
	<header id="header" class="row">
		<nav id="header-nav-wrap">
			<ul class="header-main-nav">
				<li>
				<form method = "POST" action  =  "SearchResultServlet" >
        
                            <select name = "rate" style = "background-color: white; height : 50px; position:absolute;right:900px;">
                                <option value="Wash-Fold-Rates"> Wash Fold Rates </option>
                                <option value="Dry-Clean-Rates"> Dry Clean Rates </option>
                            </select>
                    	     <input type = "submit" value = "Search" style = "margin-right: 100px;height:50px;">
                    </form>
                    
				</li>
				
				<li>
					<form method="POST" action="RedirectServlet">
						<input class="btn" type="submit" value="Home" name="button"
							style="background-color: Transparent; color: gray; border-style: none;">
					</form>
				</li>
				<li>
					<form method="POST" action="RedirectServlet">
						<input type="submit" value="My Orders" name="button"
							style="background-color: Transparent; color: gray; border-style: none;">
					</form>
				</li>
				<li>
					<form method="POST" action="RedirectServlet">
						<input type="submit" value="Reviews" name="button"
							style="background-color: Transparent; color: gray; border-style: none;">
					</form>
				</li>
				<li>
					<form method="POST" action="RedirectServlet">
						<input type="submit" value="Account" name="button"
							style="background-color: Transparent; color: gray; border-style: none;">
					</form>
				</li>
				
				<!--li>
					<a class="smoothscroll" href="#contact" title="about">
						<input type="button" value="Contact Us" name="button"
							style="background-color: Transparent; color: gray; border-style: none;">
					</a>	
				</li-->
				
				
			</ul>

			<a href="LogoutUserServlet"
				class="button button-primary cta" style = "background-color : red; border-style:none;">Log Out</a>
		</nav>
		
		<a class="header-menu-toggle" href="#"><span>Menu</span></a>
		
		<table border = "0" style = " position: absolute;top:68px; height : 50px;background-color: #111111;">

			<tr>
				<td align = "center" width = "550"> 
				 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<font style = "font-size: 20px;"> Logged in As : <span style = "color : #39b54a; " >${sessionScope.userfname } </span> </font> 	
				</td>
				<td align = "center">
				<form method = "POST" action = "RedirectServlet" >
						<input type = "submit" value = "Add Wash Fold Order" name = "button" style = "position :absolute; top : 0;height: 50px; color :white; background-color:#39b54a; width:200px;border-style:none;">
					</form>
					<form method = "POST" action = "RedirectServlet" >
						<input type = "submit" value = "Add Dry Clean Order" name = "button" style = "position :absolute; top : 0; right:140px;height: 50px; color :white; background-color:#39b54a; width:200px;border-style:none;" >
					</form>
				</td>
			</tr>
		</table>
	</header>
	<!-- /header -->
	
</body>
</html>