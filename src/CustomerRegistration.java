package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRegistration {
	
	
	public void getRegistration(int id,String Name,String Address,String Mobileno) throws SQLException {
		Connection connnection=null;
		PreparedStatement preparedstatement=null;
		try {
		Jdbcconnectivity jdbc=new Jdbcconnectivity();
		 connnection=jdbc.getConnection();
		 preparedstatement=connnection.prepareStatement("insert into customerregistration(Customer_Id,Customer_name,Customer_Address,Customer_mobileNo)values(?,?,?,?)");
		 preparedstatement.setInt(1, id);
		 preparedstatement.setString(2, Name);
		 preparedstatement.setString(3, Address);
		 preparedstatement.setString(4, Mobileno);
		
		int i=preparedstatement.executeUpdate();
		System.out.println("--------- Customer Data Register  Succesfullly   ----------"+i);
		System.out.println("  ");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			preparedstatement.close();
			
		}
		
	}
	
	
	
	
	
	

}
