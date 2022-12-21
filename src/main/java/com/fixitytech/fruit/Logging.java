package com.fixitytech.fruit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.UsersDAO;
import com.fixitytech.bean.Users;

/**
 * Servlet implementation class LoggingIn
 */
@WebServlet("/logging")
public class Logging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logging() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("mail");
		String password=request.getParameter("password");
		
		String go=request.getParameter("location");
		
		UsersDAO userdao=new UsersDAO();
		
		Users user=userdao.validate(email,password);//returning user object
		
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("userid", user);
			RequestDispatcher rd=request.getRequestDispatcher(go);
			rd.forward(request,response);
		}
		else if(email.equalsIgnoreCase("admin@123.com") && password.equals("admin"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("role","Administrator");
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
		else if(user==null)
		{
			request.setAttribute("message","invalid user name or password");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}
	}

}
