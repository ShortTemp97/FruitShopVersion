package com.fixitytech.DAO;

import java.sql.Connection;

public class LocalOwnerDAO {

	public int addLocalOwner(String name, String description)throws Exception {

		Connection con=ConnectionDAO.getConnection();
		
		
		return 0;
	}

}
