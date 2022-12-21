package com.fixitytech.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private static Connection con;
	private ConnectionDAO()
	{
		
	}
	//singleton class for connection 
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 if(con==null)
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ekart","root","root");
		 
		 return con;
	}
}
