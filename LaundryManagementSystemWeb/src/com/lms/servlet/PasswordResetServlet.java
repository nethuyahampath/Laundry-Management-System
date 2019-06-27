package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.lms.model.User;
import com.lms.service.IUserService;
import com.lms.service.UserServiceImpl;

/**
 * Servlet implementation class PasswordResetServlet
 */
@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetServlet() {
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
		
		
		String currentPassword = request.getParameter("currentPassword");	
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		String userID=request.getParameter("userID");
		
		IUserService iUserService = new UserServiceImpl();
		User user = iUserService.getTheUserByID(userID);
		
		
		String userpw =user.getPassword();
		
			
		if(currentPassword.equals(userpw)){
			
			if(newPassword.equals(confirmPassword)) {
		
				user.setPassword(confirmPassword);
				iUserService.updateUser(userID, user);

		request.setAttribute("user", user);
		//response.sendRedirect("/WEB-INF/views/userProfile.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp");
		dispatcher.forward(request, response);
			}else {
				
				request.setAttribute("message", "Password Didn't Match");
				//response.sendRedirect("/WEB-INF/views/login.jsp");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");	
				dispatcher.forward(request, response);
				//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
			
			
		
		}else {
			
			request.setAttribute("message", "Current Password Is Wrong");
			//response.sendRedirect("/WEB-INF/views/login.jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");	
			dispatcher.forward(request, response);
			//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
