package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.service.IPaymentService;
import com.lms.service.IUserService;
import com.lms.service.PaymentServiceImpl;
import com.lms.service.UserServiceImpl;

/**
 * Servlet implementation class deletePaymentRecordServlet
 */
@WebServlet("/deletePaymentRecordServlet")
public class deletePaymentRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePaymentRecordServlet() {
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

		String paymentID = request.getParameter("paymentID");	
		
		IPaymentService iPaymentService = new PaymentServiceImpl();
		iPaymentService.deletePaymentRecord(paymentID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/PaymentList.jsp");
		dispatcher.forward(request, response);
	}

}
