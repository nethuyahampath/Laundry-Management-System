<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript">
	function WashFoldRatesValidate() {
		
		
		var id=document.forms["myForms"]["Id"].value;
		var pack=document.forms["myForms"]["Package"].value;
		var small=document.forms["myForms"]["Small"].value;	
		var medium=document.forms["myForms"]["Medium"].value;
		var large=document.forms["myForms"]["Large"].value;
		
		if( id == "" || pack == "" || small == "" || medium == "" || large == "" ){
			alert("You cannot keep the fields empty");
			return false;
		}
		else
			return true;
	}
	
	function DryCleanRatesValidate() {
		
	
		var id=document.forms["myForms"]["rateID"].value;
		var item=document.forms["myForms"]["item"].value;
		var price=document.forms["myForms"]["price"].value;	
		
		
		if( id =="" || item == "" || price == "" ){
			alert("You cannot keep the fields empty");
			return false;
		}
		else
			return true;
	}
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	<table class="sub" align="center">
		<tr>
			<td>
				<h3>Add Wash Fold Rates</h3>
				<form method="post" action="AddWashFoldRates"
					onsubmit="return WashFoldRatesValidate()" name="myForms">

					<table border="1" align="center">

						<tr>
							<td>Rate ID:</td>
							<td><input type="text" name="Id"></td>
						</tr>
						<tr>
							<td>Package:</td>
							<td><input type="text" name="Package"></td>
						</tr>
						<tr>
							<td>Small Weight Price:</td>
							<td><input type="number" name="Small"></td>
						</tr>
						<tr>
							<td>Medium Weight Price:</td>
							<td><input type="number" name="Medium"></td>
						</tr>
						<tr>
							<td>Large Weight Price:</td>
							<td><input type="number" name="Large"></td>
						</tr>
						<tr>
							<td><input type="submit" value="submit"></td>
						</tr>
					</table>
				</form> <br> <br>
				<h3>Add Dry Clean Rates</h3>

				<form action="AddDryCleanRates" method="POST" name="myForms" onsubmit="return DryCleanRatesValidate()">
					<table border="1" align="center">
						<tr>
							<td>Rate ID</td>
							<td><input type="text" name="rateID"></td>
						</tr>
						<tr>
							<td>Item</td>
							<td><input type="text" name="item"></td>
						</tr>
						<tr>
							<td>Price Per Unit</td>
							<td><input type="number" name="price"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Add"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>