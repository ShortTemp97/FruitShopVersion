package com.fixitytech.fruit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.OrderDAO;
import com.fixitytech.bean.Cart;
import com.fixitytech.bean.Order;
import com.fixitytech.bean.OrderItem;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/placeOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	OrderDAO orderdao;
    public PlaceOrder() {
        super();
        orderdao=new OrderDAO();
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
		
		//System.out.println(name);
		Order order=new Order();
		List<OrderItem> ordersList=new ArrayList<>();
		//String go=request.getParameter("location");
		double total=0;
		for(Cart cartItem:list)
		{
			OrderItem orderItem=new OrderItem();
			
			orderItem.setItemId(cartItem.getItemId());
			orderItem.setItemName(cartItem.getItemName());
			//System.out.println(orderItem.getItemName());
			orderItem.setTotalAmt(cartItem.getSubAmt());
			
			total+=cartItem.getSubAmt();
			
			ordersList.add(orderItem);
			
		}
		//System.out.println(total);
		
		order.setCustomerName(name);
		order.setMail(email);
		order.setAddress(address);
		order.setMobile(mobile);
		order.setTotal(total);
		
		session.setAttribute("orderDetails", order);
		
		try {
			int orderId=orderdao.placeOrder(order, ordersList);
			if(orderId>0)
			{
				request.setAttribute("order", orderId);
				RequestDispatcher rd=request.getRequestDispatcher("OrderSuccess.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
