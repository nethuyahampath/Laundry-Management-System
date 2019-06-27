package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.service.OrdersServiceImpl;
import com.lms.service.IOrdersService;
import com.lms.model.WashFoldOrders;
import com.lms.model.Orders;

/**
 * Servlet implementation class UpdateWashFoldOrderServlet
 */
@WebServlet("/UpdateWashFoldOrderServlet")
public class UpdateWashFoldOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWashFoldOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		IOrdersService iOservice = new OrdersServiceImpl();
		
		WashFoldOrders wfOrder = new WashFoldOrders();
		
		String orderID = request.getParameter("orderID");
		Orders order = new Orders();
		
		order.setOrderID(orderID);
		order.setOrderPickDate(request.getParameter("pickDate"));
		
		iOservice.updateOrders(orderID, order);
		
		wfOrder.setOrderID(orderID);
		wfOrder.setRateID(request.getParameter("package"));
		
		iOservice.updateWashFoldOrders(orderID, wfOrder);
		
		request.setAttribute("order", order);
		request.setAttribute("wfOrder", wfOrder);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/MyOrders.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
