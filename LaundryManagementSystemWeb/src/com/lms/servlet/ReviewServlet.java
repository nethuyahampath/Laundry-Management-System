package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.Review;
import com.lms.service.IUserService;
import com.lms.service.UserServiceImpl;
import com.lms.util.Generator;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
		
		Review rev = new Review();
		
		String reviewID = Generator.generateReviewIDs();
		
		
		rev.setReviewID(reviewID);
		rev.setUserID(request.getParameter("userID"));
		rev.setFname(request.getParameter("fname"));
		rev.setGrade(request.getParameter("grade"));
		rev.setDate(Generator.getCurrentDate());
		rev.setComment(request.getParameter("comment"));
		
		IUserService iUserService = new UserServiceImpl();
		iUserService.addReview(rev);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Reviews.jsp");
		dispatcher.forward(request, response);
	}

}
