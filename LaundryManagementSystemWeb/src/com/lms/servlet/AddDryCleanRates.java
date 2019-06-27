package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.DryCleanRates;
import com.lms.service.IRatesService;
import com.lms.service.RatesServiceImpl;

/**
 * Servlet implementation class AddDryCleanRates
 */
@WebServlet("/AddDryCleanRates")
public class AddDryCleanRates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDryCleanRates() {
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
		
		DryCleanRates dcR = new DryCleanRates();
		
		dcR.setRateID(request.getParameter("rateID"));
		dcR.setRateItem(request.getParameter("item"));
		dcR.setPricePerUnit(Integer.parseInt(request.getParameter("price")));
	
		IRatesService iRate = new RatesServiceImpl();
		iRate.addDryCleanRates(dcR);
		
		request.setAttribute("dcR", dcR);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Rates.jsp");
		dispatcher.forward(request, response);
	}

}
