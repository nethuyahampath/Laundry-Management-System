package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.Rates;
import com.lms.model.WashFoldRates;
import com.lms.service.IRatesService;
import com.lms.service.RatesServiceImpl;

/**
 * Servlet implementation class updateWFRatesServlet
 */
@WebServlet("/updateWFRatesServlet")
public class updateWFRatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateWFRatesServlet() {
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
		
		WashFoldRates wfR = new WashFoldRates();
		
		String rateID = request.getParameter("rateID");
		
		wfR.setRateID(rateID);
		wfR.setRatePackage(request.getParameter("package"));
		wfR.setSmallWeightPrice(Integer.parseInt(request.getParameter("small")));
		wfR.setMediumWeightPrice(Integer.parseInt(request.getParameter("medium")));
		wfR.setLargeWeightPrice(Integer.parseInt(request.getParameter("large")));

		iRService.updateWashFoldRates(rateID, wfR);
		
		//request.setAttribute("wfR", wfR);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Rates.jsp");
		dispatcher.forward(request, response);
	}

}
