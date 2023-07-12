package com.highradius.connection;
import java.util.*;
import java.sql.*;

import com.highradius.model.*;

public class DatabaseConnection {
	public static List<Invoice> invoice_list=new ArrayList<Invoice>();
	
	public static List<Invoice> getInvoices () {
				return invoice_list;
	}
	
	public static void addInvoice (Invoice i1) {
		invoice_list.add(i1);
//		System.out.println(invoice_list.size());
	}

	
	public static  Connection connect() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/hrc";
        String username = "root";
        String password = "Ashu@3255";
        Connection connection=null;
        try{Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection(url, username, password);
        	Statement statement = connection.createStatement();
    		String sqlQuery = "SELECT * FROM h2h_oap;";
    		ResultSet resultSet = statement.executeQuery(sqlQuery);
    		DatabaseConnection.invoice_list.clear();	           
    				            while (resultSet.next()) {
    				            	
    					        
    				            	int sl_no=resultSet.getInt("Sl_no");
    				            	int cust_id= resultSet.getInt("CUSTOMER_ORDER_ID");
    				            	int sales_org=resultSet.getInt("SALES_ORG");
    				                String distribution_channel = resultSet.getString("DISTRIBUTION_CHANNEL");
    				                String division = resultSet.getString("DIVISION");
    				                double released_credit_value=resultSet.getDouble("RELEASED_CREDIT_VALUE");
    				                String purchase_order_type= resultSet.getString("PURCHASE_ORDER_TYPE");
    				                int company_code= resultSet.getInt("COMPANY_CODE");
    				                String order_creation_date= resultSet.getString("ORDER_CREATION_DATE");
    				                String order_creation_time= resultSet.getString("ORDER_CREATION_TIME");
    				                String credit_control_area= resultSet.getString("CREDIT_CONTROL_AREA");
    				                int sold_to_party= resultSet.getInt("SOLD_TO_PARTY");
    				                double order_amount=resultSet.getDouble("ORDER_AMOUNT");
    				                String requested_delivery_date= resultSet.getString("REQUESTED_DELIVERY_DATE");
    				                String order_currency= resultSet.getString("ORDER_CURRENCY");
    				                String credit_status= resultSet.getString("CREDIT_STATUS");
    				                int customer_number= resultSet.getInt("CUSTOMER_NUMBER");
    				                double amount_in_usd=resultSet.getDouble("AMOUNT_IN_USD");
    					            long unique_cust_id=resultSet.getLong("UNIQUE_CUST_ID");
    					
    					            Invoice i1=new Invoice(sl_no, cust_id,sales_org,distribution_channel,division,released_credit_value,
					        				purchase_order_type,company_code,order_creation_date,order_creation_time,credit_control_area,
					        				sold_to_party,order_amount,requested_delivery_date,
					        	            order_currency,credit_status,customer_number,amount_in_usd,unique_cust_id);
        		
    				            
    					            DatabaseConnection.addInvoice(i1);
    				            }
        	
        }catch(SQLException e) {
        	 e.printStackTrace();	
        }
        return connection;
	}
	
	
//	public static void main(String [] args) {
////	Connection connection= DatabaseConnection.connect();
//		List<Invoice>ls=new ArrayList<>();
//		try {
//		ls=DatabaseConnection.getInvoices();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(ls.toString());
//	}

//	public static void main(String [] args) {
//		
//		// Database connection parameters
//		        String url = "jdbc:mysql://localhost:3306/hrc";
//		        String username = "root";
//		        String password = "Ashu@3255";
//
//		        // Database query
//		        String query = "SELECT * FROM h2h_oap";
//		        Connection connection = null;
//		        Statement statement = null;
//		        ResultSet resultSet = null;
//		        DatabaseConnection db = new DatabaseConnection();
//		        try {
//		            connection = DriverManager.getConnection(url, username, password);
//		            statement = connection.createStatement();
//
//		            String sqlQuery = "SELECT * FROM h2h_oap limit 10;";
//		            resultSet = statement.executeQuery(sqlQuery);
//		           
//		            while (resultSet.next()) {
//		            	
////		            	Creating object of class Invoice
//				        Invoice in = new Invoice(0,0,0,"","",0.0,"",0,"","","",0,0.0,"","","",0,0.0,0);
//
////				       Storing the resultSet in variables
//				        
//		            	int sl_no=resultSet.getInt("Sl_no");
//		            	int cust_id= resultSet.getInt("CUSTOMER_ORDER_ID");
//		            	int sales_org=resultSet.getInt("SALES_ORG");
//		                String distribution_channel = resultSet.getString("DISTRIBUTION_CHANNEL");
//		                String division = resultSet.getString("DIVISION");
//		                double released_credit_value=resultSet.getDouble("RELEASED_CREDIT_VALUE");
//		                String purchase_order_type= resultSet.getString("PURCHASE_ORDER_TYPE");
//		                int company_code= resultSet.getInt("COMPANY_CODE");
//		                String order_creation_date= resultSet.getString("ORDER_CREATION_DATE");
//		                String order_creation_time= resultSet.getString("ORDER_CREATION_TIME");
//		                String credit_control_area= resultSet.getString("CREDIT_CONTROL_AREA");
//		                int sold_to_party= resultSet.getInt("SOLD_TO_PARTY");
//		                double order_amount=resultSet.getDouble("ORDER_AMOUNT");
//		                String requested_delivery_date= resultSet.getString("REQUESTED_DELIVERY_DATE");
//		                String order_currency= resultSet.getString("ORDER_CURRENCY");
//		                String credit_status= resultSet.getString("CREDIT_STATUS");
//		                int customer_number= resultSet.getInt("CUSTOMER_NUMBER");
//		                double amount_in_usd=resultSet.getDouble("AMOUNT_IN_USD");
//			            long unique_cust_id=resultSet.getLong("UNIQUE_CUST_ID");
//			            
////			           printing some of the variables
//			            
//			        	System.out.println("Sl_no: "+sl_no+"  Customer_order_id:  "+cust_id+"   amount: "+amount_in_usd);
//			        	
////		            calling setter method to initialize the data members of invoice class
//			        	 Invoice i1=new Invoice(sl_no, cust_id,sales_org,distribution_channel,division,released_credit_value,
//			        				purchase_order_type,company_code,order_creation_date,order_creation_time,credit_control_area,
//			        				sold_to_party,order_amount,requested_delivery_date,
//			        	            order_currency,credit_status,customer_number,amount_in_usd,unique_cust_id);
//			        	
//			        	
////			        	
////			        	in.setSl_no(sl_no);
////		                in.setCustomer_order_id(cust_id);
////		                in.setSales_org(sales_org);
////		                in.setDistribution_channel(distribution_channel);
////		                in.setDivision(division);
////		                in.setReleased_credit_value(released_credit_value);
////		                in.setPurchase_order_type(purchase_order_type);
////		                in.setCompany_code(company_code);
////		                in.setOrder_creation_date(order_creation_date);
////		                in.setOrder_creation_time(order_creation_time);
////		                in.setCredit_control_area(credit_control_area);
////		                in.setSold_to_party(sold_to_party);
////		                in.setOrder_amount(order_amount);
////		                in.setRequested_delivery_date(requested_delivery_date);
////		                in.setOrder_currency(order_currency);
////		                in.setCredit_status(credit_status);
////		                in.setCustomer_number(customer_number);
////		                in.setAmount_in_usd(amount_in_usd);
////		                in.setUnique_cust_id(unique_cust_id);
//
////		            adding object 'in' to List<Invoice>invoice_list using method addInvoice declared in DatabaseConnection 
//		            db.addInvoice(i1);
//		            
//		            
//		            
//		            }
//		            
//		            System.out.println(invoice_list.toString());
//		            System.out.println(db.getInvoices().toString());
//		           // System.out.println(DatabaseConnection.invoice_list.size());
//
//		            
//		        } catch (SQLException e) {
//		            e.printStackTrace();
//		        } 
//		
//	}
	
}
