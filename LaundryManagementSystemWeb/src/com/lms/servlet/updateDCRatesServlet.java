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
 * Servlet implementation class updateDCRatesServlet
 */
@WebServlet("/updateDCRatesServlet")
public class updateDCRatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDCRatesServlet() {
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
		
		IRatesService iRService = new RatesServiceImpl();
		
		DryCleanRates dcR = new DryCleanRates();
		
		String rateID = request.getParameter("rateID");
		
		dcR.setRateID(rateID);
		dcR.setRateItem(request.getParameter("item"));
		dcR.setPricePerUnit(Integer.parseInt(request.getParameter("price")));
		
		iRService.updateDryCleanRates(rateID, dcR);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Rates.jsp");
		dispatcher.forward(request, response);
	}

}
