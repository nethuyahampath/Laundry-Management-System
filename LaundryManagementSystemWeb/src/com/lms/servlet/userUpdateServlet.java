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
 * Servlet implementation class userUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		User user = new User();
		String userID = request.getParameter("userID");	
		
		user.setUserID(userID);
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setPassword(request.getParameter("password"));
		user.setNo(Integer.parseInt(request.getParameter("no")));
		user.setStreet(request.getParameter("street"));
		user.setCity(request.getParameter("city"));
		user.setContact(request.getParameter("contact"));
		user.setEmail(request.getParameter("email"));
		user.setType(request.getParameter("type"));
		
		IUserService iUserService = new UserServiceImpl();
		iUserService.updateUser(userID, user);
		
		
		String UserType=user.getType();
		
		if(UserType.compareTo("User")==0){
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/userProfile.jsp");
			dispatcher.forward(request, response);
		}
		if(UserType.compareTo("Admin")==0){
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/editAdminProfile.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
