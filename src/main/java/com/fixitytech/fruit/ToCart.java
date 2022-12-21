package com.fixitytech.fruit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fixitytech.DAO.ItemsDAO;
import com.fixitytech.bean.Cart;

/**
 * Servlet implementation class ToCart
 */
@WebServlet("/cart")
/*@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*10
		)*/
public class ToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ItemsDAO itemDAO;
    public ToCart() {
        super();
        itemDAO=new ItemsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId=Integer.valueOf(request.getParameter("id"));//converting the id to int and storing in itemId
		//System.out.println(itemId);
		//Part part=request.getPart("img");
		
		
		HttpSession session=request.getSession();//creating the session
		
		
		List<Cart> cart=(List)session.getAttribute("kart");//getting the session with key kart
		
		
		if(cart==null)//if the session kart is empty then create the list
			cart=new ArrayList<Cart>();
		boolean available=seeKart(itemId,cart);//check whether the kart contains any duplicate ids or not
		if(!available)//if item is not available then,
		{	
		try {
			Cart item=itemDAO.checkItem(itemId);//checking whether item available in shop
			if(item!=null)//if available in shop
			    
				{
				
				item.setQuantity(1);
				//Images
				String path=getServletContext().getRealPath("")+"/ItemImages";//get imgs and put in cartItems
				
				File file=new File(path+File.separator+itemId);
				
			String[] listFiles=file.list();
				
				if(listFiles!=null && listFiles.length>0)
				{
					String img=listFiles[0];
					//System.out.println(img);
					item.setImages("ItemImages"+File.separator+itemId+File.separator+img);
				}
			
				
				
				cart.add(item);//then add the item to shop
				session.setAttribute("kart",cart);//set the session attribute
			
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		response.sendRedirect("index");
	}

	private boolean seeKart(int itemId,List<Cart> cart) {
		
		for(Cart ct:cart)
		{
			if(ct.getItemId()==itemId)
			{
				
			ct.setQuantity(ct.getQuantity()+1);	
			
				return true;
			}
		}
		return false;
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
