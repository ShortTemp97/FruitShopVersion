package com.fixitytech.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.fixitytech.bean.Cart;
import com.fixitytech.bean.Item;
import com.fixitytech.bean.OrderItem;

public class ItemsDAO {
	
	public List<Item> viewAllItems()throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from items;");
		ResultSet rs=ps.executeQuery();
		List<Item> items=new Vector<Item>();
		
		while(rs.next())
		{
			Item it=new Item();
			it.setItemId(rs.getInt(1));
			it.setItemName(rs.getString(2));
			it.setPrice(rs.getDouble(3));
			
			items.add(it);
		}
		return items;
	}
	
	int addItems(String name,double amount)throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into items(name,price) values (?,?)");
		ps.setString(1,name);
		ps.setDouble(2, amount);
		
		int n=ps.executeUpdate();
		
		return n;
	}
	
	public Cart checkItem(int id)throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from items where id="+id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			Cart it=new Cart();
			it.setItemId(rs.getInt(1));
			it.setItemName(rs.getString(2));
			it.setPrice(rs.getDouble(3));
			it.setQuantity(1);
			
			return it;
		}
		return null;
	}
	
	public int addNewItem(Item item)throws Exception
	{
		Connection con=ConnectionDAO.getConnection();
		
		PreparedStatement ps=con.prepareStatement("Insert into items (name,price) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1,item.getItemName());
		ps.setDouble(2, item.getPrice());
		
		int n=ps.executeUpdate();
		if(n>0)
		{
			ResultSet rs=ps.getGeneratedKeys();
			rs.next();
			int itemid=rs.getInt(1);
			
			return itemid;
		}
		
		return -1;
	}

	public List<Item> getSearchedItems(String itemName)throws Exception {
		
		Connection con=ConnectionDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from items where name like ? or name like ?");
		ps.setString(1,itemName+"%");
		ps.setString(2,"%"+itemName);
		
		ResultSet rs=ps.executeQuery();
		List<Item> list=new ArrayList<Item>();
		
		while(rs.next())
		{
			Item item=new Item();
			item.setItemId(rs.getInt(1));
			item.setItemName(rs.getString(2));
			item.setPrice(rs.getDouble(3));
			
			list.add(item);
		}
		
		return list;
	}
	
}
