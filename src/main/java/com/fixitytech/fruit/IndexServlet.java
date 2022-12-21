package com.fixitytech.fruit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.DAO.ItemsDAO;
import com.fixitytech.bean.Item;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ItemsDAO itemDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        itemDAO=new ItemsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {//helps to print the list of items
			List<Item> list=itemDAO.viewAllItems();
			HttpSession session=request.getSession();
			 String path=getServletContext().getRealPath("")+"/ItemImages/";
		        for(Item it:list)
		        {
		            File file=new File(path+it.getItemId());
		            String names[]=file.list();
		            if(names!=null && names.length>0)//check whether the image is available or not
		            {
		            String name=names[0];
		        
		            it.setImages("ItemImages/"+it.getItemId()+"/"+name);
		            }
		            }
			//System.out.println(getServletContext().getRealPath(""));
			request.setAttribute("itemsList",list); 
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
