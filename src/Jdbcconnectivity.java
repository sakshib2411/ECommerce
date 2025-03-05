package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbcconnectivity {
	
	
	public Connection getConnection() {
		Connection connnection=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 connnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "rushikesh@123");
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connnection;
		
	}
	
	
	

}
