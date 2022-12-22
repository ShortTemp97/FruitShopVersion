package com.fixitytech.fruit;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fixitytech.DAO.LocalOwnerDAO;

/**
 * Servlet implementation class AddOwner
 */
@WebServlet("/addOwner")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*10
		)
public class AddOwner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	LocalOwnerDAO localOwnerdao;
	final static String imgFolder="owners";
    public AddOwner() {
        super();
        localOwnerdao=new LocalOwnerDAO();
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
		
		Part part=request.getPart("ownerpic");
		String name=request.getParameter("ownername");
		String description=request.getParameter("desc");
		
		int ownerId=localOwnerdao.addLocalOwner(name,description);
		
		String pic=getServletContext().getRealPath("")+File.separator+imgFolder;
		
		File file=new File(imgFolder+"/"+ownerId);
		if(!file.exists())
			file.mkdir();
		
		part.write(imgFolder+"/"+ownerId+"/"+part.getSubmittedFileName());
		
		
		
		
	}

}
