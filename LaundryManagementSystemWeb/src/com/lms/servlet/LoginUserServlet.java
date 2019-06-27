
package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.model.User;
import com.lms.service.IUserService;
import com.lms.service.UserServiceImpl;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		HttpSession session=request.getSession();
		session.removeAttribute("userID");
		session.invalidate();
		response.sendRedirect("home.jsp");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		
		String email = request.getParameter("email");	
		String password = request.getParameter("password");
		
		
		IUserService iUserService = new UserServiceImpl();
		User user = iUserService.getTheUserByEmail(email,password);
		
		
		String userpw =user.getPassword();
		String usertype =user.getType();
		String userfname =user.getFirstName();
		
		
		String userID=user.getUserID();
		
		HttpSession session=request.getSession();
		session.setAttribute("userID", userID);
		session.setAttribute("userfname", userfname);
			
			
		if(password.equals(userpw) && usertype.equals("User")){
		
			

		request.setAttribute("user", user);
		//response.sendRedirect("/WEB-INF/views/userProfile.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
		
		}else if(password.equals(userpw) && usertype.equals("Admin")){
				
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminProfile.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			request.setAttribute("message", "Invalid Credentials");
			//response.sendRedirect("/WEB-INF/views/login.jsp");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");	
			dispatcher.forward(request, response);
			//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
		
	}
}

