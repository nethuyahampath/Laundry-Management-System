package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
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
		
		String button = request.getParameter("button");
		
		if( button.compareTo("Account") == 0 ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Home") == 0 ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Rates List") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListRates.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Add Wash Fold Order") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/WashFoldForm.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Add Dry Clean Order") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/DryCleanForm.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("My Orders") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/MyOrders.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Orders Status") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/StatusList.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Update Weight") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/WeightList.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Admin Rates") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Rates.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Add Rates") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/RatesForm.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Display All Users") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/getAllUsers.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Record History") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/PaymentList.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Reviews") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Reviews.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Add Deposit") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/AddDeposit.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Order Report") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/orderReportForm.jsp");
			dispatcher.forward(request, response);
		}
		

		if( button.compareTo("Password Reset") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");
			dispatcher.forward(request, response);
		}
		
		if( button.compareTo("Customer Report") == 0  ) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/getAllCustomers.jsp");
			dispatcher.forward(request, response);
		}
		
		

		
		
	}

}
