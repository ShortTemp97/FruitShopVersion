package com.fixitytech.fruit;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.bean.Cart;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/placeOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getAttribute("kart");
		
		RequestDispatcher rd=request.getRequestDispatcher("PlaceOrder.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		List<Cart> list=(List<Cart>) session.getAttribute("kart");//gets all the attributes of  the kart session
		session.getAttribute("userid");
		//System.out.println(list.get(0).getItemId());

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String bill=request.getParameter("bill");
		
		//String go=request.getParameter("location");
		for(Cart cartItem:list)
		{
			
		}
		
		
		
	}

}
