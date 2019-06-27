package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.Payment;
import com.lms.service.IPaymentService;
import com.lms.service.PaymentServiceImpl;
import com.lms.util.Generator;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
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
		
		IPaymentService iPayService = new PaymentServiceImpl();
		
		Payment pay =  new Payment();
		
		
		String paymentID = Generator.generatePaymentID();
		
		String userID =  request.getParameter("userID");
		double total = Double.parseDouble(request.getParameter("amount"));
		
		pay.setPaymentID(paymentID);
		pay.setPaymentDate(Generator.getCurrentDate());
		pay.setAmount(Double.parseDouble(request.getParameter("amount")));
		pay.setOrderType(request.getParameter("orderType"));
		pay.setUserID(request.getParameter("userID"));
		pay.setOrderID(request.getParameter("orderID"));
		
		Double depositAmount=iPayService.getDeposit(userID);
		Double result = iPayService.validateDeposit(userID, total);
		
		
		
		if( result != null ) {
		
			
			iPayService.updateDepositAmount(userID, result);
			
			request.setAttribute("pay", pay);
			request.setAttribute("result", result);
			request.setAttribute("depositAmount", depositAmount);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ValidatePayment.jsp");
			dispatcher.forward(request,response);
			
		}else {
			request.setAttribute("pay", pay);
			request.setAttribute("result", result);
			request.setAttribute("depositAmount", depositAmount);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ValidatePayment.jsp");
			dispatcher.forward(request,response);
		}
		
		iPayService.addPayment(pay);
		
		
	}

}
