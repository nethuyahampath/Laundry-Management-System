package com.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.WashFoldOrders;
import com.lms.model.Orders;
import com.lms.service.IOrdersService;
import com.lms.service.OrdersServiceImpl;
import com.lms.util.Generator;
/**
 * Servlet implementation class WashFoldOrdersServlet
 */
@WebServlet("/WashFoldOrdersServlet")
public class WashFoldOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WashFoldOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		IOrdersService iOService = new OrdersServiceImpl();
		
		WashFoldOrders wfOrder = new WashFoldOrders();
		Orders order = new Orders();
		
		String orderID = Generator.generateWashFoldOrdersID();
		
		order.setOrderID(orderID);
		order.setOrderDropDate(Generator.getCurrentDate());
		order.setOrderPickDate(request.getParameter("pickDate"));
		order.setUserID(request.getParameter("userID"));
		
		iOService.addOrder(order);
		
		wfOrder.setOrderID(orderID);
		wfOrder.setOrderStatus("Pending");
		
		iOService.addWashFoldOrderStatus(wfOrder);
		
		wfOrder.setOrderID(orderID);
		wfOrder.setRateID(request.getParameter("package"));
		wfOrder.setWeight(0);
		
		iOService.addWashFoldOrder(wfOrder);
		
		request.setAttribute("order", order);
		request.setAttribute("wfOrder", wfOrder);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/MyOrders.jsp");
		dispatcher.forward(request,response);
	}

}
