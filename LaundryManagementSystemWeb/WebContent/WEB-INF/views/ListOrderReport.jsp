<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.lms.service.IOrdersService"%>
<%@page import="com.lms.service.OrdersServiceImpl"%>
<%@page import="com.lms.model.WashFoldOrders"%>
<%@page import="com.lms.model.DryCleanOrders"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/adminHeader.jsp"></jsp:include>
	<table class="sub" align="center" border = "0">
		<tr><td>
		<%
			String type = (String) request.getAttribute("type");
		
			String date = (String) request.getAttribute("dropDate");
			String status = (String) request.getAttribute("orderStatus");
		
			if( type.compareTo("WF") == 0 ){
		%>
		<h1> Wash Fold Report</h1>
		<table align = "center" border = "1" cellpadding = "12">
			<tr>
				<th> Order ID </th>
				<th> Drop Date </th>
				<th> Status </th>
			</tr>
			
			<%
				IOrdersService iOrders1 = new OrdersServiceImpl();
				ArrayList<WashFoldOrders> list1 = iOrders1.WashFoldStatusReport(date, status);
				
				for( WashFoldOrders wfo : list1 ){
			%>
			<tr>
				<td> <%= wfo.getOrderID() %></td>
				<td> <%= wfo.getOrderDropDate() %> </td>
				<td> <%= wfo.getOrderStatus() %> </td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
			else
				if(type.compareTo("DC") == 0 ){
		%>
		<h1> Dry Clean Report </h1>
		<table align = "center"  border = "1" cellpadding = "12"> 
			<tr>
				<th> Order ID </th>
				<th> Drop Date </th>
				<th> Status </th>
			</tr>
			
			
			<%
				IOrdersService iOrders2 = new OrdersServiceImpl();
				ArrayList<WashFoldOrders> list2 = iOrders2.WashFoldStatusReport(date, status);
				
				for( WashFoldOrders dco : list2 ){
			%>
			<tr>
				<td> <%= dco.getOrderID() %></td>
				<td> <%= dco.getOrderDropDate() %> </td>
				<td> <%= dco.getOrderStatus() %> </td>
			</tr>
			<%
				}
			%>
		</table>
		
		<%
				}
		%>
		</td></tr>
	</table>
	
</body>
</html>