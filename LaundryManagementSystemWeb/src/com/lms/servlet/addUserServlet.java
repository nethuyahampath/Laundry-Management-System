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
import com.lms.service.IPaymentService;
import com.lms.service.IUserService;
import com.lms.service.PaymentServiceImpl;
import com.lms.service.UserServiceImpl;
import com.lms.util.Generator;

/**
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		User user=new User();
		
		
		
		String userID = Generator.generateUserIDs();
	
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
		iUserService.addUser(user);
		
		IPaymentService iPaymentService = new PaymentServiceImpl();
		iPaymentService.addDepositRecord(userID, 0.0);
		
		String typeUser="User";
		String UserType=user.getType();
		
		String userpw =user.getPassword();
		String usertype =user.getType();
		String userfname =user.getFirstName();
		
		
		
		
		HttpSession session=request.getSession();
		session.setAttribute("userID", userID);
		session.setAttribute("userfname", userfname);

		if(typeUser.compareTo(UserType)==0){
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
		}
		else {
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/adminProfile.jsp");
		dispatcher.forward(request, response);
	}
	
	}

}
