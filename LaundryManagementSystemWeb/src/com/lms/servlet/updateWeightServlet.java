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
 * Servlet implementation class updateWeightServlet
 */
@WebServlet("/updateWeightServlet")
public class updateWeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateWeightServlet() {
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
		
		IOrdersService iOService = new OrdersServiceImpl();
		
		WashFoldOrders wfO = new WashFoldOrders();
		
		String orderID = request.getParameter("orderID");
		
		int weight = Integer.parseInt(request.getParameter("weight"));
	
		
		iOService.updateWashFoldWeight(orderID, weight);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/WeightList.jsp");
		dispatcher.forward(request, response);
	}

}
