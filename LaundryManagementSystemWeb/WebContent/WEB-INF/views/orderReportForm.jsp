<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>

	<table class="sub" align="center">
		<tr>
			<td>
				<h1>Wash Fold Status</h1>
				<form action = "OrderReportServlet" method = "POST" >
				<table border="1" align="center">
					<tr>
						<td>Type :</td>
						<td>Wash Fold Orders :</td>
					</tr>
					<tr>
						<td>Orders dropped on :</td>
						<td><input type="date" name="dropDate"></td>
					</tr>
					<tr>
						<td>Status :</td>
						<td><select name="status">
								<option value="Pending">Pending</option>
								<option value="Washing">Washing</option>
								<option value="Folding">Folding</option>
								<option value="Completed">Completed</option>
						</select></td>
					<tr>
						<td></td>
						<td><input type="submit" value="Wash Fold Report"
							name="button"></td>
					</tr>

				</table>
				</form>
			</td>
		</tr>
		<tr>
			<td><br>
				<hr>
				<h1>Dry Clean Status</h1>
				<form method = "POST" action = "OrderReportServlet">
				<table border="1" align="center">
					<tr>
						<td>Type :</td>
						<td>Dry Clean Orders :</td>
					</tr>
					<tr>
						<td>Orders dropped on :</td>
						<td><input type="date" name="dropDate"></td>
					</tr>
					<tr>
						<td>Status</td>
						<td><select name="status">
								<option value="Pending">Pending</option>
								<option value="Drying">Drying</option>
								<option value="Cleaning">Cleaning</option>
								<option value="Completed">Completed</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Dry Clean Report"
							name="button"></td>
					</tr>
				</table>
				</form>
				</td>
				

		</tr>
	</table>
</body>
</html>