package com.lms.servlet;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.service.IOrdersService;
import com.lms.service.OrdersServiceImpl;
import com.lms.util.Generator;

import com.lms.service.*;
import com.lms.model.*;

/**
 * Servlet implementation class DryCleanOrdersServlet
 */
@WebServlet("/DryCleanOrdersServlet")
public class DryCleanOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DryCleanOrdersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		response.setContentType("text/html");

		IOrdersService iOService = new OrdersServiceImpl();

		DryCleanOrders dcOrder = new DryCleanOrders();
		Orders order = new Orders();

		String orderID = Generator.generateDryCleanOrdersID();

		order.setOrderID(orderID);
		order.setOrderDropDate(Generator.getCurrentDate());
		order.setOrderPickDate(request.getParameter("pickDate"));
		order.setUserID(request.getParameter("userID"));

		iOService.addOrder(order);

		dcOrder.setOrderID(orderID);
		dcOrder.setOrderStatus("Pending"); 

		iOService.addDryCleanOrderStatus(dcOrder);

		// get the values RateID and Quantities from Dry Clean Form
		String[] rateIDs = request.getParameterValues("rateID");
		String[] quantities = request.getParameterValues("quantity");

		// convert the string array to integer array
		int[] q = new int[quantities.length];

		for (int i = 0; i < quantities.length; i++) {
			q[i] = Integer.parseInt(quantities[i]);
		}

		for (int i = 0; i < q.length; ++i) {

			dcOrder.setOrderID(orderID);
			dcOrder.setRateID(rateIDs[i]);
			dcOrder.setQuantity(q[i]);

			iOService.addDryCleanOrder(dcOrder);

		}

		request.setAttribute("order", order);
		request.setAttribute("dcOrder", dcOrder);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/MyOrders.jsp");
		dispatcher.forward(request, response);

	}

}
