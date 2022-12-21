package com.fixitytech.fruit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fixitytech.DAO.UsersDAO;
import com.fixitytech.bean.Users;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		System.out.println(fname);
		String dob=request.getParameter("dob");
		int mobile=Integer.valueOf(request.getParameter("mobile"));
		String mail=request.getParameter("email");
		String password=request.getParameter("password");
		String pass=request.getParameter("upassword");
		
		String go=request.getParameter("location");
		
		String img=request.getParameter("profilePic");
		System.out.println(img);
		if(!pass.equals(password))//PASSWORD VERIFICATION
		{
			request.setAttribute("error","Password is not matching");
			doGet(request, response);
		}
		else
		{
			Users user=new Users();
			
			user.setFname(fname);
			user.setLname(lname);
			user.setDob(dob);
			user.setEmail(mail);
			user.setMobile(mobile);
			user.setPassword(password);
			//STORING ALL THE USER DETAILS IN AN OBJECT
			UsersDAO userdao=new UsersDAO();
			try {
				int n=userdao.addUser(user);
				if(n>0)
				{
					request.setAttribute("message","Successfully created Account and login now");
					//AFTER SUCCESSFUL REGISTRATION GO BACK TO LOGIN PAGE
					RequestDispatcher rd=request.getRequestDispatcher(go);
					rd.forward(request, response);
					
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		
	}

}
