<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<script>
	function formValidate()
	{
		var date = document.forms["myForms"]["pickDate"].value;
		alert(date);
	}
</script>
<meta charset="UTF-8">
<title>Student Test </title>
</head>
<body class="body">
	<form method = "POST" action = "WashFoldOrdersServlet" name = "myForms" onsubmit = "return formValidate()">
		<table border = "1">
			
			<tr>
				<td> Select The Package : </td>
				<td> 
					<select name = "package" >
							<option value="Please Select"> Please Select </option> 
							<option value="Regular-Laundry"> Regular-Laundry</option>
							<option value="Bedding"> Bedding </option>
							<option value="Wedding"> Wedding </option>
					</select>
				</td>
			</tr>
			<tr>
				<td> Pick Up Date : </td>
				<td> <input type = "date" name = "pickDate">
			</tr>
			<tr>
				<td> <input type = "submit" value = "Add Dry Clean Order" >
			</tr>			
		</table>
	</form>
</body>
</html>