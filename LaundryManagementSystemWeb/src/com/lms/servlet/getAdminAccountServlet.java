package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.model.User;
import com.lms.service.IUserService;
import com.lms.service.UserServiceImpl;

/**
 * Servlet implementation class getAdminAccountServlet
 */
@WebServlet("/getAdminAccountServlet")
public class getAdminAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAdminAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

 		String userID = request.getParameter("userID");			
		IUserService iUserService = new UserServiceImpl();
		User user = iUserService.getTheUserByID(userID);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/editAdminProfile.jsp");
		dispatcher.forward(request, response);
	}

}
