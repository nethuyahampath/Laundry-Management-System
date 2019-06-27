package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lms.model.WashFoldOrders;
import com.lms.service.IOrdersService;
import com.lms.service.OrdersServiceImpl;

/**
 * Servlet implementation class ToUpdateWFServlet
 */
@WebServlet("/ToUpdateWFServlet")
public class ToUpdateWFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateWFServlet() {
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
		
		String orderID = request.getParameter("orderID");
		
		IOrdersService iOrders = new OrdersServiceImpl();
		
		WashFoldOrders wfOrder = iOrders.getWashFoldOrderByID(orderID);
		
		request.setAttribute("wfOrder", wfOrder);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/WashFoldUpdateForm.jsp");
		dispatcher.forward(request, response);
		
	}

}
