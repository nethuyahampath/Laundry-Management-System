package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderReportServlet
 */
@WebServlet("/OrderReportServlet")
public class OrderReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderReportServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String btn = request.getParameter("button");
		
		String type = "";
		String dropDate = request.getParameter("dropDate");
		String orderStatus = request.getParameter("status");
		
		if( btn.compareTo("Wash Fold Report") == 0 ) {
			
			type = "WF";
			
			request.setAttribute("type", type);
			request.setAttribute("dropDate", dropDate);
			request.setAttribute("orderStatus", orderStatus);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListOrderReport.jsp");
			dispatcher.forward(request, response);
		}
		else
			if( btn.compareTo("Dry Clean Report") == 0 ) {
				
				type = "DC";
				
				request.setAttribute("type", type);
				request.setAttribute("dropDate", dropDate);
				request.setAttribute("orderStatus", orderStatus);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListOrderReport.jsp");
				dispatcher.forward(request, response);
			}

		
	}

}
