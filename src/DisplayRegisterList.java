package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayRegisterList extends Jdbcconnectivity{
	
	
	
	public  void getDisplayRegistrationList() throws SQLException {
		
		PreparedStatement preparestatement=null;
		ResultSet resultset=null;
		Connection connection=null;
		try {
		 connection=super.getConnection();
		
		 preparestatement=connection.prepareStatement("select Customer_Id, Customer_name, Customer_Address,Customer_mobileNo from customerregistration");	
		 resultset=preparestatement.executeQuery();
		
		System.out.println("Customer_Id    "+"        Customer_Name    "+"    Cutomer_Address "+"   Customer_MobileNo");
		System.out.println(" ");
		while(resultset.next()) {
		System.out.println(""+resultset.getInt(1)+"                       "+resultset.getString(2)+"                "+resultset.getString(3)+"             "+resultset.getString(4));
		System.out.println("-------------------------------------------------------------------------------------------");
	}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
			preparestatement.close();
			resultset.close();
				}
	}
	
	
		public void getPurchaseHistory() throws SQLException {
			PreparedStatement preparestatement1=null;
			ResultSet resultset1=null;
			try {
			Connection connection1=super.getConnection();
			 preparestatement1=connection1.prepareStatement("Select * from customerregistration");
			 resultset1=preparestatement1.executeQuery();
			System.out.println("Customer_Id"+"       "+"Customer_Name"+"       "+"Customer_Address"+"      "+"Customer_MobileNumber"+"       "+"ProductName"+"       "+"Quantity"+"       "+"Total_Bill");
			while(resultset1.next())
			{
			System.out.println("    "+resultset1.getInt(1)+"              "+resultset1.getString(2)+"              "+resultset1.getString(3)+"             "+resultset1.getString(4)+"                 "+resultset1.getString(5)+"            "+resultset1.getInt(6)+"                "+resultset1.getInt(7));
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
				preparestatement1.close();
				resultset1.close();
			}
			
}
		
}
	
	
	
	


