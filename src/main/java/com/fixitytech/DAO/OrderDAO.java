package com.fixitytech.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fixitytech.bean.Order;
import com.fixitytech.bean.OrderItem;

public class OrderDAO {
	
	public int placeOrder(Order order,List<OrderItem> orderList)throws Exception
	{
		
		Connection con=ConnectionDAO.getConnection();
		con.setAutoCommit(false);
		PreparedStatement ps=con.prepareStatement("Insert into orders (customerName,orderDate,contactDetail,mail,totalAmount) values(?,Curdate(),?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		
		//ResultSet rs=ps.getGeneratedKeys();
		ps.setString(1, order.getCustomerName());
		ps.setLong(2, order.getMobile());
		ps.setString(3, order.getMail());
		ps.setDouble(4, order.getTotal());
		int m=0;
		int n=ps.executeUpdate();
		if(n>0)
		{
			ResultSet rs=ps.getGeneratedKeys();
			rs.next();
			int orderId=rs.getInt(1);
			
			PreparedStatement pst=con.prepareStatement("Insert into orderItems(orderid,itemName,Quantity,subTotal) values (?,?,?,?);");
			
			for(int i=0;i<orderList.size();i++)
			{
				pst.setInt(1, orderId);
				pst.setString(2, orderList.get(i).getItemName());
				pst.setInt(3,orderList.get(i).getQuantity());
				pst.setDouble(4,orderList.get(i).getSubAmt());
				
				m=pst.executeUpdate();
				
			}
			if(m>0 && n>0)
			{
				con.commit();
				return orderId;
			}
			
			
		}
		con.rollback();
		return -1;
	}
	
	public List<OrderItem> viewUserOrders(String mail) throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("Select orderid from orders where mail=?");
		ps.setString(1, mail);
		ResultSet rs=ps.executeQuery();
		
		List<OrderItem> orderlist=new ArrayList<OrderItem>();
		while(rs.next())
		{
			int orderId=rs.getInt(1);
			System.out.println(orderId);
		PreparedStatement pst=con.prepareStatement("select * from orderitems where orderid="+orderId);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		OrderItem orderItem=new OrderItem();
		
		orderItem.setOrderId(rst.getInt(1));
		orderItem.setItemName(rst.getString(2));
		orderItem.setQuantity(rst.getInt(3));
		orderItem.setTotalAmt(rst.getDouble(4));
		
		//System.out.println(rst.getDouble(4)+"<---");
		orderlist.add(orderItem);
		}
		
		
		}
		return orderlist;
		
	}

	public List<OrderItem> viewAllOrders()throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from orderitems ");
		ResultSet rs=ps.executeQuery();
		List<OrderItem> list=new ArrayList<OrderItem>();
		while(rs.next())
		{
			OrderItem order=new OrderItem();
			order.setOrderId(rs.getInt(1));
			order.setItemName(rs.getString(2));
			order.setQuantity(rs.getInt(3));
			order.setTotalAmt(rs.getDouble(4));
			order.setStatus(rs.getInt(5));
			list.add(order);
		}
		
		return list;
	}

	public int updateStatus(int id, int status,String name)throws Exception {
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("Update orderItems set status=? where orderid=? and itemname=?");
		ps.setInt(1, status);
		ps.setInt(2, id);
		ps.setString(3, name);
		
		int n=ps.executeUpdate();
		return n;
		
		
	}
	

	
}
