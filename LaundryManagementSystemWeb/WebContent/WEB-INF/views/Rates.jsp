<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.model.WashFoldRates"%>
<%@page import="com.lms.model.DryCleanRates"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lms.service.RatesServiceImpl"%>
<%@page import="com.lms.service.IRatesService"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rates</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>

	<table class="sub" align="center">
		<tr>
			<td><input type="hidden" value="${sessionScope.userID }">

				<%
					out.write("<h1> Admin Rates Display </h1>");
				%>
				<table border="1" align = "center">

					<tr>
						<th>Rate ID</th>
						<th>Package</th>
						<th>Small Weight Price</th>
						<th>Medium Weight Price</th>
						<th>Large Weight Price</th>

					</tr>
					<%
						IRatesService iRateService = new RatesServiceImpl();
						ArrayList<WashFoldRates> washFoldArrayList = iRateService.getWashFoldRates();

						for (WashFoldRates rate : washFoldArrayList) {
					%>
					<form method="POST" action="updateWFRatesServlet">


						<tr>
							<td><%=rate.getRateID()%></td>
							<td><input type="text" value="<%=rate.getRatePackage()%>"
								name="package"></td>
							<td><input type="number"
								value="<%=rate.getSmallWeightPrice()%>" name="small"></td>
							<td><input type="number"
								value="<%=rate.getMediumWeightPrice()%>" name="medium">
							</td>
							<td><input type="number"
								value="<%=rate.getLargeWeightPrice()%>" name="large"></td>

							<td><input type="hidden" name="rateID"
								value="<%=rate.getRateID()%>"> <input type="submit"
								value="update" class="update-button"></td>

						</tr>

					</form>
					<%
						}
					%>

				</table>

				<table border="0"  align = "center">
					<caption>Delete Wash Fold Rate</caption>
					<tr>
						<td>
					<tr>
						<td>Enter Rate ID:</td>
						<td>
							<form method="POST" action="DeleteWFRatesServlet">
								<input type="text" name="rateID"> <input type="submit"
									value="delete" class="delete-button">
							</form>
						</td>
					</tr>
				</table> <br> <br>
				
				<table border="1"  align = "center">

					<tr>
						<th>Rate ID</th>
						<th>Item</th>
						<th>Price Per Unit</th>
					</tr>
					<%
						ArrayList<DryCleanRates> dryCleanArrayList = iRateService.getDryCleanRates();

						for (DryCleanRates rate : dryCleanArrayList) {
					%>
					<form method="POST" action="updateDCRatesServlet">

						<tr>
							<td><%=rate.getRateID()%></td>
							<td><input type="text" value="<%=rate.getRateItem()%>"
								name="item"></td>
							<td><input type="number" value="<%=rate.getPricePerUnit()%>"
								name="price"></td>

							<td><input type="hidden" name="rateID"
								value="<%=rate.getRateID()%>"> <input type="submit"
								value="update" class="update-butten"></td>

						</tr>
					</form>
					<%
						}
					%>
				</table>

				<table border="0"  align = "center">
					<caption>Delete Dry Clean Rate</caption>
					<tr>
						<td>
					<tr>
						<td>Enter Rate ID:</td>
						<td>
							<form method="POST" action="DeleteDCRatesServlet">
								<input type="text" name="rateID"> <input type="submit"
									value="delete" class="delete-button">
							</form>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>