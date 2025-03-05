package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayProductList {
	
	public void displayProductlist() throws SQLException {
		PreparedStatement preparedStatement=null;
		Connection connection=null;
		ResultSet resultset=null;
		try {
		Jdbcconnectivity jdbcconnectivity=new Jdbcconnectivity();
		connection=jdbcconnectivity.getConnection();
		preparedStatement=connection.prepareStatement("Select Id,name,description,price,quantity from productdetails  order by name asc");
		
		 resultset=preparedStatement.executeQuery();
		System.out.println("Product Id "+"     "+" Name of Products     "+" Description"+"               Price "+"                   Quantity");
		System.out.println("");

		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+"                    "+resultset.getString(2)+"               "+resultset.getString(3)+"                 "+resultset.getInt(4)+"                     "+resultset.getInt(5));
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
			
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		preparedStatement.close();
		resultset.close();
		
		
	}
		

}
	
	
	}
	
