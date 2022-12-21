package com.fixitytech.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fixitytech.bean.Users;

public class UsersDAO {
	
	public int addUser(Users user) throws SQLException, ClassNotFoundException
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("Insert into users values (?,?,?,?,?,?)");
		
		ps.setString(1, user.getFname());
		ps.setString(2, user.getLname());
		ps.setString(3, user.getDob());
		ps.setLong(4, user.getMobile());
		ps.setString(5,user.getEmail());
		ps.setString(6, user.getPassword());
		
		int n=ps.executeUpdate();
		return n;
	}

	public Users validate(String email, String password) {
		
		try {
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from users where mailId=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Users user=new Users();
				user.setFname(rs.getString(1));
				user.setLname(rs.getString(2));
				user.setDob(rs.getString(3));
				user.setMobile(rs.getInt(4));
				user.setEmail(rs.getString(5));
				
				return user;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
		
	}
	/*Users viewUserProfile()
	{
		
	}*/

	public List<Users> viewAllUsers()throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		List<Users> usersList=new ArrayList<Users>();
		PreparedStatement ps=con.prepareStatement("select firstname,lastname,dob,mobile,mailId from users");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Users user=new  Users();
			user.setFname(rs.getString(1));
			user.setLname(rs.getString(2));
			user.setDob(rs.getString(3));
			user.setMobile(rs.getLong(4));
			user.setEmail(rs.getString(5));
			
			usersList.add(user);
		}
		
		
		return usersList;
	}
}
