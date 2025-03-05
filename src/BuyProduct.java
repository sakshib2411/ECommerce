package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyProduct {
	
	public  void buyProduct(String productname,int quantity,int id,int Productid) throws SQLException {
		
	
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement1=null;
		PreparedStatement preparedStatement2=null;
		ResultSet resultSet=null;
		try {
		Jdbcconnectivity jdbc=new Jdbcconnectivity();
		Connection  connnection=jdbc.getConnection();
		preparedStatement=connnection.prepareStatement("update customerregistration set Productname=(?),Quantity=(?) where Customer_Id=(?)");
		
		preparedStatement.setString(1, productname);
		preparedStatement.setInt(2, quantity);
		preparedStatement.setInt(3, id);
		
		int i=preparedStatement.executeUpdate();
		System.out.println("-----------      Product Buy Successfully    ------------"+i);
		System.out.println(" ");
		System.out.println("-------------------------------------------------------------");
		
		
		System.out.println("           Product Added In Cart  ");
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("");
		preparedStatement1=connnection.prepareStatement("Select Id,name,description,price from productdetails where Id=(?)");
		preparedStatement1.setInt(1, Productid);
		  resultSet=preparedStatement1.executeQuery();
		
		while(resultSet.next()) {
			System.out.println("  Product_Id          =  "+ resultSet.getInt(1));
			System.out.println("  Product _Name       =  "+ resultSet.getString(2));
			System.out.println("  Product_Description =  "+ resultSet.getString(3));
			System.out.println("  Proudct_Price       =  "+ resultSet.getInt(4));
		}
		System.out.println("");
		System.out.println("---------   Total Bill Amount  -------- ");
		
		 
		int price;
		 int Total=0;
		 
		if(productname.equals("Nike") || productname.equals("nike")) {
			   price=5000;
			  Total=price*quantity;
			
			
			}else if(productname.equals("Adidas") || productname.equals("adidas")) {
				  price =5500;
				   Total=price*quantity;
				   
				 System.out.println("Total Bill ="+Total);
				
				
				}else if(productname.equals("Bata")|| productname.equals("bata")) {
					   price =4300;
					  Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Wooland")|| productname.equals("woodland")) {
					   price =4200;
					   Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Puma")|| productname.equals("puma")) {
					   price =5900;
					   Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Rebook")|| productname.equals("rebook")) {
					   price =5850;
					   Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Gucci")|| productname.equals("gucci")) {
					   price =5500;
					   Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Jordan")|| productname.equals("jordan")) {
					   price =4400;
					   Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
					 
				}else if(productname.equals("Sparx")|| productname.equals("sparx")) {
					   price =4300;
					  Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
				}else if(productname.equals("Lewis")|| productname.equals("lewis")) {
					   price =3900;
					  Total=price*quantity;
					 System.out.println("Total Bill ="+Total);
				}else {
					System.out.println("  Please Enter Correct Name  .... Input Name not matchwith productname ");
				}
		
		System.out.println("Total Bill   =  " + Total);
		
		preparedStatement2=connnection.prepareStatement("update customerregistration set Total=(?) where Customer_id=(?)");
		preparedStatement2.setInt(1, Total);
			
		preparedStatement2.setInt(2, id);
		preparedStatement2.executeUpdate();
		
         }catch(Exception e) {
			e.printStackTrace();
		}finally {
			preparedStatement.close();
			preparedStatement2.close();
			preparedStatement1.close();
			 resultSet.close();
		}
				}
	
		
	}
	
	


