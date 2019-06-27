package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lms.model.DryCleanOrders;
import com.lms.model.Orders;
import com.lms.service.IOrdersService;
import com.lms.service.OrdersServiceImpl;
/**
 * Servlet implementation class UpdateDryCleanOrderServlet
 */
@WebServlet("/UpdateDryCleanOrderServlet")
public class UpdateDryCleanOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDryCleanOrderServlet() {
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
		
		
		DryCleanOrders dcOrder = new DryCleanOrders();
		
		String orderID = request.getParameter("orderID");
		Orders order = new Orders();
		
		order.setOrderID(orderID);
		order.setOrderPickDate(request.getParameter("pickDate"));
		
		iOService.updateOrders(orderID, order);
		
		String[] rateIDs = request.getParameterValues("rateID");
		String[] quantities = request.getParameterValues("quantity");
		
		int[] q = new int[quantities.length];

		for (int i = 0; i < quantities.length; i++) {
			q[i] = Integer.parseInt(quantities[i]);
		}
		
		for (int i = 0; i < q.length; ++i) {

			dcOrder.setOrderID(orderID);
			dcOrder.setRateID(rateIDs[i]);
			dcOrder.setQuantity(q[i]);

			iOService.updateDryCleanOrders(orderID, dcOrder);

		} //end for
		
		request.setAttribute("order", order);
		request.setAttribute("dcOrder", dcOrder);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/MyOrders.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
