package com.test;

import java.sql.SQLException;
import java.util.Scanner;
public class Mainmethod {
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("**********   WELCOME  TO SHOES  MART  **********");
		System.out.println(" ");
		
		System.out.println("---------------------------------------------------");
		
		// Customer Registration Section 
		System.out.println("*************    Customer Registration Section   *******************");
		System.out.println(" ");
		System.out.println("------------------------------------------------------------");
		System.out.println("     Please Fill Details  Below     ");
		System.out.println( " ");
		
		System.out.println("    Enter the Customer Id = ");
		int Customerid=sc.nextInt();
		sc.nextLine();
		
		System.out.println("    Enter the Customer FullName = ");
		String fullname=sc.nextLine();
		
		System.out.println("    Enter the Customer Address = ");
		String address=sc.nextLine();
		
		System.out.println("    Enter the Mobile No = ");
		String mobile=sc.next();
		
		CustomerRegistration cs=new CustomerRegistration();
		cs.getRegistration(Customerid, fullname, address, mobile);
		
		
		// Product List Details In Ascending Order-------
		System.out.println("*****************    Products List   ****************");
		System.out.println(" ");
		System.out.println("------------------------------------------------------------");
		System.out.println(" ");
		DisplayProductList ds=new DisplayProductList();
		ds.displayProductlist();
		
		
		
		// Customer Product Buying 
		
		System.out.println("Enter Product Name Want To Buy = ");
		String Productname=sc.next();
		System.out.println("Enter Quantity of Product = ");
		int Quantity =sc.nextInt();
		System.out.println("Enter Product Id = ");
		int ProductId=sc.nextInt();
		
		BuyProduct buyproduct=new BuyProduct();
		buyproduct.buyProduct(Productname, Quantity, Customerid,ProductId);
		System.out.println("------------------------------------");
		System.out.println(" ");
		
		
		// Admin Login Section
		
		System.out.println("**********        ADMIN  LOGIN   Section            ***********");
		System.out.println();
		//for(int i=0;i<=2;i++) {
		System.out.println("    Enter Admin UserName =");
		String AdminUser=sc.next();
		System.out.println("    Enter Password = ");
		String Password=sc.next();
		
		
		if(AdminUser.equals("Admin123")&& Password.equals("123")){	
		System.out.println("    Right Password.......");
		
		// Remaining Product List
		
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		System.out.println("*********      Remaining Product List     *********");
		System.out.println("");
		System.out.println("-------------------------------------------------------------");
		
		DisplayRemainingProduct displayRemainingProduct= new DisplayRemainingProduct();
		displayRemainingProduct.getRemainingProductQuantity(Quantity, ProductId);
		
		
		// Display Entire User Register List
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("***********    Customer  Registration  Details  List  ************");
		System.out.println("");
		System.out.println("------------------------------------------------------------------------");
		
		DisplayRegisterList displayregisterlist =new DisplayRegisterList();
		displayregisterlist.getDisplayRegistrationList();
		
		// Display Customer Product Purchase Details
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(" *******************      Customer  Product  Purchase History   ******************");
		System.out.println("");
		System.out.println("-----------------------------------------------------");
		displayregisterlist.getPurchaseHistory();
		
		sc.close();
		      
		}else {
			System.out.println("Wrong Password.......");
		}
		}
	
	
	}
//}
