package com.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  DisplayRemainingProduct  extends DisplayProductList{
	
	
	public void getRemainingProductQuantity(int Customerquantity,int Productid) throws SQLException {
		 PreparedStatement PreparedStatement1=null;
		 PreparedStatement preparedStatement=null;
		 PreparedStatement preparedStatement3=null;
		 ResultSet resultset1=null;
		int Remainingquantity=0;
		int ok=0;
		
		try {
			
		Jdbcconnectivity jdbcconnectivity =new Jdbcconnectivity();
		Connection connection =jdbcconnectivity.getConnection();
		
		PreparedStatement1=connection.prepareStatement("select  quantity from productdetails where Id=(?)");
		PreparedStatement1.setInt(1, Productid);
		ResultSet ss=PreparedStatement1.executeQuery();
		while(ss.next()) {
			 ok= ss.getInt(1);
			}
		
		Remainingquantity=ok-Customerquantity;
		 
		
		 preparedStatement=connection.prepareStatement("update productdetails  set quantity=(?) where Id=(?)");
		preparedStatement.setInt(1, Remainingquantity);
		preparedStatement.setInt(2, Productid);
		int i=preparedStatement.executeUpdate();
		System.out.println("--------------- Remaining Products"+i);
		
	 preparedStatement3=connection.prepareStatement("Select  name,Id,quantity from productdetails");
	 resultset1=preparedStatement3.executeQuery();
	System.out.println( " Product_Name"+"         "+"Product_Id"+"   "+"RemainingQuantity");
	while(resultset1.next()) {
		System.out.println(""+resultset1.getString(1)+"                 "+resultset1.getInt(2)+"                     "+resultset1.getInt(3));
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
	}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			PreparedStatement1.close();
			 preparedStatement.close();
			 preparedStatement3.close();
			  resultset1.close();
			
			
			
		}
	}
	
	
	
		
	}
	
