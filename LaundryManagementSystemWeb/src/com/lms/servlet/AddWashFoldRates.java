package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.WashFoldRates;
import com.lms.service.IRatesService;
import com.lms.service.RatesServiceImpl;

/**
 * Servlet implementation class AddWashFoldRates
 */
@WebServlet("/AddWashFoldRates")
public class AddWashFoldRates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWashFoldRates() {
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
		
		WashFoldRates wfR = new WashFoldRates();

		wfR.setRateID(request.getParameter("Id"));
		wfR.setRatePackage(request.getParameter("Package"));
		wfR.setSmallWeightPrice(Integer.parseInt(request.getParameter("Small")));
		wfR.setMediumWeightPrice(Integer.parseInt(request.getParameter("Medium")));
		wfR.setLargeWeightPrice(Integer.parseInt(request.getParameter("Large")));
		
		IRatesService iRate = new RatesServiceImpl();
		iRate.addWashFoldRates(wfR);
		
		request.setAttribute("wfR", wfR);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Rates.jsp");
		dispatcher.forward(request, response);
	}

}
